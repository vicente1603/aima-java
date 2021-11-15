package aima.gui.demo.probability;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aima.core.environment.cellworld.Cell;
import aima.core.environment.cellworld.CellWorld;
import aima.core.environment.cellworld.CellWorldAction;
import aima.core.environment.cellworld.CellWorldFactory;
import aima.core.probability.CategoricalDistribution;
import aima.core.probability.FiniteProbabilityModel;
import aima.core.probability.bayes.approx.BayesInferenceApproxAdapter;
import aima.core.probability.bayes.approx.GibbsAsk;
import aima.core.probability.bayes.approx.LikelihoodWeighting;
import aima.core.probability.bayes.approx.ParticleFiltering;
import aima.core.probability.bayes.approx.RejectionSampling;
import aima.core.probability.bayes.exact.EliminationAsk;
import aima.core.probability.bayes.exact.EnumerationAsk;
import aima.core.probability.bayes.model.FiniteBayesModel;
import aima.core.probability.example.BayesNetExampleFactory;
import aima.core.probability.example.DynamicBayesNetExampleFactory;
import aima.core.probability.example.ExampleRV;
import aima.core.probability.example.FullJointDistributionBurglaryAlarmModel;
import aima.core.probability.example.FullJointDistributionToothacheCavityCatchModel;
import aima.core.probability.example.GenericTemporalModelFactory;
import aima.core.probability.example.HMMExampleFactory;
import aima.core.probability.example.MDPFactory;
import aima.core.probability.hmm.exact.FixedLagSmoothing;
import aima.core.probability.mdp.MarkovDecisionProcess;
import aima.core.probability.mdp.Policy;
import aima.core.probability.mdp.impl.ModifiedPolicyEvaluation;
import aima.core.probability.mdp.search.PolicyIteration;
import aima.core.probability.mdp.search.ValueIteration;
import aima.core.probability.proposition.AssignmentProposition;
import aima.core.probability.proposition.DisjunctiveProposition;
import aima.core.probability.temporal.generic.ForwardBackward;
import aima.core.probability.util.ProbabilityTable;
import aima.core.util.MockRandomizer;

public class ProbabilityDemoFinalProject {
	
	public static final int NUM_SAMPLES = 1000;

	public static void main(String[] args) {

//		bayesEliminationAskDemo();
//		bayesRejectionSamplingDemo();
		bayesLikelihoodWeightingDemo();
		bayesGibbsAskDemo();
	}


	public static void bayesEliminationAskDemo() {
		System.out.println("DEMO: Bayes Elimination Ask");
		System.out.println("===========================");
		demoProjetoFinal(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjetoFinal_1(),
				new EliminationAsk()));
		System.out.println("===========================");
	}

	public static void bayesRejectionSamplingDemo() {
		System.out.println("DEMO: Bayes Rejection Sampling N = " + NUM_SAMPLES);
		System.out.println("==============================");
		demoProjetoFinal(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjetoFinal_1(),
				new BayesInferenceApproxAdapter(new RejectionSampling(),
						NUM_SAMPLES)));
		System.out.println("==============================");
	}

	public static void bayesLikelihoodWeightingDemo() {
		System.out.println("DEMO: Bayes Likelihood Weighting N = "
				+ NUM_SAMPLES);
		System.out.println("================================");
		demoProjetoFinal(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjetoFinal_1(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(),
						NUM_SAMPLES)));
		System.out.println("================================");
	}

	public static void bayesGibbsAskDemo() {
		System.out.println("DEMO: Bayes Gibbs Ask N = " + NUM_SAMPLES);
		System.out.println("=====================");
		demoProjetoFinal(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjetoFinal_1(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES)));
		System.out.println("=====================");
	}


	//
	// PRIVATE METHODS
	//

	private static void demoProjetoFinal(FiniteProbabilityModel model) {
		System.out.println("--------------------");		
		
		//projeto final

		AssignmentProposition a1 = new AssignmentProposition(
				ExampleRV.AGE_RV, "0-30" );
		AssignmentProposition a2 = new AssignmentProposition(
				ExampleRV.AGE_RV, "31-40");		
		AssignmentProposition a3 = new AssignmentProposition(
				ExampleRV.AGE_RV, "41-100");	
		AssignmentProposition b1 = new AssignmentProposition(
				ExampleRV.NATIONALITY_RV, Boolean.TRUE);	
		AssignmentProposition b2 = new AssignmentProposition(
				ExampleRV.NATIONALITY_RV,  Boolean.FALSE);	
		AssignmentProposition c1 = new AssignmentProposition(
				ExampleRV.SPORTS_RV, Boolean.TRUE);	
		AssignmentProposition c2 = new AssignmentProposition(
				ExampleRV.SPORTS_RV,  Boolean.FALSE);	
		AssignmentProposition d1 = new AssignmentProposition(
				ExampleRV.WATCH_TV_RV, "a_lot" );
		AssignmentProposition d2 = new AssignmentProposition(
				ExampleRV.WATCH_TV_RV, "some");		
		AssignmentProposition d3 = new AssignmentProposition(
				ExampleRV.WATCH_TV_RV, "none");

		System.out.println("P(a1, b2, c1, d1) = "
				+ model.prior(b1,a2,c1,d1));
		
		System.out
		.println("P<>(c1 = true | a2 = true, b1 = true, d2= true) = "
				+ model.posteriorDistribution(ExampleRV.SPORTS_RV,
						a2, b1, d2));

	}
}

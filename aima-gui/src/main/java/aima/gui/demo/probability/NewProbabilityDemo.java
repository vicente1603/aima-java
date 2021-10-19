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

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class NewProbabilityDemo {
	
	public static final int NUM_SAMPLES = 1000;

	public static void main(String[] args) {

		bayesEliminationAskDemo();
		bayesRejectionSamplingDemo();
		bayesLikelihoodWeightingDemo();
		bayesGibbsAskDemo();
	}


	public static void bayesEliminationAskDemo() {
		System.out.println("DEMO: Bayes Elimination Ask");
		System.out.println("===========================");
		demoGuia04(new FiniteBayesModel(
				BayesNetExampleFactory.constructGuia04(),
				new EliminationAsk()));
		System.out.println("===========================");
	}

	public static void bayesRejectionSamplingDemo() {
		System.out.println("DEMO: Bayes Rejection Sampling N = " + NUM_SAMPLES);
		System.out.println("==============================");
		demoGuia04(new FiniteBayesModel(
				BayesNetExampleFactory.constructGuia04(),
				new BayesInferenceApproxAdapter(new RejectionSampling(),
						NUM_SAMPLES)));
		System.out.println("==============================");
	}

	public static void bayesLikelihoodWeightingDemo() {
		System.out.println("DEMO: Bayes Likelihood Weighting N = "
				+ NUM_SAMPLES);
		System.out.println("================================");
		demoGuia04(new FiniteBayesModel(
				BayesNetExampleFactory.constructGuia04(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(),
						NUM_SAMPLES)));
		System.out.println("================================");
	}

	public static void bayesGibbsAskDemo() {
		System.out.println("DEMO: Bayes Gibbs Ask N = " + NUM_SAMPLES);
		System.out.println("=====================");
		demoGuia04(new FiniteBayesModel(
				BayesNetExampleFactory.constructGuia04(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES)));
		System.out.println("=====================");
	}


	//
	// PRIVATE METHODS
	//

	private static void demoGuia04(FiniteProbabilityModel model) {
		System.out.println("--------------------");		
		
		//guia 04

		AssignmentProposition aInfringiuLeiEleitoral = new AssignmentProposition(
				ExampleRV.INFRIGIULEIELEITOTAL_RV, Boolean.TRUE);
		AssignmentProposition anotInfringiuLeiEleitoral = new AssignmentProposition(
				ExampleRV.INFRIGIULEIELEITOTAL_RV, Boolean.FALSE);
		AssignmentProposition aIndiciado = new AssignmentProposition(
				ExampleRV.INDICIADO_RV, Boolean.TRUE);
		AssignmentProposition anotIndiciado = new AssignmentProposition(
				ExampleRV.INDICIADO_RV, Boolean.FALSE);
		AssignmentProposition aPromotorPoliticamenteMotivado = new AssignmentProposition(
				ExampleRV.PROMOTORPOLITICAMENTEMOTIVADO_RV, Boolean.TRUE);
		AssignmentProposition anotPromotorPoliticamenteMotivado = new AssignmentProposition(
				ExampleRV.PROMOTORPOLITICAMENTEMOTIVADO_RV, Boolean.FALSE);
		AssignmentProposition aConsideradoCulpado = new AssignmentProposition(
				ExampleRV.CONSIDERADOCULPADO_RV, Boolean.TRUE);
		AssignmentProposition anotConsideradoCulpado = new AssignmentProposition(
				ExampleRV.CONSIDERADOCULPADO_RV, Boolean.FALSE);
		AssignmentProposition aPreso = new AssignmentProposition(
				ExampleRV.PRESO_RV, Boolean.TRUE);
		AssignmentProposition anotPreso = new AssignmentProposition(
				ExampleRV.PRESO_RV, Boolean.FALSE);
		

		System.out.println("P(b,i,~m,g,j) = "
				+ model.prior(aInfringiuLeiEleitoral, aIndiciado, anotPromotorPoliticamenteMotivado, aConsideradoCulpado, aPreso));
		
		System.out
		.println("P<>(Preso | InfrigiuLei = true, Indiciado = true, PromotorMotivado= true) = "
				+ model.posteriorDistribution(ExampleRV.PRESO_RV,
						aInfringiuLeiEleitoral, aIndiciado, aPromotorPoliticamenteMotivado));

	}
}

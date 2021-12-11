package aima.gui.demo.probability;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import aima.core.environment.cellworld.Cell;
import aima.core.environment.cellworld.CellWorld;
import aima.core.environment.cellworld.CellWorldAction;
import aima.core.environment.cellworld.CellWorldFactory;
import aima.core.probability.CategoricalDistribution;
import aima.core.probability.FiniteProbabilityModel;
import aima.core.probability.RandomVariable;
import aima.core.probability.bayes.BayesianNetwork;
import aima.core.probability.bayes.FiniteNode;
import aima.core.probability.bayes.approx.BayesInferenceApproxAdapter;
import aima.core.probability.bayes.approx.GibbsAsk;
import aima.core.probability.bayes.approx.LikelihoodWeighting;
import aima.core.probability.bayes.approx.ParticleFiltering;
import aima.core.probability.bayes.approx.PriorSample;
import aima.core.probability.bayes.approx.RejectionSampling;
import aima.core.probability.bayes.exact.EliminationAsk;
import aima.core.probability.bayes.exact.EnumerationAsk;
import aima.core.probability.bayes.impl.BayesNet;
import aima.core.probability.bayes.impl.FullCPTNode;
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
import aima.core.probability.proposition.Proposition;
import aima.core.probability.temporal.generic.ForwardBackward;
import aima.core.probability.util.ProbabilityTable;
import aima.core.util.MockRandomizer;

public class WorldCupProbabilityDemo {

	public static final int NUM_SAMPLES = 1000000;

	public static void main(String[] args) {

		bayesLikelihoodWeightingDemo();

	}

	public static void bayesLikelihoodWeightingDemo() {
		System.out.println("World Cup: Bayes Likelihood Weighting N = "
				+ NUM_SAMPLES);
		System.out.println("================================");
		demoProjetoFinal(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjetoFinal_A(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(),
						NUM_SAMPLES)));
		System.out.println("================================ \n");
	}
	
	public static void demoProjetoFinal(FiniteProbabilityModel model){
		
		AssignmentProposition a1 = new AssignmentProposition(
				ExampleRV.AGE_RV, "a1");
		AssignmentProposition a2 = new AssignmentProposition(
				ExampleRV.AGE_RV, "a2");
		AssignmentProposition a3 = new AssignmentProposition(
				ExampleRV.AGE_RV, "a3");
		
		AssignmentProposition b1 = new AssignmentProposition(
				ExampleRV.NATIONALITY_RV, "b1");
		AssignmentProposition b2 = new AssignmentProposition(
				ExampleRV.NATIONALITY_RV, "b2");
		
		AssignmentProposition c1 = new AssignmentProposition(
				ExampleRV.SPORTS_RV, "c1");
		AssignmentProposition c2 = new AssignmentProposition(
				ExampleRV.SPORTS_RV, "c2");
		
		AssignmentProposition d1 = new AssignmentProposition(
				ExampleRV.WATCH_TV_RV, "d1");
		AssignmentProposition d2 = new AssignmentProposition(
				ExampleRV.WATCH_TV_RV, "d2");
		AssignmentProposition d3 = new AssignmentProposition(
				ExampleRV.WATCH_TV_RV, "d3");		
				
		System.out.printf(" P<>(a1, b2, c1, d1) =  %.2f\n",
				+ model.prior(b2, a1, c1, d1));
		
		System.out.printf(" P<>(Likes soccer | a2 = true, b1 = true, d2= true) =  %.2f\n",
				+ model.posterior(c1, b1, a2, d2));
		
		System.out.printf(" P<>(Likes soccer | a3 = true, d3= true) =  %.2f\n",
				+model.posterior(c1, a3, d3));
	
	}
	
}
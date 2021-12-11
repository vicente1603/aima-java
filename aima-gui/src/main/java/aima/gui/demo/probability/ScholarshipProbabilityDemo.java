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

public class ScholarshipProbabilityDemo {
	
	public static final int NUM_SAMPLES = 1000;

	public static void main(String[] args) {


//		bayesLikelihoodWeightingDemo();
		bayesGibbsAskDemo();
	}

	public static void bayesLikelihoodWeightingDemo() {
		System.out.println("Scholarship: Bayes Likelihood Weighting N = "
				+ NUM_SAMPLES);
		System.out.println("================================");
		demoProjetoFinal(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjetoFinal_B(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(),
						NUM_SAMPLES)));
		System.out.println("================================");
	}

	public static void bayesGibbsAskDemo() {
		System.out.println("Scholarship: Bayes Gibbs Ask N = " + NUM_SAMPLES);
		System.out.println("=====================");
		demoProjetoFinal(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjetoFinal_B(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES)));
		System.out.println("=====================");
	}


	//
	// PRIVATE METHODS
	//

	private static void demoProjetoFinal(FiniteProbabilityModel model) {
		System.out.println("--------------------");		
		
		//projeto final - problema b


		AssignmentProposition aTrabalho = new AssignmentProposition(
				ExampleRV.TRABALHO_RV, Boolean.TRUE);	
		AssignmentProposition anotTrabalho = new AssignmentProposition(
				ExampleRV.TRABALHO_RV,  Boolean.FALSE);
		AssignmentProposition aConjuge = new AssignmentProposition(
				ExampleRV.CONJUGE_RV, Boolean.TRUE);	
		AssignmentProposition anotConjuge = new AssignmentProposition(
				ExampleRV.CONJUGE_RV,  Boolean.FALSE);
		AssignmentProposition aIrmao = new AssignmentProposition(
				ExampleRV.IRMAO_RV, Boolean.TRUE);	
		AssignmentProposition anotIrmao = new AssignmentProposition(
				ExampleRV.IRMAO_RV,  Boolean.FALSE);
		AssignmentProposition aImovel = new AssignmentProposition(
				ExampleRV.IMOVEL_RV, Boolean.TRUE);	
		AssignmentProposition anotImovel = new AssignmentProposition(
				ExampleRV.IMOVEL_RV,  Boolean.FALSE);
		AssignmentProposition aDoencaGrave = new AssignmentProposition(
				ExampleRV.DOENCA_GRAVE_RV, Boolean.TRUE);	
		AssignmentProposition anotDoencaGrave = new AssignmentProposition(
				ExampleRV.DOENCA_GRAVE_RV,  Boolean.FALSE);
		
		AssignmentProposition umaTresSM = new AssignmentProposition(
				ExampleRV.RENDA_FAMILIAR_RV, "UmaTresSM" );
		AssignmentProposition quatroaDez = new AssignmentProposition(
				ExampleRV.RENDA_FAMILIAR_RV, "QuatroaDez" );
		AssignmentProposition dezAcimaSM = new AssignmentProposition(
				ExampleRV.RENDA_FAMILIAR_RV, "DezAcimaSM" );
		
		AssignmentProposition escolaPublica = new AssignmentProposition(
				ExampleRV.SEGUNDO_GRAU_RV, "EscolaPublica" );
		AssignmentProposition escolaParticular = new AssignmentProposition(
				ExampleRV.SEGUNDO_GRAU_RV, "EscolaParticular" );
		
		AssignmentProposition primeiraQui = new AssignmentProposition(
				ExampleRV.FASE_RV, "PrimeiraQui" );
		AssignmentProposition quintaSetima = new AssignmentProposition(
				ExampleRV.FASE_RV, "QuintaSetima" );
		AssignmentProposition acimaSetima = new AssignmentProposition(
				ExampleRV.FASE_RV, "AcimaSetima" );
		
		AssignmentProposition lages = new AssignmentProposition(
				ExampleRV.RESIDE_RV, "Lages" );
		AssignmentProposition foraDeLages = new AssignmentProposition(
				ExampleRV.RESIDE_RV, "ForaDeLages" );
		
		AssignmentProposition dez = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "Dez" );
		AssignmentProposition quinze = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "Quinze" );
		AssignmentProposition vinte = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "Vinte" );
		AssignmentProposition vinteCinco = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "VinteCinco" );
		AssignmentProposition trinta = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "Trinta" );
		AssignmentProposition trintaeCinco = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "TrintaeCinco" );
		AssignmentProposition quarenta = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "Quarenta" );
		AssignmentProposition quarentaeCinco = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "QuarentaeCinco" );
		AssignmentProposition cinquenta = new AssignmentProposition(
				ExampleRV.BOLSA_RV, "Cinquenta" );	
		
		
		System.out.println("P(trabalha) = "
				+ model.prior(aTrabalho));
		
	}
}

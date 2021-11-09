package aima.core.probability.example;

import aima.core.probability.bayes.BayesianNetwork;
import aima.core.probability.bayes.FiniteNode;
import aima.core.probability.bayes.impl.BayesNet;
import aima.core.probability.bayes.impl.FullCPTNode;

/**
 * 
 * @author Ciaran O'Reilly
 *
 */
public class BayesNetExampleFactory {
	public static BayesianNetwork construct2FairDiceNetwor() {
		FiniteNode dice1 = new FullCPTNode(ExampleRV.DICE_1_RV, new double[] {
				1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0,
				1.0 / 6.0 });
		FiniteNode dice2 = new FullCPTNode(ExampleRV.DICE_2_RV, new double[] {
				1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0,
				1.0 / 6.0 });

		return new BayesNet(dice1, dice2);
	}

	public static BayesianNetwork constructToothacheCavityCatchNetwork() {
		FiniteNode cavity = new FullCPTNode(ExampleRV.CAVITY_RV, new double[] {
				0.2, 0.8 });
		@SuppressWarnings("unused")
		FiniteNode toothache = new FullCPTNode(ExampleRV.TOOTHACHE_RV,
				new double[] {
						// C=true, T=true
						0.6,
						// C=true, T=false
						0.4,
						// C=false, T=true
						0.1,
						// C=false, T=false
						0.9

				}, cavity);
		@SuppressWarnings("unused")
		FiniteNode catchN = new FullCPTNode(ExampleRV.CATCH_RV, new double[] {
				// C=true, Catch=true
				0.9,
				// C=true, Catch=false
				0.1,
				// C=false, Catch=true
				0.2,
				// C=false, Catch=false
				0.8 }, cavity);

		return new BayesNet(cavity);
	}

	public static BayesianNetwork constructToothacheCavityCatchWeatherNetwork() {
		FiniteNode cavity = new FullCPTNode(ExampleRV.CAVITY_RV, new double[] {
				0.2, 0.8 });
		@SuppressWarnings("unused")
		FiniteNode toothache = new FullCPTNode(ExampleRV.TOOTHACHE_RV,
				new double[] {
						// C=true, T=true
						0.6,
						// C=true, T=false
						0.4,
						// C=false, T=true
						0.1,
						// C=false, T=false
						0.9

				}, cavity);
		@SuppressWarnings("unused")
		FiniteNode catchN = new FullCPTNode(ExampleRV.CATCH_RV, new double[] {
				// C=true, Catch=true
				0.9,
				// C=true, Catch=false
				0.1,
				// C=false, Catch=true
				0.2,
				// C=false, Catch=false
				0.8 }, cavity);
		FiniteNode weather = new FullCPTNode(ExampleRV.WEATHER_RV,
				new double[] {
						// sunny
						0.6,
						// rain
						0.1,
						// cloudy
						0.29,
						// snow
						0.01 });

		return new BayesNet(cavity, weather);
	}

	public static BayesianNetwork constructMeningitisStiffNeckNetwork() {
		FiniteNode meningitis = new FullCPTNode(ExampleRV.MENINGITIS_RV,
				new double[] { 1.0 / 50000.0, 1.0 - (1.0 / 50000.0) });
		@SuppressWarnings("unused")
		FiniteNode stiffneck = new FullCPTNode(ExampleRV.STIFF_NECK_RV,
				new double[] {
						// M=true, S=true
						0.7,
						// M=true, S=false
						0.3,
						// M=false, S=true
						0.009986199723994478,
						// M=false, S=false
						0.9900138002760055

				}, meningitis);
		return new BayesNet(meningitis);
	}

	//guia04
	
	public static BayesianNetwork constructGuia04() {
		FiniteNode infrigiuLeiEleitoral = new FullCPTNode(ExampleRV.INFRIGIULEIELEITOTAL_RV,
				new double[] { 0.9, 0.1 });
		FiniteNode promotorPoliticamenteMotivado = new FullCPTNode(ExampleRV.PROMOTORPOLITICAMENTEMOTIVADO_RV,
				new double[] { 0.1, 0.9 });
		FiniteNode indiciado = new FullCPTNode(ExampleRV.INDICIADO_RV, new double[] {
				// B=true, M=true, I=true
				0.9,
				// B=true, M=true, I=false
				0.1,
				// B=true, M=false, I=true
				0.5,
				// B=true, M=false, I=false
				0.5,
				// B=false, M=true, I=true
				0.5,
				// B=false, M=true, I=false
				0.5,
				// B=false, M=false, I=true
				0.1,
				// B=false, E=false, A=false
				0.9 }, infrigiuLeiEleitoral, promotorPoliticamenteMotivado);
		@SuppressWarnings("unused")
		FiniteNode culpado = new FullCPTNode(ExampleRV.CONSIDERADOCULPADO_RV,
				new double[] {
						// B=true, I=true, M=true, G= true
						0.9,
						// B=true, I=true, M=true, G=false
						0.1,
						// B=true, I=true, M=false, G=true
						0.8,
						// B=true, I=true, M=false, G=false
						0.2,
						// B=true, I=false, M=true, G=true
						0.0,
						// B=true, I=false, M=true, G=false
						1.0,
						// B=true, I=false, M=false, G=true
						0.0,
						// B=true, I=false, M=false, G=false
						1.0,
						// B=false, I=true, M=true, G=true
						0.2,
						// B=false, I=true, M=true, G=false
						0.8,
						// B=false, I=true, M=false, G=true
						0.1,
						// B=false, I=true, M=false, G=false
						0.9,
						// B=false, I=false, M=true, G=true
						0.0,
						// B=false, I=false, M=true, G=false
						1.0,
						// B=false, I=false, M=false, G=true
						0.0,
						// B=false, I=false, M=false, G=false
						1.0}, infrigiuLeiEleitoral, indiciado, promotorPoliticamenteMotivado);
		@SuppressWarnings("unused")
		FiniteNode preso = new FullCPTNode(ExampleRV.PRESO_RV,
				new double[] {
						// G=true, J=true
						0.9,
						// G=true, J=false
						0.1,
						// G=false, J=true
						0.0,
						// G=false, J=false
						1.0 }, culpado);

		return new BayesNet(infrigiuLeiEleitoral, indiciado, promotorPoliticamenteMotivado, culpado, preso);
	}

	public static BayesianNetwork constructBurglaryAlarmNetwork() {
		FiniteNode burglary = new FullCPTNode(ExampleRV.BURGLARY_RV,
				new double[] { 0.001, 0.999 });
		FiniteNode earthquake = new FullCPTNode(ExampleRV.EARTHQUAKE_RV,
				new double[] { 0.002, 0.998 });
		FiniteNode alarm = new FullCPTNode(ExampleRV.ALARM_RV, new double[] {
				// B=true, E=true, A=true
				0.95,
				// B=true, E=true, A=false
				0.05,
				// B=true, E=false, A=true
				0.94,
				// B=true, E=false, A=false
				0.06,
				// B=false, E=true, A=true
				0.29,
				// B=false, E=true, A=false
				0.71,
				// B=false, E=false, A=true
				0.001,
				// B=false, E=false, A=false
				0.999 }, burglary, earthquake);
		@SuppressWarnings("unused")
		FiniteNode johnCalls = new FullCPTNode(ExampleRV.JOHN_CALLS_RV,
				new double[] {
						// A=true, J=true
						0.90,
						// A=true, J=false
						0.10,
						// A=false, J=true
						0.05,
						// A=false, J=false
						0.95 }, alarm);
		@SuppressWarnings("unused")
		FiniteNode maryCalls = new FullCPTNode(ExampleRV.MARY_CALLS_RV,
				new double[] {
						// A=true, M=true
						0.70,
						// A=true, M=false
						0.30,
						// A=false, M=true
						0.01,
						// A=false, M=false
						0.99 }, alarm);

		return new BayesNet(burglary, earthquake);
	}
	
	public static BayesianNetwork constructProjetoFinal_1() {
		
		FiniteNode age = new FullCPTNode(ExampleRV.AGE_RV,
				new double[] { 
						//a1
						0.3,
						//a2
						0.6,
						//a3
						0.1
		});
		
		FiniteNode nationality = new FullCPTNode(ExampleRV.NATIONALITY_RV,
				new double[] {
						//b1=true, b2=false
						0.2, 
						//b1=false b2=true
						0.8,
						
		});
		
//		FiniteNode sports = new FullCPTNode(ExampleRV.SPORTS_RV,
//				new double[] {
//						//c1|a1,b1
//						0.5,
//						//c1|a1,b2
//						0.7,
//						//c1|a2,b1
//						0.6,
//						//c1|a2,b2
//						0.8,
//						//c1|a3,b1
//						0.4,
//						//c1|a3,b2
//						0.1,
//						//c2|a1,b1
//						0.5,
//						//c2|a1,b2
//						0.3,
//						//c2|a2,b1
//						0.4,
//						//c2|a2,b2
//						0.2,
//						//c2|a3,b1
//						0.6,
//						//c2|a3,b2
//						0.9
//						});
		
//		FiniteNode watch_tv = new FullCPTNode(ExampleRV.WATCH_TV_RV,
//				new double[] {
//						//d1|c1
//						0.7,
//						//d1|c2
//						0.5,
//						//d2|c1
//						0.2,
//						//d2|c2
//						0.3,
//						//d3|c1
//						0.1,
//						//d3|c2
//						0.2,
//						});
		
		return new BayesNet(nationality, age);
	}

	public static BayesianNetwork constructCloudySprinklerRainWetGrassNetwork() {
		FiniteNode cloudy = new FullCPTNode(ExampleRV.CLOUDY_RV, new double[] {
				0.5, 0.5 });
		FiniteNode sprinkler = new FullCPTNode(ExampleRV.SPRINKLER_RV,
				new double[] {
						// Cloudy=true, Sprinkler=true
						0.1,
						// Cloudy=true, Sprinkler=false
						0.9,
						// Cloudy=false, Sprinkler=true
						0.5,
						// Cloudy=false, Sprinkler=false
						0.5 }, cloudy);
		FiniteNode rain = new FullCPTNode(ExampleRV.RAIN_RV, new double[] {
				// Cloudy=true, Rain=true
				0.8,
				// Cloudy=true, Rain=false
				0.2,
				// Cloudy=false, Rain=true
				0.2,
				// Cloudy=false, Rain=false
				0.8 }, cloudy);
		@SuppressWarnings("unused")
		FiniteNode wetGrass = new FullCPTNode(ExampleRV.WET_GRASS_RV,
				new double[] {
						// Sprinkler=true, Rain=true, WetGrass=true
						.99,
						// Sprinkler=true, Rain=true, WetGrass=false
						.01,
						// Sprinkler=true, Rain=false, WetGrass=true
						.9,
						// Sprinkler=true, Rain=false, WetGrass=false
						.1,
						// Sprinkler=false, Rain=true, WetGrass=true
						.9,
						// Sprinkler=false, Rain=true, WetGrass=false
						.1,
						// Sprinkler=false, Rain=false, WetGrass=true
						0.0,
						// Sprinkler=false, Rain=false, WetGrass=false
						1.0 }, sprinkler, rain);

		return new BayesNet(cloudy);
	}
}

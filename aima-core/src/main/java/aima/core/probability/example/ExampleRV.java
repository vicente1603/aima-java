package aima.core.probability.example;

import aima.core.probability.domain.ArbitraryTokenDomain;
import aima.core.probability.domain.BooleanDomain;
import aima.core.probability.domain.FiniteIntegerDomain;
import aima.core.probability.util.RandVar;

/**
 * Predefined example Random Variables from AIMA3e.
 * 
 * @author Ciaran O'Reilly
 */
public class ExampleRV {
	//
	public static final RandVar DICE_1_RV = new RandVar("Dice1",
			new FiniteIntegerDomain(1, 2, 3, 4, 5, 6));
	public static final RandVar DICE_2_RV = new RandVar("Dice2",
			new FiniteIntegerDomain(1, 2, 3, 4, 5, 6));
	//
	public static final RandVar TOOTHACHE_RV = new RandVar("Toothache",
			new BooleanDomain());
	public static final RandVar CAVITY_RV = new RandVar("Cavity",
			new BooleanDomain());
	public static final RandVar CATCH_RV = new RandVar("Catch",
			new BooleanDomain());
	//
	public static final RandVar WEATHER_RV = new RandVar("Weather",
			new ArbitraryTokenDomain("sunny", "rain", "cloudy", "snow"));
	//
	public static final RandVar MENINGITIS_RV = new RandVar("Meningitis",
			new BooleanDomain());
	public static final RandVar STIFF_NECK_RV = new RandVar("StiffNeck",
			new BooleanDomain());
	// guia 03
	
	public static final RandVar INFRIGIULEIELEITOTAL_RV = new RandVar("InfringiuLeiEleitoral",
			new BooleanDomain());
	public static final RandVar INDICIADO_RV = new RandVar("Indiciado",
			new BooleanDomain());
	public static final RandVar PROMOTORPOLITICAMENTEMOTIVADO_RV = new RandVar("PromotorPoliticamenteMotivado",
			new BooleanDomain());
	public static final RandVar CONSIDERADOCULPADO_RV = new RandVar("ConsideradoCulpado",
			new BooleanDomain());
	public static final RandVar PRESO_RV = new RandVar("Preso",
			new BooleanDomain());
	
	// Projeto Final Questão 1
	
	public static final RandVar AGE_RV = new RandVar("Age",
			new ArbitraryTokenDomain("0-30", "31-40", "41-100"));
	public static final RandVar NATIONALITY_RV = new RandVar("Nationality",
			new BooleanDomain());
	public static final RandVar SPORTS_RV = new RandVar("Sports",
			new BooleanDomain());
	public static final RandVar WATCH_TV_RV = new RandVar("Watch_TV",
			new ArbitraryTokenDomain("a_lot", "some", "none"));
	
	// Projeto Final Questão 2
	
	public static final RandVar TRABALHO_RV = new RandVar("Trabalho",
			new BooleanDomain());
	public static final RandVar CONJUGE_RV = new RandVar("Conjuge",
			new BooleanDomain());
	public static final RandVar RENDA_FAMILIAR_RV = new RandVar("RendaFamiliar",
			new ArbitraryTokenDomain("UmaTresSM", "QuatroaDez", "DezAcimaSM"));
	public static final RandVar SEGUNDO_GRAU_RV = new RandVar("SegundoGrau",
			new ArbitraryTokenDomain("EscolaPublica", "EscolaParticular"));
	public static final RandVar FASE_RV = new RandVar("Fase",
			new ArbitraryTokenDomain("PrimeiraQui", "QuintaSetima", "AcimaSetima"));
	public static final RandVar IRMAO_RV = new RandVar("Irmao",
			new BooleanDomain());
	public static final RandVar RESIDE_RV = new RandVar("Reside",
			new ArbitraryTokenDomain("Lages", "ForaDeLages"));
	public static final RandVar IMOVEL_RV = new RandVar("Imovel",
			new BooleanDomain());
	public static final RandVar DOENCA_GRAVE_RV = new RandVar("DoencaGrave",
			new BooleanDomain());
	public static final RandVar BOLSA_RV = new RandVar("Bolsa",
			new ArbitraryTokenDomain("Dez", "Quinze", "Vinte", "VinteCinco", "Trinta", "TrintaeCinco", "Quarenta", "QuarentaeCinco", "Cinquenta"));
	
	// example

	public static final RandVar BURGLARY_RV = new RandVar("Burglary",
			new BooleanDomain());
	public static final RandVar EARTHQUAKE_RV = new RandVar("Earthquake",
			new BooleanDomain());
	public static final RandVar ALARM_RV = new RandVar("Alarm",
			new BooleanDomain());
	public static final RandVar JOHN_CALLS_RV = new RandVar("JohnCalls",
			new BooleanDomain());
	public static final RandVar MARY_CALLS_RV = new RandVar("MaryCalls",
			new BooleanDomain());
	//
	public static final RandVar CLOUDY_RV = new RandVar("Cloudy",
			new BooleanDomain());
	public static final RandVar SPRINKLER_RV = new RandVar("Sprinkler",
			new BooleanDomain());
	public static final RandVar RAIN_RV = new RandVar("Rain",
			new BooleanDomain());
	public static final RandVar WET_GRASS_RV = new RandVar("WetGrass",
			new BooleanDomain());
	//
	public static final RandVar RAIN_tm1_RV = new RandVar("Rain_t-1",
			new BooleanDomain());
	public static final RandVar RAIN_t_RV = new RandVar("Rain_t",
			new BooleanDomain());
	public static final RandVar UMBREALLA_t_RV = new RandVar("Umbrella_t",
			new BooleanDomain());
}

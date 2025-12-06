import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Méthode AnalyticsCounter 
 * @author vinle
 *
 */
public class AnalyticsCounter {
	
	private ISymptomWriter writer;
	private ISymptomReader reader;

	// point 1 Constructeur de AnalyticsCounter 
	/**
	 * Constructeur de la méthode AnalyticsCounter
	 * @param reader polymorphisme de ReadSymptomDataFromFile
	 * @param writer polymorphisme de WriteSymptomDataFromFile
	 */
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
/**
 * Méthode qui lit un fichier texte et en retourne une liste de tous les symptomes
 * @return List de symptômes,  à partir d'un fichier texte
 */
public List<String> getSymptoms(){ // point 2, à partir d'un fichier text, retourne une liste de symptomes
		
	return reader.GetSymptoms(); // retourne une liste de tous les symptômes 
}

/**
 * Méthode qui compte le nombre d'occurences pour chaque symptôme 
 * @param symptoms liste des symptômes brute
 * @return Map avec pour clé:symptôme, valeur:nombre d'occurence
 */
public Map<String,Integer> countSymptoms(List<String>symptoms){ // point 3, à partir d'une liste, crée une map 
	
	Map<String,Integer> counter = new HashMap<>();
	
	for (String symptom : symptoms) {  // parcourt chaque élément de la liste symptoms 
		
		if (counter.containsKey(symptom)) {
			counter.put(symptom, counter.get(symptom)+1);
		}
		else {
			counter.put(symptom,1);
		}
	}	
	return counter;
	
}

/**
 * Méthode qui range par ordre alphabétique les clés de la Map
 * @param symptoms Map avec clé:symptôme, valeur:nombre d'occurence
 * @return Map triée par ordre alphabétique 
 */
public Map<String,Integer> sortSymptoms(Map<String,Integer>symptoms){ // point 4 range par ordre alphabétique les clés de la Map avec leurs valeurs associées 
	
	return new TreeMap<>(symptoms);	
}

/**
 * Méthode qui écrit dans un fichier texte le couple clé,valeur de la Map
 * @param symptoms Map avec clé:symptôme, valeur:nombre d'occurence rangés par ordre alphabétique
 */
public void writeSymptoms(Map<String,Integer>symptoms) { // point 5 transcris la map dans un fichier texte
	
	writer.writeSymptoms(symptoms);
}

/**
 * Méthode principale exécutant le processus complet d'analyse des symptômes.
 * <p>
 * Elle réalise les opérations suivantes :
 * </p>
 * <ol>
 *   <li>Instancie un lecteur et un écrivain via les interfaces {@link ISymptomReader} et {@link ISymptomWriter}.</li>
 *   <li>Créé une liste de symptômes depuis la lecture d'un fichier texte.</li>
 *   <li>Compte les occurrences de chaque symptôme.</li>
 *   <li>Trie les symptômes par ordre alphabétique.</li>
 *   <li>Écrit les résultats triés dans un fichier de sortie.</li>
 * </ol>
 *
 * @param args arguments passés en ligne de commande (non utilisés).
 */
public static void main (String[] args) {
	
 ISymptomReader reader = new ReadSymptomDataFromFile ("src/symptoms.txt"); // polymorphisme de l'interface ISymptomReader
 ISymptomWriter writer = new WriteSymptomDataFromFile ("src/result.txt"); // polymorphise de l'interface ISymptomWriter
 
 AnalyticsCounter counter = new AnalyticsCounter (reader, writer); 
 
 // Etape 2 création de la liste des symptômes
 List<String> symptoms = counter.getSymptoms();
 
 // Etape 3 création de la map symptômes + occurence 
 Map<String,Integer> classifiedSymptoms = counter.countSymptoms(symptoms);

 
 // Etape 4 rangement de la map par ordre alphabétique
 Map<String,Integer> orderedSymptoms = counter.sortSymptoms(classifiedSymptoms);
  
 // Etape 5 création d'un fichier texte avec clé + occurence
 counter.writeSymptoms(orderedSymptoms);
 
}
}


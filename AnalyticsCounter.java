import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomWriter writer;
	private ISymptomReader reader;

	// Constructeur point 1 
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

public List<String> getSymptoms(){ // point 2
		
	return reader.GetSymptoms(); // retourne une liste de tous les symptômes 
}

public Map<String,Integer> countSymptoms(List<String>symptoms){ // point 3 
	
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


public Map<String,Integer> sortSymptoms(Map<String,Integer>symptoms){ // point 4 range par ordre alphabétique les clés de la Map avec leurs valeurs associées 
	
	return new TreeMap<>(symptoms);
	
}


public void writeSymptoms(Map<String,Integer>symptoms) { // point 5 
	
	writer.writeSymptoms(symptoms);
}



public static void main (String[] args) {
	
 ISymptomReader reader = new ReadSymptomDataFromFile ("src/symptoms.txt"); // polymorphisme de l'interface ISymptomReader
 ISymptomWriter writer = new WriteSymptomDataFromFile ("src/result.txt"); // polymorphise de l'interface ISymptomWriter
 
 AnalyticsCounter counter = new AnalyticsCounter (reader, writer); // writer à définir comme fait pour reader 
 
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


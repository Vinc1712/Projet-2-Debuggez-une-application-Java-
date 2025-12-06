import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémentation de {@link ISymptomWriter} permettant d'écrire dans un fichier texte 
 * chaque symptôme et son nombre d'occurrences.
 * <p>
 * Chaque ligne du fichier correspond à un symptôme suivi de son nombre 
 * d'occurrences. Le fichier est créé s'il n'existe pas, ou écrasé s'il existe déjà.
 * </p>
 */
public class WriteSymptomDataFromFile implements ISymptomWriter{
	
	/**
     * Chemin d'accès du fichier dans lequel les données seront écrites.
     */
	private String filepath;
	
	/**
     * Construit un mécanisme d'écriture de symptômes vers un fichier texte.
     *
     * @param filepath le chemin du fichier dans lequel écrire les données
     */
	// constructeur avec pour paramètres filepath du fichier créé
	public WriteSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
     * Écrit dans le fichier spécifié l'ensemble des symptômes et leur nombre d'occurrences.
     * <p>
     * Chaque entrée de la {@link Map} est écrite sous la forme :
     * <br>
     * <code>symptome: nombreOccurrences</code>
     * </p>
     *
     * @param symptoms une {@link Map} associant chaque symptôme à sa fréquence.
     *                 Ne doit pas être {@code null}.
     */
	@Override
	public void writeSymptoms(Map<String,Integer>symptoms){
		
		try (FileWriter writer = new FileWriter(filepath)){
			
			for (Map.Entry<String,Integer> entry : symptoms.entrySet()) {
				
			writer.write(entry.getKey()+ ": " + entry.getValue() + "\n");
			
			}
		} catch (IOException e) {
			
		}
		System.out.println("Fichier créé");
	}

}

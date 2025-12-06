import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de {@link ISymptomReader} permettant de lire une liste
 * de symptômes depuis un fichier texte.
 * <p>
 * Chaque ligne du fichier correspond à un symptôme.
 * </p>
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * 
	 * @param filepath est le chemin d'accès du fichier contenant la
	 *liste des symptômes à traiter
	 */
	private String filepath;
	
	
	/**
     * Construit un lecteur de symptômes à partir d’un fichier.
     *
     */
	// constructeur pour définir le chemin du fichier
	public ReadSymptomDataFromFile (String filepath) {

        this.filepath = filepath;
	}

	/**
     * Lit les symptômes depuis le fichier défini dans {@link #filepath}.
     * <p>
     * Cette méthode lit le fichier ligne par ligne et ajoute chaque ligne
     * dans une liste qui représente les symptômes détectés.
     * </p>
     *
     * @return une liste de chaînes contenant les symptômes. Jamais {@code null},
     *         mais peut être vide si le fichier n'existe pas ou ne contient rien.
     */
	@Override
	// implémente la méthode getSymptoms de l'interface
	public List<String> GetSymptoms() {
		
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}



import java.util.List;

/**
 * Interface définissant un lecteur de symptômes.
 * <p>
 * Les implémentations de cette interface doivent fournir un mécanisme permettant
 * de récupérer une liste de symptômes provenant d'un fichier
 * </p>
 */

public interface ISymptomReader {
	
	/**
     * Retourne la liste des symptômes lus depuis la source spécifiée par l’implémentation.
     *
     * @return une {@link List} de chaînes représentant les symptômes.
     *         Ne doit jamais être {@code null}. Peut être vide si aucun symptôme n’est trouvé.
     */

	public List<String> GetSymptoms (); //méthode à implémenter
	
}

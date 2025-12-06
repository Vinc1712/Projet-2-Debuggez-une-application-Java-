import java.util.Map;

/**
 * Interface définissant un mécanisme d'écriture de symptômes.
 * <p>
 * Les implémentations de cette interface doivent fournir un moyen d'écrire
 * une collection de symptômes ainsi que leur nombre d'occurrences, sous la
 * forme d'une {@link Map}.
 * </p>
 */
public interface ISymptomWriter {
	
	/**
     * Écrit les symptômes et leur fréquence.
     *
     * @param symptoms une {@link Map} associant chaque symptôme à son nombre
     *                 d'occurrences. Ne doit pas être {@code null}.
     */
	public void writeSymptoms(Map<String,Integer>symptoms);

}

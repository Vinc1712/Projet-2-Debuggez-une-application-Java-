import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataFromFile implements ISymptomWriter{
	
	private String filepath;
	
	// constructeur avec pour paramètres filepath du fichier créé
	public WriteSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	
		
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

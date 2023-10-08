import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryManagement {
    public void insertFromFile(Word word) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\gtp11\\OneDrive\\Desktop\\Lthdt\\BTL\\src\\dictionaries.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String[] parsedLine = line.split(",");
                String wordName = parsedLine[0];
                String meaning = parsedLine[1];
                Word newWord = new Word(wordName, meaning);


            }


            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

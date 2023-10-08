import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

    HashMap<String, Word> map = new HashMap<>(); //Luu tru mang cac cap tu va nghia cua no

    //    Nhap lieu tu file
    public void insertFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Constant.DICTIONARY_URL));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String[] parsedLine = line.split("  ");
                String wordName = parsedLine[0];
                String meaning = parsedLine[1];
                Word newWord = new Word(wordName, meaning);
                this.map.put(wordName, newWord);

            }

            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    Tim tu "LOOK UP"
    public String dictionaryLookup(String word) {
        for (String i : map.keySet()) {
            if (i.equals(word)) {
                Word newWord = map.get(i);
                return newWord.word_explain;
            }
        }
        return null;
    }

    /**
     * @param thisWord nap tu vao
     * @param index    vi tri tu trong map
     * @return string
     */
    public String toString(Word thisWord, int index) {
        return String.format("%-5d| %-16s| %-30s", index, thisWord.word_target, thisWord.word_explain);
    }

    //Show het tu co trong map
    public void showAllWords() {
        System.out.println("No   | English         | Vietnamese");
        int j = 0;
        for (String i : map.keySet()) {
            System.out.println(toString(map.get(i), j++));
        }

    }

    //Nhap lieu tu app vao file
//    Co the bi loi nhap vao bi lap lai tu(Nho test lai)
    public void saveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.DICTIONARY_URL));
        for (String i : map.keySet()) {
            Word newWord = map.get(i);
            bw.write(newWord.word_target);
            bw.write("\t");
            bw.write(newWord.word_explain);
            bw.write("\n");

        }
        bw.close();
    }

    //Nhap tu moi tu commandLine
    public void insertFromCommandline() {
        Scanner newSc = new Scanner(System.in);
        System.out.println("Nhap tu moi: ");
        Word newWord = new Word();
        newWord.word_target = newSc.next().toLowerCase();
        newSc.nextLine();
        System.out.println("Nhap nghia cua tu: ");
        newWord.word_explain = newSc.nextLine().toLowerCase();
        map.putIfAbsent(newWord.word_target, newWord);
        System.out.println("Da them tu vo tu dien");
    }

    //xoa mot tu bang commandLine
    public void removeFromCommandLine() {
        Scanner newSc = new Scanner(System.in);
        System.out.println("Nhap tu muon xoa: ");
        String deleteWord = newSc.next().toLowerCase();
        if(map.containsKey(deleteWord)) {
            map.remove(deleteWord);
            System.out.println("Da xoa tu ban muon");
        }
        else {
            System.out.println("Tu ban can xoa khong ton tai");
        }
    }

    //Sua mot tu(Co the them chuc nang tao tu moi luon cung duoc)
    public void updateFromFile() {
        Scanner newSc = new Scanner(System.in);
        System.out.println("Nhap tu muon sua: ");
        String updateWord = newSc.nextLine().toLowerCase();
        if(map.containsKey(updateWord)) {
            System.out.println("Nhap nghia cua tu ban muon sua: ");
            Word toUpdateWord = new Word();
            toUpdateWord.word_target=updateWord;
            toUpdateWord.word_explain = newSc.nextLine().toLowerCase();
            map.put(updateWord,toUpdateWord);

        }
        else {
            System.out.println("Tu ban muon sua khong ton tai");
        }
    }

    //Tim tu trong tu dien(Co kha nang xay ra loi can test lai)
    public void lookupFromDictionary() {
        Scanner newSc = new Scanner(System.in);
        System.out.println("Nhap tu ban muon tim");
        String lookupWord = newSc.nextLine().toLowerCase();
        System.out.println(dictionaryLookup(lookupWord));
    }

    //chua xong
    public void searchFromDictionary() {
        Scanner newSc = new Scanner(System.in);
        System.out.println("Nhap tu ban muon tim");
        String searchWord = newSc.nextLine().toLowerCase();

    }



}

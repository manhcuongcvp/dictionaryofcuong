package Dictionary;

import com.sun.speech.freetts.Voice;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class DictionaryManagement {
    public static void insertFromCommandline(Dictionary a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            String Word_target = sc.nextLine();
            String Word_explain = sc.nextLine();
            Word w = new Word(Word_target, Word_explain);
            a.addWord(w);
        }

        sc.close();
    }

    private final static String FILE_URL = "D:\\HelloDictionary\\src\\Dictionary\\dictionary\\dictionaries.txt";
    public static void insertFromFile (Dictionary a) {
        try {
            File file = new File(FILE_URL);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);


            String line = "";
            while((line = reader.readLine()) != null) {
                int tmp = line.indexOf('|');

                String Word_target = line.substring(0, tmp);
                String Word_explain = line.substring(tmp + 1, line.length());

                Word w = new Word(Word_target, Word_explain);
                a.addWord(w);
            }
            a.sortDic();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryExportToFile(Dictionary a) throws IOException {
        File file = new File(FILE_URL);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        for (int i = 0; i < a.arr.size(); i++) {
            outputStreamWriter.write(a.getWord(i).getWord_target() + "|" + a.getWord(i).getWord_explain() + "\n");
        }

        outputStreamWriter.flush();
    }

    Scanner sc = new Scanner(System.in);

    public void addWord (Dictionary a, String Word_target, String Word_explain) {
        Word w = new Word(Word_target, Word_explain);
        a.addWord(w);
        a.sortDic();
    }

    public void removeWord (Dictionary a, String Word_target) {
        int pos = -1;
        pos = Collections.binarySearch(a.arr, new Word (Word_target, null));
        a.removeMord(pos);
    }

    public void modifyWord (Dictionary a, String Word_target, String Word_explain) {
        int pos = -1;
        pos = Collections.binarySearch(a.arr, new Word (Word_target, null));
        a.modifyWord(pos, Word_explain);
    }

    public String dictionaryLookup (Dictionary a, String searchWord) {
        int pos = Collections.binarySearch(a.arr, new Word (searchWord, null));
        if (pos >= 0) {
            return a.arr.get(pos).getWord_explain();
        } else {
            String tmp = "The word is not exist in dictionary";
            return tmp;
        }
    }

    public boolean checkLookup (Dictionary a, String searchWord) {
        int pos = Collections.binarySearch(a.arr, new Word (searchWord, null));
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void dictionarySearcher (Dictionary a, Scanner sc) {
        System.out.print("Searcher word: ");
        String searchWord = sc.nextLine();
        for (int i = 0; i < a.arr.size(); i++) {
            String tempString = a.getWord(i).getWord_target();
            if (tempString.contains(searchWord) == true)
                System.out.println(tempString);
        }
    }
}
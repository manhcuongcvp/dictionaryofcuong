import java.io.*;
import java.util.Scanner;
//import java.util.Collections;

public class DictionaryManagement {
    //Dictionary a = new Dictionary();

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

    /*public static void insertFromFile (Dictionary a) {
        try {
            FileReader fr =  new FileReader("D:\\Dictionary\\src\\dictionary\\dictionaries.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                int tab = line.indexOf('\t');
                String word_target = line.substring(0, tab);
                String word_explain = line.substring(tab + 1);
                a.addWord(new Word(word_target, word_explain));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private final static String FILE_URL = "D:\\DictionaryofCuong\\src\\dictionary\\dictionaries.txt";
    public static void insertFromFile (Dictionary a) {
        try {
            File file = new File(FILE_URL);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);


            String line = "";
            while((line = reader.readLine()) != null) {
                //String line = reader.readLine();
                int tmp = line.indexOf('|');
                /*String Word_target = "Hello" + tmp;
                String Word_explain = "Xin chao" + tmp;*/

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
}
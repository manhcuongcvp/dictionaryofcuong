package Dictionary;

import java.util.Scanner;
import java.io.*;

public class DictionaryCommandline {
    public static void showAllWords(Dictionary a) {
        /*System.out.println("No\t" + "| English\t\t" + "| Vietnamese");
        for (int i = 0; i < a.arr.size(); i++) {
            System.out.println((i + 1) + "\t| " + a.getWord(i).getWord_target() + "\t\t| " + a.getWord(i).getWord_explain());
            System.out.println((i + 1) + "\t" + "| Hello" + "\t\t" + "| XinChao");
        }*/

        System.out.printf("%-6s%c %-15s%c %-20s%n","No", '|' ,"English", '|', "Vietnamese");
        for (int i = 0; i < a.arr.size(); i++) {
            System.out.printf("%-6d%c %-15s%c %-15s%n",i+1,'|', a.getWord(i).getWord_target(),'|',a.getWord(i).getWord_explain());
        }
    }

    private final static String FILE_URL = "D:\\DictionaryofCuong\\src\\out\\dictionariesOUT.txt";

    public static void dictionaryExportToFile(Dictionary a) throws IOException {
        File file = new File(FILE_URL);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        outputStreamWriter.write("No" + "\t| " + "English" + "\t| " + "Vietnamese" + "\n");

        for (int i = 0; i < a.arr.size(); i++) {
            outputStreamWriter.write((i + 1) + "\t| " + a.getWord(i).getWord_target() + "\t| " + a.getWord(i).getWord_explain() + "\n");
        }

        outputStreamWriter.flush();
    }


    public static void dictionaryBasic(Dictionary a) {
        DictionaryManagement DM = new DictionaryManagement();
        DM.insertFromCommandline(a);

        showAllWords(a);
    }

    public static void dictionaryAdvanced(Dictionary a) throws IOException {
        DictionaryManagement DM = new DictionaryManagement();
        DM.insertFromFile(a);
        showAllWords(a);
        dictionaryExportToFile(a);
        Scanner sc = new Scanner(System.in);

        System.out.print("Look up: ");
        String searchWord = sc.nextLine();
        String resultWord = DM.dictionaryLookup(a, searchWord);
        System.out.println(resultWord);
        DM.dictionarySearcher(a, sc);
    }

    public static void main(String[] args) throws IOException {
        Dictionary tmp = new Dictionary();
        dictionaryAdvanced(tmp);
    }
}
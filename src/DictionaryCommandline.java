public class DictionaryCommandline {
    public static void showAllWords(Dictionary dic) {
        /*System.out.println("No\t" + "| English\t\t" + "| Vietnamese");
        for (int i = 0; i < a.arr.size(); i++) {
            System.out.println((i + 1) + "\t| " + a.getWord(i).getWord_target() + "\t\t| " + a.getWord(i).getWord_explain());
            System.out.println((i + 1) + "\t" + "| Hello" + "\t\t" + "| XinChao");
        }*/
        System.out.printf("%-6s%c %-15s%c %-20s%n","No", '|' ,"English", '|', "Vietnamese");
        for(int i=0; i<dic.arr.size(); i++) {
            System.out.printf("%-6d%c %-15s%c %-15s%n",i+1,'|', dic.getWord(i).getWord_target(),'|',dic.getWord(i).getWord_explain());
        }
    }

    public static void dictionaryBasic(Dictionary a) {
        DictionaryManagement DM = new DictionaryManagement();
        DM.insertFromCommandline(a);

        showAllWords(a);
    }

    public static void dictionaryAdvanced(Dictionary a) {
        DictionaryManagement DM = new DictionaryManagement();
        DM.insertFromFile(a);
        showAllWords(a);
        DM.dictionaryLookup(a);
    }

    public static void main(String[] args) {
        Dictionary tmp = new Dictionary();
        dictionaryAdvanced(tmp);
        /*String s = "hello";
        int tmp = s.indexOf('o');
        System.out.println(s.substring(0,tmp));*/
    }
}
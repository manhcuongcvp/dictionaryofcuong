package Dictionary;

import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {
    ArrayList<Word> arr = new ArrayList<Word>();

    public void addWord(Word w) {
        arr.add(w);
    }
    public void removeMord(int pos) {
        arr.remove(arr.get(pos));
    }
    public void modifyWord(int pos, String wordExplain) {
        arr.get(pos).setWord_explain(wordExplain);
    }

    public Word getWord(int i) {
        return arr.get(i);
    }

    public void sortDic() {
        Collections.sort(arr);
    }
    public int getSize() {
        return arr.size();
    }
}
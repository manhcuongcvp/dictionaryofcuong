package Dictionary;

import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {
    ArrayList<Word> arr = new ArrayList<Word>();

    public void addWord(Word w) {
        arr.add(w);
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
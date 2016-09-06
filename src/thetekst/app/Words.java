package thetekst.app;

import java.util.ArrayList;
import java.util.List;

public class Words {
    List<String> words;

    public Words() {
        words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
    }

    public String rundomizer() {
        int word = (int) (Math.random() * words.size());
        return words.get(word);
    }
}

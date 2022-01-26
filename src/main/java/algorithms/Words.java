package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {

        if (!hasSpaceinWord(word) && !hasUppercaseCharacter(word)) {
            words.add(word);
        }
    }

    private boolean hasUppercaseCharacter(String word) {

        for (char actual : word.toCharArray()) {
            if (Character.isUpperCase(actual)) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
        return false;
    }

    private boolean hasSpaceinWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        return false;
    }

    public boolean isThereAWordTwice() {
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    count++;
                }
            }
        }
        return count > words.size();
    }

//    public boolean isThereAWordTwice() {
//        return words.stream().count()!=words.stream().distinct().count();
//    }
}

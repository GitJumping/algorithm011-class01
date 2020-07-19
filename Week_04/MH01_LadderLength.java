package Week_04;

import javafx.util.Pair;

import java.util.*;

public class MH01_LadderLength {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        MH01_LadderLength mh01_ladderLength = new MH01_LadderLength();
        System.out.println(mh01_ladderLength.ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l = beginWord.length();

        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);
                List<String> trans = allComboDict.getOrDefault(newWord, new ArrayList<>());
                trans.add(word);
                allComboDict.put(newWord, trans);
            }
        });

        Queue<Pair<String, Integer>> q =new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!q.isEmpty()) {
            Pair<String, Integer> pair = q.remove();
            String word = pair.getKey();
            int level = pair.getValue();
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);

                for (String adjecentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjecentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjecentWord)) {
                        visited.put(adjecentWord, true);
                        q.add(new Pair<>(adjecentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}

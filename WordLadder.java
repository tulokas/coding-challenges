/** The Problem
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of the shortest transformation sequence from beginWord to endWord,
 * such that:
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list.
 * 
 * Examples:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5 (hit -> hot -> dot -> dog -> cog)
 **/

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        int result = solution("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println("solution: " + result);
    }

    public static int solution(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String transformed = new String(wordChars);
                        if (transformed.equals(endWord)) return level + 1;
                        if (wordSet.contains(transformed)) {
                            queue.add(transformed);
                            wordSet.remove(transformed);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}

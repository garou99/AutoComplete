package service;

import dto.Trie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrieService {
    @Autowired
    DictionaryService dictionaryService;

    private Trie root;

    private List<String> possibleWords;

    public TrieService() {
        root = new Trie('*');
        List<String> englishWords = dictionaryService.getEnglishWords();
        for (int i = 0; i < englishWords.size(); i++) {
            insert(englishWords.get(i));
        }
    }

    private void insert(String words) {
        Trie node = root;

        for (int i = 0; i < words.length(); i++) {
            char currentChar = words.charAt(i);
            if (!node.containsTrieNode(currentChar)) {
                node.setTrieNode(currentChar);
            }
            node = node.getTrieNode(currentChar);
        }
        node.setEnd(true);
    }

    private void getPossibleWords(Trie node, String word, String newWord, int index) {
        if (word.length() == index) {
            if (node.isEnd())
                possibleWords.add(newWord);
            for (char currentChar = 'a'; currentChar <= 'z'; currentChar++) {
                if (node.containsTrieNode(currentChar)) {
                    getPossibleWords(node.getTrieNode(currentChar), word, newWord + currentChar, index);
                }
            }
        } else {
            char currentChar = word.charAt(index);
            if (node.containsTrieNode(word.charAt(currentChar)))
                getPossibleWords(node.getTrieNode(word.charAt(currentChar)), word, newWord + currentChar, index + 1);
            else
                return;
        }
    }

    public List<String> getPossibleWords(String word) {
        Trie node = root;
        getPossibleWords(node, word, "", 0);
        return possibleWords;
    }

}

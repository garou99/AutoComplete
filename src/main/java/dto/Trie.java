package dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor

public class Trie {

    @NonNull
    private char data;

    @Setter
    @Getter
    private boolean isEnd;
    private final Trie trieNode[] = new Trie[26];

    public boolean containsTrieNode(char currentChar) {
        return trieNode[currentChar - 'a'] != null;
    }

    public void setTrieNode(char currentChar) {
        trieNode[currentChar - 'a'] = new Trie(currentChar);
    }

    public Trie getTrieNode(char currentChar) {
        return trieNode[currentChar - 'a'];
    }
}

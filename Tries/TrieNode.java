package Tries;

public class TrieNode {

    TrieNode children[];
    boolean isWordEnded;
    public TrieNode(){
        this.children =new TrieNode[26];
        this.isWordEnded=false;
    }

}

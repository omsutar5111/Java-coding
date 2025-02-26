package Data_Structure_Algorithms.Tries;

public class Main {

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("hello");
        System.out.println( trie.search("hello"));

    }
}

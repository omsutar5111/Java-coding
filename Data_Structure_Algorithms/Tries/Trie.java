package Data_Structure_Algorithms.Tries;

public class Trie {
  public   TrieNode root;

  public Trie(){
      this.root= new TrieNode();
  }
  public   void insert(String word){
      word=word.toLowerCase();
      TrieNode currentNode=root;
      for(int i=0;i<word.length();i++){
          int index=word.charAt(i)-'a';
          if(currentNode.children[index]==null){
              currentNode.children[index]=new TrieNode();
          }
          currentNode=currentNode.children[index];

      }
      currentNode.isWordEnded=true;

  }

  public   boolean search(String word){
      word=word.toLowerCase();
      TrieNode currentNode=root;
      for(int i=0;i<word.length();i++){
          int index=word.charAt(i)-'a';
          if(currentNode.children[index]==null){
              return false;
          }
          currentNode=currentNode.children[index];

      }
      return currentNode.isWordEnded;

  }


}

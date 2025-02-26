package Core_Java.OOPS.Generics;

public class DocumentPrinter<T extends Document> {
      T doc;
      public  DocumentPrinter(T doc){
          this.doc=doc;
      }
      public T getDoc(T doc){
          return doc;
      }
}

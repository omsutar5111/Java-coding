package Core_Java.OOPS.Generics;

public class pdfDocument extends Document{

    public pdfDocument(String DocName) {
        super(DocName);
    }
    @Override
    public String toString(){
       return "pdf document "+" name "+DocName;
    }

}

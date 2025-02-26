package Core_Java.OOPS.Generics;

public class main {
    public static void main(String[] args) {
        pdfDocument pdf=new pdfDocument("Resume.pdf");
        DocumentPrinter<pdfDocument> pdfDocPrinter=new DocumentPrinter<>(pdf);

        System.out.println(pdfDocPrinter.getDoc(pdf));


    }
}

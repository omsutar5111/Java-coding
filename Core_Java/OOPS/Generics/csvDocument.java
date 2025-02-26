package Core_Java.OOPS.Generics;

public class csvDocument extends Document{
    public csvDocument(String DocName) {
        super(DocName);
    }
    @Override
    public  String toString(){
        return "csvDocname"+DocName;
    }
}

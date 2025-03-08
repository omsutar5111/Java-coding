package Java_Design_Patterns.Singletone;

public class Singleton {
//    private static final Singleton Instance=new Singleton();

    private  Singleton(){

    }
    private  static volatile Singleton Instance;



    //use for eager initilization
    public static Singleton getEagerInstance(){
        return  Instance;
    }


  public static Singleton getInstance(){
     if(Instance==null){
       synchronized (Singleton.class){
           if(Instance==null) {
               Instance = new Singleton();
           }
       }

     }
      return  Instance;
  }

}

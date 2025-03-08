package Java_Design_Patterns.Singletone;



public class Client {

    public static void main(String[] args) {
        Runnable task=()->{
            Singleton s1=Singleton.getInstance();
            Singleton s2=Singleton.getInstance();
            System.out.println("instance one: "+s1.hashCode());
            System.out.println("instance two: "+s2.hashCode());
            System.out.println("is instances are same?:"+(s1==s2));
        };


        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        t1.start();
        t2.start();
    }
}

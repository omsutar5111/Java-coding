package Core_Java.inheritance;

public class TestMain {
    public static void main(String[] args) {
       { Insurance obj = new HealthInsurance();
        System.out.println(obj.A);// 20
        System.out.println(obj.B);// 34
        obj.m1();// calling m1 from child
        // obj.m2();
       }
       
       System.out.println("--------------------");

        {HealthInsurance obj1 = new HealthInsurance();
        System.out.println(obj1.A);// 40
        System.out.println(obj1.B);// 60
        obj1.m1();// calling m1 from child
        obj1.m2();// calling m2 from child
        }


    }
}

package Core_Java.OOPS;

public class User {
    int a;
    public User(){
        System.out.println("in User constructor");
    }
    public void getUser(){
        System.out.println("user method called");
    }

    public static void main(String[] args) {

       User user=new User();
       user.getUser();
       User userIntructor=new Instructor();
       userIntructor.getUser();
       User userMentor=new Mentor();
       userMentor.getUser();
        System.out.println("*************************************");
       Mentor mentor=new Mentor();
       mentor.getMentor();
       Mentor mentorIntructor=new Instructor();
       mentorIntructor.getMentor();
//       Mentor mentorUser=new User();  Throw a error
       Instructor instructor=new Instructor();
//       Instructor instructorUser=new User();    throw error;
//        Instructor introctorMentor=new Mentor(); throw error;


//        user.a=10;
//         User user1=new Mentor();
//        user1.getUser();
//        user1.a=23;
//        user1.b=245;
//        Mentor mentor=new Instructor();
//        mentor.getUser();
//        mentor.getMentor();
//        mentor.a=13;
//        mentor.b=34;
//        mentor.c=45;
//       Instructor instructor=new Instructor();
//        instructor.getUser();
//        instructor.getMentor();
//        instructor.getInstructor();
//        instructor.d=56;


    }
}




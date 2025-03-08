package Java_Design_Patterns.Builder;

public class Client {

    public static void main(String[] args) {
       Student st=Student.getBuilder().
               setName("omkar").
               setAge(25).
               setGradYear(2024).
               build();
        System.out.println(st.name+""+st.age);
    }
}

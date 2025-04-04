package Java_Design_Patterns.Prototype_Registry;

public class client {
    public static void main(String[] args) {
      InteligentStudent originalStudent=new InteligentStudent(1,"omkar",130);
      InteligentStudent clonedStudent=originalStudent.cloneStudent();
      clonedStudent.setIq(145);
        System.out.println(originalStudent);
        System.out.println(clonedStudent);

      Registry registry=new Registry();
      registry.registerStudent("Istudent",originalStudent);
      InteligentStudent registryClonedStudent=(InteligentStudent) registry.getStudent("Istudent");
        System.out.println(registryClonedStudent);

    }
}

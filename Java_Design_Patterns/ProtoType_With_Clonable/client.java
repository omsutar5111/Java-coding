package Java_Design_Patterns.ProtoType_With_Clonable;

import Java_Design_Patterns.Prototype_Registry.InteligentStudent;

public class client {

    public static void main(String[] args) {
       Student student=new Student(1,"Omkar",1004593);
       PrototypeRegistry prototypeRegistry=new PrototypeRegistry();
       prototypeRegistry.addStudent("student",student);
       Student copyStudent=prototypeRegistry.getCloneObject("student");
       System.out.println(student);
       System.out.println(copyStudent);
       IntelligentStudent intelligentStudent=new IntelligentStudent(2, "Jane", 1004594, 150);
       prototypeRegistry.addStudent("intelligentStudent",intelligentStudent);
        System.out.println(intelligentStudent);
        System.out.println(prototypeRegistry.getCloneObject("intelligentStudent"));


    }
}

package Java_Design_Patterns.ProtoType_With_Clonable;

public class Student  implements  Cloneble{
   private int id;
   private  String name;
   private int rollNo;

   public  Student(){

   }
   public Student(int id,String name,int rollNo){
       this.id=id;
       this.name=name;
       this.rollNo=rollNo;
   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public Student clone() {
        return new Student(id,name,rollNo);
    }
}

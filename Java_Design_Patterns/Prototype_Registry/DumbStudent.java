package Java_Design_Patterns.Prototype_Registry;

public class DumbStudent extends Student{
   private  int iq;
   public DumbStudent(){
       super();
   }

    public  DumbStudent(int id,String name,int iq){
        super(id,name);
        this.iq=iq;

    }

    @Override
    public DumbStudent cloneStudent() {
        return new DumbStudent(getId(),getName(),getIq());
    }
    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

}

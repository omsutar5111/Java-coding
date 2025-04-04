package Java_Design_Patterns.Prototype_Registry;

public class InteligentStudent extends  Student{


    private  int iq;

  public InteligentStudent(){
   super();
  }

    private String name;
    public InteligentStudent(int id,String name,int iq){
        super(id,name);

        this.iq=iq;
    }
    @Override
    public InteligentStudent cloneStudent() {
        return new InteligentStudent(getId(),getName(),getIq());
    }


    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package Java_Design_Patterns.ProtoType_With_Clonable;

public class IntelligentStudent extends Student{
    private int iq;
    public IntelligentStudent(int id, String name, int rollNo, int iq) {
        super(id, name, rollNo);
        this.iq=iq;
    }
    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(getId(),getName(),getRollNo(),iq);
    }
}

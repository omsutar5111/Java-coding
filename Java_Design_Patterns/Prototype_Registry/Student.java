package Java_Design_Patterns.Prototype_Registry;

public abstract  class Student {
    private int id;
    private String name;  // moved to parent class

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract Student cloneStudent();

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

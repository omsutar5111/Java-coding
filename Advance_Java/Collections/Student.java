package Advance_Java.Collections;

public class Student implements Comparable<Student>{

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  int age;
    public Student(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public int compareTo(Student o) {
        return o.age-this.age;
    }
}

package Java_Design_Patterns.Prototype_Registry;

import java.util.*;

public class Registry {
    private Map<String, Student> registry = new HashMap<>();

    public Registry(){

    }
    public void registerStudent(String key, Student student) {
        registry.put(key, student);
    }

    public Student getStudent(String key) {
        Student student = registry.get(key);
        return student != null ? student.cloneStudent() : null;
    }
}

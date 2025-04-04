package Java_Design_Patterns.ProtoType_With_Clonable;

import java.util.HashMap;

public class PrototypeRegistry {
    HashMap<String,Student>map=new HashMap<>();
    public void addStudent(String key,Student student){
        map.put(key,student);
    }
    public Student getStudent(String key){
       return map.get(key);
    }
    public Student getCloneObject(String key){

        return map.get(key).clone();
    }
}

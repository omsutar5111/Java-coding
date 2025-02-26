package Advance_Java.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Client {



    public static void main(String[] args) {
      Student s1=new Student("omkar",25);
      Student s2=new Student("omk",28);
      Student s3=new Student("nam",31);
      ArrayList<Student>studentList=new ArrayList<>();
      studentList.add(s1);
      studentList.add(s2);
      studentList.add(s3);
      Collections.sort(studentList,new CustomComparator());
      for(Student i:studentList){
          System.out.println(i.getAge());
      }
        /*Collection in java
        It provides a ready-made architecture for interfaces and classes and is used for storing and manipulating a group of objects.
         All collections frameworks contain interfaces, classes, and algorithms
  */

//       1. ArrayList

//        ArrayList<String> list=new ArrayList<>(Arrays.asList("hello","scaler","welcome"));
//        ArrayList<String> list2=new ArrayList<>(List.of("one","two","eight"));
//        System.out.println(list2);
//        System.out.println(list);
//        list.add("no");
//        list.remove(1);
//        System.out.println(list);
//        System.out.println(list.size());


    }
}

package PriorityQ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student("omkar", 45, 2022);
        Student s2 = new Student("Vaibhav", 20, 2023);
        Student s3 = new Student("Sushant", 4, 2020);
        Student s4 = new Student("Pratap", 5, 2021);
        Student s5 = new Student("Mahesh", 3, 2021);

        PriorityQueue<Student> studentHeap = new PriorityQueue<>(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                // TODO Auto-generated method stub
                if (o1.batch.equals(o2.batch)) {
                    return o1.roleNumber - o2.roleNumber;
                }
                return o1.batch - o2.batch;
            }

        });

        studentHeap.add(s1);
        studentHeap.add(s2);
        studentHeap.add(s3);
        studentHeap.add(s4);
        studentHeap.add(s5);

        while(!studentHeap.isEmpty()){
            System.out.println(studentHeap.peek().name);
            studentHeap.remove();
        }
    }
}

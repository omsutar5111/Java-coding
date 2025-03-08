package Java_Design_Patterns.Builder;

public class Student {

    int id;
    String name;
    String batchName;
    int age;
    int gradYear;

    private Student(Builder builder){
     this.id=builder.id;
     this.age= builder.age;;
     this.batchName= builder.batchName;
     this.gradYear= builder.gradYear;
     this.name=builder.name;
    }

    public  static Builder getBuilder(){
        return  new Builder();
    }

    static class Builder{
        int id;
        String name;
        String batchName;
        int age;
        int gradYear;

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setBatchName(String batchName) {
            this.batchName = batchName;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }
     public Student build() {
            if(this.age<18){
                throw  new RuntimeException("age should be atleast 18 years");
            }
            return new Student(this);
        }


    }
}

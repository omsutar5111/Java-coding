package Core_Java.Exception_Handling;

public class Client {

    public void checkAge (int age) throws InvalidAgeException{
        if(age<21){
            throw  new InvalidAgeException("Minimum age is 21 years ");
        }
    }
    public static void main(String[] args) {
        Client c1= new Client();
        try{
            c1.checkAge(18);
        }
        catch (InvalidAgeException invalidAgeException){
            System.out.println(invalidAgeException.getMessage());
        }
    }
}

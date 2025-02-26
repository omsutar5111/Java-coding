package Core_Java.Aggregation;

import java.util.Scanner;

public class EmployeeDetails {
    public static void getEmployeeDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee Id :");
        int id = sc.nextInt();
        System.out.println("Enter employee Name :");
        String name = sc.next();
        System.out.println("Enter employee Contact Number :");
        String phoneNumber = sc.next();
        System.out.println("Enter employee Company Name :");
        String companyName = sc.next();
        System.out.println("Enter employee City:");
        String city = sc.next();
        System.out.println("Enter employee State:");
        String state = sc.next();
        System.out.println("Enter employee Country:");
        String country = sc.next();
        System.out.println("Enter employee Pincode Number :");
        int pincode = sc.nextInt();

        Employee emp = new Employee();
        emp.setId(id);
          emp.setName(name);
        emp.setCompanyName(companyName);
        emp.setPhoneNumber(phoneNumber);
        Address address = new Address();
        address.setCity(city);
        address.setCountry(country);
        address.setState(state);
        address.setPincode(pincode);
        emp.setAddress(address);

        System.out.println("Employee Details are as Followes");
        System.out.println(emp.getName());
        System.out.println(emp.getId());
        System.out.println(emp.getCompanyName());
        System.out.println(emp.getPhoneNumber());
        System.out.println(emp.getAddress().getCity());
        System.out.println(emp.getAddress().getState());
        System.out.println(emp.getAddress().getPincode());
        System.out.println(emp.getAddress().getCountry());

    }
}

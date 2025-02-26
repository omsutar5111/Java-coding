package Core_Java.inheritance;

public class Employee {
    int empId;
    Double salary; 
    String empName;
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpName() {
        return empName;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Double getSalary() {
        return salary;
    }
}

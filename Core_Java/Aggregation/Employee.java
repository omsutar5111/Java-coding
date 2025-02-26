package Core_Java.Aggregation;

public class Employee {
   private int id;
  private  String name,phoneNumber,companyName;
  private Address address;
  public void setId(int id) {
      this.id = id;
  }
  public void setCompanyName(String companyName) {
      this.companyName = companyName;
  }
  public void setName(String name) {
      this.name = name;
  }
  public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
  }
public int getId() {
    return id;
}
public String getCompanyName() {
    return companyName;
}
public String getName() {
    return name;
}
public String getPhoneNumber() {
    return phoneNumber;
}
public void setAddress(Address address) {
    this.address = address;
}
public Address getAddress() {
    return address;
}

}

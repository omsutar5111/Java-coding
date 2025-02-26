package Core_Java.Aggregation;

public class Address {
    private String city,state,country;
    private int pincode;

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public int getPincode() {
        return pincode;
    }

    public String getState() {
        return state;
    }
    
    public String getCity() {
        return city;
    }
}

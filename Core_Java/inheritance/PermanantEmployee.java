package Core_Java.inheritance;

public class PermanantEmployee extends Employee {
    Double basicPay,hra;
    int experinace;
 
    public void setBasicPay(Double basicPay) {
        this.basicPay = basicPay;
    }
    public Double getBasicPay() {
        return basicPay;
    }
    public void setHra(Double hra) {
        this.hra = hra;
    }
    public Double getHra() {
        return hra;
    }
    public void setExperinace(int experinace) {
        this.experinace = experinace;
    }
    public int getExperinace() {
        return experinace;
    }

   
}

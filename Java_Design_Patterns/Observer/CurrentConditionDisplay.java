package Java_Design_Patterns.Observer;

public class CurrentConditionDisplay implements Observer{
    private float temperature;
    private float humidity;

    public  CurrentConditionDisplay(Subject weatherData){
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
     this.humidity=humidity;
     this.temperature=temperature;
     display();
    }
    public void display() {
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }

}

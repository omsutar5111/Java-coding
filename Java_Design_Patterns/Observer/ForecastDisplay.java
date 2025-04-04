package Java_Design_Patterns.Observer;

public class ForecastDisplay implements  Observer{

    private float pressure;

    public ForecastDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
       this.pressure=pressure;
       display();
    }
    public void display() {
        if (pressure > 1010) {
            System.out.println("Forecast: Improving weather on the way!");
        } else if (pressure == 1010) {
            System.out.println("Forecast: More of the same.");
        } else {
            System.out.println("Forecast: Watch out for cooler, rainy weather.");
        }
    }
}

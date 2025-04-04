package Java_Design_Patterns.Observer;

import java.util.ArrayList;
import java.util.*;

public class WeatherReport implements  Subject{

    private  float temperature;
    private  float humidity;
    private  float pressure;
    private List<Observer> obsList;
    public WeatherReport(){
        obsList=new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        System.out.println("Observer added ");
         obsList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        System.out.println("Observer removed ");
         obsList.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o:obsList){
            o.update(temperature,humidity,pressure);

        }
        System.out.println("Observer updated with latest values");
    }
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }
}

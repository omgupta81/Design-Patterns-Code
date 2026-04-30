
import java.util.*;

interface Observer {
    void update();
}

interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class WeatherStation implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temp) {
        this.temperature = temp;
        notifyObservers();
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

class MobileDisplay implements Observer {
    private WeatherStation station;

    public MobileDisplay(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        System.out.println("Mobile Display: " + station.getTemperature());
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        MobileDisplay mobile1 = new MobileDisplay(station);
        MobileDisplay mobile2 = new MobileDisplay(station);

        station.addObserver(mobile1);
        station.addObserver(mobile2);

        station.setTemperature(25);
        station.setTemperature(30);
    }
}
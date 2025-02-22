/*
Design a Weather class with a static nested class Forecast.
a) The Forecast class should predict weather conditions (Sunny, Rainy, Cloudy) based on input data like temperature and humidity.
b) Use the nested class to predict and display the weather forecast for different cities.
*/
import java.util.Scanner;
class Weather {
    String[] cities;
    double[] temperatures;
    double[] humidities;
    int count;
    // Static nested class Forecast
    static class Forecast {
        String city;
        double temperature;
        double humidity;
        Forecast(String city, double temperature, double humidity) {
            this.city = city;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        String predictWeather() {
            if (temperature > 30 && humidity < 50) {
                return "Sunny";
            } else if (humidity > 70) {
                return "Rainy";
            } else {
                return "Cloudy";
            }
        }

        void displayForecast() {
            System.out.printf("City: %s - Temperature: %.2f°C, Humidity: %.2f%% -> %s%n", city, temperature, humidity, predictWeather());
        }
    }
    Forecast[] forecasts;
    public Weather(int count) {
        this.count = count;
        this.cities = new String[count];
        this.temperatures = new double[count];
        this.humidities = new double[count];
        this.forecasts = new Forecast[count];
    }

    void inputWeatherData() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            System.out.print("Enter city name: ");
            String city = sc.nextLine();
            System.out.print("Enter temperature (°C): ");
            double temp = sc.nextDouble();
            System.out.print("Enter humidity (%): ");
            double hum = sc.nextDouble();
            sc.nextLine(); // Consume newline
            forecasts[i] = new Forecast(city, temp, hum);
        }
    }
    void displayWeatherForecasts() {
        System.out.println("\nWeather Forecasts:");
        for (int i = 0; i < count; i++) {
            forecasts[i].displayForecast();
        }
    }
}

class weatherForecast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of cities: ");
        int count = scan.nextInt();
        scan.nextLine(); // Consume newline
        Weather weather = new Weather(count);
        weather.inputWeatherData();
        weather.displayWeatherForecasts();
    }
}

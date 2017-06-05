package treefsm.fsm;

public enum WeatherCondition {
    RAINY("Rainy"),
    SUNNY("Sunny");

    private final String weather;

    private WeatherCondition(String aWeather) {
        this.weather = aWeather;
    }

    @Override
    public String toString() {
        return this.weather;
    }
}

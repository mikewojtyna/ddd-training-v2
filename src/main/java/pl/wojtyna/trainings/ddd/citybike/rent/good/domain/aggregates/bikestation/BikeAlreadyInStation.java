package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

public class BikeAlreadyInStation extends RuntimeException {

    public BikeAlreadyInStation(String message) {
        super(message);
    }

    public BikeAlreadyInStation(String message, Throwable cause) {
        super(message, cause);
    }
}

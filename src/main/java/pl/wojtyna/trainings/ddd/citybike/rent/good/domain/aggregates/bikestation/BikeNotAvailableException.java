package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

public class BikeNotAvailableException extends RuntimeException {

    public BikeNotAvailableException(String message) {
        super(message);
    }

    public BikeNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}

package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

public class MaximumRentalDurationExceededException extends RuntimeException {

    public MaximumRentalDurationExceededException(String message) {
        super(message);
    }

    public MaximumRentalDurationExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}

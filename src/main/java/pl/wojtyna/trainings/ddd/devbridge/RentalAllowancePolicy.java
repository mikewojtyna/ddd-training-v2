package pl.wojtyna.trainings.ddd.devbridge;

public interface RentalAllowancePolicy {

    boolean isAllowedToRentABike(User user);
}

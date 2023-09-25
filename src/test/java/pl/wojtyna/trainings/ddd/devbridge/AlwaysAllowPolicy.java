package pl.wojtyna.trainings.ddd.devbridge;

public class AlwaysAllowPolicy implements RentalAllowancePolicy {

    @Override
    public boolean isAllowedToRentABike(User user) {
        return true;
    }
}

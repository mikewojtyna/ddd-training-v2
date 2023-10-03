package pl.wojtyna.trainings.ddd.devbridge.tracking;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

public class TrackingSystem {

    private Bike currentBike;
    private Bike bikePreviously;
    private City city;

    private TrackingSystem(City city) {
        this.city = city;
    }

    public static TrackingSystem withinA(City city) {
        return new TrackingSystem(city);
    }

    public DomainEvents startTracking(Bike bike) {

        return null;
    }

    public DomainEvents updateLocationOf(Bike bike, Location location) {
        if(city.isOutsideOfBoundaries(location)) {
            return DomainEvents.of(new BikeLeftTheCity());
        }
        policy.checkIfBikeIsStolen(bike)
        if(!bikePreviously.location().equals(location)) {
            currentBike = bike.withNewLocation(location);
            return DomainEvents.of(new BikeMoved());
        }
    }
}

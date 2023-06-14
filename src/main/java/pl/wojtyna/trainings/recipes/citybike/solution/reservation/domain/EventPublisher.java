package pl.wojtyna.trainings.recipes.citybike.solution.reservation.domain;

public interface EventPublisher {

    void publish(BikeReservationLocalEvent event);
}

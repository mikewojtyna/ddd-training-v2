package pl.wojtyna.trainings.recipes.citybike.task.reservation.domain;

public interface EventPublisher {

    void publish(BikeReservationLocalEvent event);
}

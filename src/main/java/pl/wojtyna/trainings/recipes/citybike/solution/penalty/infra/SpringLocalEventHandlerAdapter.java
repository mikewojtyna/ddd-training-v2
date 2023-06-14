package pl.wojtyna.trainings.recipes.citybike.solution.penalty.infra;

import org.springframework.context.event.EventListener;
import pl.wojtyna.trainings.recipes.citybike.solution.penalty.api.event.handlers.ReservationEventHandler;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.events.BikeReservationPublicEvent;

public class SpringLocalEventHandlerAdapter {

    private final ReservationEventHandler reservationEventHandler;

    public SpringLocalEventHandlerAdapter(ReservationEventHandler reservationEventHandler) {this.reservationEventHandler = reservationEventHandler;}

    @EventListener
    public void handle(BikeReservationPublicEvent event) {
        reservationEventHandler.handle(event);
    }
}

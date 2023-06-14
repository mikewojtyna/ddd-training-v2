package pl.wojtyna.trainings.recipes.citybike.solution.tracking.infra;

import org.springframework.context.event.EventListener;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.events.BikeReservationPublicEvent;
import pl.wojtyna.trainings.recipes.citybike.solution.tracking.api.event.handlers.ReservationEventHandler;

public class SpringLocalEventHandlerAdapter {

    private final ReservationEventHandler reservationEventHandler;

    public SpringLocalEventHandlerAdapter(ReservationEventHandler reservationEventHandler) {this.reservationEventHandler = reservationEventHandler;}

    @EventListener
    public void handle(BikeReservationPublicEvent event) {
        reservationEventHandler.handle(event);
    }
}

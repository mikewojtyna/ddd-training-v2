package pl.wojtyna.trainings.recipes.citybike.solution.map;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.wojtyna.trainings.recipes.citybike.solution.reservation.api.events.BikeReservationPublicEvent;

@Component
public class BikeReservationReadModelUpdaterHandler {

    private MapReadDatabase mapReadDatabase;

    public BikeReservationReadModelUpdaterHandler(MapReadDatabase mapReadDatabase) {
        this.mapReadDatabase = mapReadDatabase;
    }

    @EventListener
    public void handle(BikeReservationPublicEvent event) {
        switch (event) {
            case BikeReservationPublicEvent.BikeRented bikeRented ->
                mapReadDatabase.readData().getBikeStations().stream()
                               .filter(station -> station.getId().equals(bikeRented.stationId())).findAny().ifPresent(
                                   station -> {
                                       station.getBikes().stream().filter(bike -> bike.getId().equals(bikeRented.bikeId())).findAny()
                                              .ifPresent(bike -> {
                                                  bike.setAvailable(false);
                                              });
                                   });
            case BikeReservationPublicEvent.BikeReturned bikeReturned -> {
                mapReadDatabase.readData().getBikeStations().stream()
                               .filter(station -> station.getId().equals(bikeReturned.stationId())).findAny().ifPresent(
                                   station -> {
                                       station.getBikes().stream().filter(bike -> bike.getId().equals(bikeReturned.bikeId())).findAny()
                                              .ifPresent(bike -> {
                                                  bike.setAvailable(true);
                                              });
                                   });
            }
        }
    }
}
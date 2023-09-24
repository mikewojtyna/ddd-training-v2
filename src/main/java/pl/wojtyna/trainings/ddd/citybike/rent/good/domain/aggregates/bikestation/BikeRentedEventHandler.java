package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

public class BikeRentedEventHandler {

    public void handle(BikeRentalEvent event) {
        switch (event) {
            case BikeRentalEvent.BikeRented bikeRented -> {
            }
            case BikeRentalEvent.BikeReturned bikeReturned -> {
            }
        }
    }
}
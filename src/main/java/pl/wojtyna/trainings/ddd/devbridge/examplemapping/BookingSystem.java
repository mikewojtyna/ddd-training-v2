package pl.wojtyna.trainings.ddd.devbridge.examplemapping;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.wojtyna.trainings.ddd.devbridge.Bike;
import pl.wojtyna.trainings.ddd.devbridge.BikeRentalRejected;
import pl.wojtyna.trainings.ddd.devbridge.DomainEvents;

public class BookingSystem {

    public BookingSystem(int i) {

    }

    public DomainEvents book(Renter renter) {
        if(renter.money().isLessThan(Money.of(CurrencyUnit.EUR, 50))) {
            return DomainEvents.of(new BikeRentalRejected());
        }
        return DomainEvents.of(new BikeBooked());
    }

    public void placeNew(Bike bike) {

    }
}

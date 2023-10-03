package pl.wojtyna.trainings.ddd.devbridge.tracking;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation.BikeId;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

import static org.assertj.core.api.Fail.fail;

@DisplayName("Some examples how bike can be tracked taken from the https://miro.com/app/board/uXjVNf5TY-w=/?share_link_id=763444029849")
class BikeTrackingExamplesTest {

    // @formatter:off
    @DisplayName(
        """
         tracking starts immediately
        """
    )
    // @formatter:on
    @Test
    void test0() {
        // given
        var trackingSystem = new TrackingSystem();

        // when
        DomainEvents events = trackingSystem.startTracking(bike);

        // then
        events.hasOccurredEventOfType(TrackingStartedImmediately.class);
    }

    // @formatter:off
    @DisplayName(
        """
         given bike starts its location at 0,0,
         when bike location changed after some time to 5,0,
         then bike is moved
        """
    )
    // @formatter:on
    @Test
    void test1() {
        // given
        var trackingSystem = new TrackingSystem();
        var bike = new Bike(new BikeId(), new Location(0, 0));
        trackingSystem.startTracking(bike);

        // when
        DomainEvents locationChangedEvents = trackingSystem.updateLocationOf(bike, new Location(5, 0));

        // then
        locationChangedEvents.hasOccurredEventOfType(BikeMoved.class);
    }

    // @formatter:off
    @DisplayName(
        """
         given bike starts its location at 0,0,
         when bike location changed after some time to 0,0,
         then bike is not moved
        """
    )
    // @formatter:on
    @Test
    void test2() {
        // given
        var trackingSystem = new TrackingSystem();
        var bike = new Bike(new BikeId(), new Location(0, 0));
        trackingSystem.startTracking(bike);

        // when
        DomainEvents locationChangedEvents = trackingSystem.updateLocationOf(bike, new Location(0, 0));

        // then
        locationChangedEvents.hasNotOccurredEventOfType(BikeMoved.class);
    }

    // @formatter:off
    @DisplayName(
        """
         given bike starts its location at 0,0
         and city center is located at 100, 100,  
         when bike location changed after some time to 101,50,
         then bike left the city
        """
    )
    // @formatter:on
    @Test
    void test3() {
        // given
        var trackingSystem = TrackingSystem.withinA(new City(new Location(100, 100)));
        var bike = new Bike(new BikeId(), new Location(0, 0));
        trackingSystem.startTracking(bike);

        // when
        DomainEvents locationChangedEvents = trackingSystem.updateLocationOf(bike, new Location(101, 50));

        // then
        locationChangedEvents.hasNotOccurredEventOfType(BikeLeftTheCity.class);
    }
}

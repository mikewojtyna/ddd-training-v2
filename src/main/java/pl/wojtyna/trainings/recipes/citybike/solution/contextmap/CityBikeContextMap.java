package pl.wojtyna.trainings.recipes.citybike.solution.contextmap;

import guru.nidi.graphviz.engine.Format;
import org.contextmapper.contextmap.generator.ContextMapGenerator;
import org.contextmapper.contextmap.generator.model.*;

import java.io.IOException;

public class CityBikeContextMap {

    public static void main(String[] args) throws IOException {
        var reservation = new BoundedContext("Reservation");
        var tracking = new BoundedContext("Tracking");
        var penalty = new BoundedContext("Penalty");
        var billing = new BoundedContext("Billing");
        var userRegistrationAndIdentity = new BoundedContext("User registration and identity");

        var contextMap = new ContextMap()
            .addBoundedContext(reservation)
            .addBoundedContext(tracking)
            .addBoundedContext(penalty)
            .addBoundedContext(billing)
            .addBoundedContext(userRegistrationAndIdentity)
            .addRelationship(new UpstreamDownstreamRelationship(
                reservation,
                tracking).setUpstreamPatterns(UpstreamPatterns.PUBLISHED_LANGUAGE)
                         .setDownstreamPatterns(DownstreamPatterns.CONFORMIST)
                         .setImplementationTechnology("events"))
            .addRelationship(new UpstreamDownstreamRelationship(billing,
                                                                reservation).setUpstreamPatterns(
                UpstreamPatterns.OPEN_HOST_SERVICE).setDownstreamPatterns(
                DownstreamPatterns.CONFORMIST).setCustomerSupplier(false))
            .addRelationship(new UpstreamDownstreamRelationship(billing, penalty).setUpstreamPatterns(
                                                                                     UpstreamPatterns.OPEN_HOST_SERVICE).setDownstreamPatterns(DownstreamPatterns.ANTICORRUPTION_LAYER)
                                                                                 .setCustomerSupplier(true));
        new ContextMapGenerator().generateContextMapGraphic(contextMap,
                                                            Format.PNG,
                                                            "target/city-bike-context-map-task.png");
    }
}

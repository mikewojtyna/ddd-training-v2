package pl.wojtyna.trainings.ddd;

import guru.nidi.graphviz.engine.Format;
import org.contextmapper.contextmap.generator.ContextMapGenerator;
import org.contextmapper.contextmap.generator.model.*;

import java.io.IOException;

public class ContextMapperExample {

    public static void main(String[] args) throws IOException {
        var sales = new BoundedContext("Sales");
        var warehouse = new BoundedContext("Warehouse");

        var contextMap = new ContextMap()
            .addBoundedContext(sales)
            .addBoundedContext(warehouse)
            .addRelationship(new UpstreamDownstreamRelationship(sales, warehouse).setCustomerSupplier(true)
                                                                                 .setUpstreamPatterns(UpstreamPatterns.OPEN_HOST_SERVICE)
                                                                                 .setDownstreamPatterns(
                                                                                     DownstreamPatterns.ANTICORRUPTION_LAYER)
                                                                                 .setImplementationTechnology("REST"));
        new ContextMapGenerator().generateContextMapGraphic(contextMap, Format.PNG, "/tmp/context-map.png");
    }
}

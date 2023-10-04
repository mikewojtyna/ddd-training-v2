package pl.wojtyna.trainings.recipes.citybike.solution.map;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class BikeStation {
    private UUID id;
    private List<Bike> bikes;
    private int totalCountOfBikes;
}

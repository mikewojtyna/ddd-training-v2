package pl.wojtyna.trainings.recipes.citybike.solution.map;

import lombok.Data;

import java.util.UUID;

@Data
public class Bike {
    private UUID id;
    private UUID stationId;
    private boolean isAvailable;
    private Renter renter;
}

package pl.wojtyna.trainings.recipes.citybike.solution.map;

import lombok.Data;

import java.util.List;

@Data
public class MapReadData {
    private List<BikeStation> bikeStations;
    private City city;
}

package pl.wojtyna.trainings.recipes.citybike.solution.map;

import lombok.Data;

import java.util.UUID;

@Data
public class Renter {
    private UUID id;
    private String name;
    private String surname;
}

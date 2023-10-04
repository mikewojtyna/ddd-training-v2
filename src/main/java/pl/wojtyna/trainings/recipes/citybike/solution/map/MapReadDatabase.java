package pl.wojtyna.trainings.recipes.citybike.solution.map;

public interface MapReadDatabase {

    MapReadData readData();
    void save(MapReadData mapReadData);
}

package pl.wojtyna.trainings.ddd.devbridge.chair.warehouse;

public class Warehouse {

    private Dimensions dimensions;

    public static Warehouse of(Dimensions dimensions) {
        return new Warehouse(dimensions);
    }

    private Warehouse(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public int howManyChairCanFit(Chair chair) {
        return 0;
    }
}

package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

public interface FluentLanguage {

    @FunctionalInterface
    interface ByFunction<S, R> {

        R by(S s);
    }

    @FunctionalInterface
    interface ForDurationFunction<S, R> {

        R forDuration(S s);
    }
}

package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

public interface FluentLanguage {

    @FunctionalInterface
    interface By<S, R> {

        R by(S s);
    }

    @FunctionalInterface
    interface ForDuration<S, R> {

        R forDuration(S s);
    }
}

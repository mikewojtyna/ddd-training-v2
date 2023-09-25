package pl.wojtyna.trainings.ddd.devbridge;

public record DomainResult<R>(R result, DomainEvents events) {
}

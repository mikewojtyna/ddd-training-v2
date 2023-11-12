package pl.wojtyna.trainings.recipes.solutions.task6.services;

import pl.wojtyna.trainings.recipes.solutions.task6.domain.Event;

public interface EventPublisher {

    void publish(Event event);
}

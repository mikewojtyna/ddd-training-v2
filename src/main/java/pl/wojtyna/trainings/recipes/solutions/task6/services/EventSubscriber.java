package pl.wojtyna.trainings.recipes.solutions.task6.services;

import pl.wojtyna.trainings.recipes.solutions.task6.domain.Event;

public interface EventSubscriber {

    void handle(Event event);

    boolean supports(Class<? extends Event> type);
}

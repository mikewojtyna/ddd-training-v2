package pl.wojtyna.trainings.recipes.solutions.task6.services;

import pl.wojtyna.trainings.recipes.solutions.task6.domain.Event;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.Project;

public record ProjectProposedEvent(Project project) implements Event {
}

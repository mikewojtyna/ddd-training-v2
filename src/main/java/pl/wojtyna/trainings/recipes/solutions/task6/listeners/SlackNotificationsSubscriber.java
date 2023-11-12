package pl.wojtyna.trainings.recipes.solutions.task6.listeners;

import pl.wojtyna.trainings.recipes.solutions.task6.domain.ProjectRejectedEvent;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.Event;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.ProjectAcceptedEvent;
import pl.wojtyna.trainings.recipes.solutions.task6.services.EventSubscriber;
import pl.wojtyna.trainings.recipes.solutions.task6.services.SlackNotifications;

import java.util.Set;

public class SlackNotificationsSubscriber implements EventSubscriber {

    private final Set<Class<? extends Event>> supportedEvents = Set.of(ProjectAcceptedEvent.class,
                                                                       ProjectRejectedEvent.class);
    private final SlackNotifications slackNotifications;

    public SlackNotificationsSubscriber(SlackNotifications slackNotifications) {this.slackNotifications = slackNotifications;}

    @Override
    public void handle(Event event) {
        System.out.println("Sending slack notification for " + event.getClass().getSimpleName());
        slackNotifications.sendSlackMessage("Some message");
    }

    @Override
    public boolean supports(Class<? extends Event> type) {
        return supportedEvents.contains(type);
    }
}

package pl.wojtyna.trainings.recipes.solutions.task6.listeners;

import pl.wojtyna.trainings.recipes.solutions.task6.services.MarketingProcess;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.Event;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.Project;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.ProjectFundraisingStartedEvent;
import pl.wojtyna.trainings.recipes.solutions.task6.services.EventSubscriber;

public class MarketingProcessSubscriber implements EventSubscriber {

    private final MarketingProcess marketingProcess;

    public MarketingProcessSubscriber(MarketingProcess marketingProcess) {
        this.marketingProcess = marketingProcess;
    }

    @Override
    public void handle(Event event) {
        System.out.println("Marketing process started for " + event.getClass().getSimpleName());
        marketingProcess.beginCampaign("Campaign name", extractProjectFrom(event));
    }

    @Override
    public boolean supports(Class<? extends Event> type) {
        return ProjectFundraisingStartedEvent.class.isAssignableFrom(type);
    }

    private Project extractProjectFrom(Event event) {
        // some fake borrower extraction
        // here will be some more complex logic
        return new Project();
    }
}

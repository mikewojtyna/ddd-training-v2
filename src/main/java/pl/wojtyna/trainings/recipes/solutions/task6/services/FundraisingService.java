package pl.wojtyna.trainings.recipes.solutions.task6.services;

import org.joda.money.Money;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.ProjectAcceptedEvent;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.ProjectFundraisingStartedEvent;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.ProjectRejectedEvent;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.Project;

public class FundraisingService {

    private final EventPublisher eventPublisher;

    public FundraisingService(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Project createProposalDraft(String title,
                                       String description,
                                       Money goal,
                                       String loanSchedule,
                                       double interestRate,
                                       int creditScore) {
        return new Project(title, description, goal, loanSchedule, interestRate, creditScore, "DRAFT", false);
    }

    public void proposeProject(Project project) {
        if ("DRAFT".equals(project.status())) {
            project.setStatus("PENDING");
            project.setProposal(true);
            eventPublisher.publish(new ProjectProposedEvent(project));
        }
    }

    public void rejectProposal(Project project) {
        if (project.isProposal()) {
            project.setStatus("REJECTED");
            eventPublisher.publish(new ProjectRejectedEvent(project));
        }
    }

    public void acceptProposal(Project project) {
        if (project.isProposal()) {
            project.setStatus("ACCEPTED");
            project.setProposal(false);
            project.setProject(true);
            eventPublisher.publish(new ProjectAcceptedEvent(project));
        }
    }

    public void startFundraising(Project project) {
        if ("ACCEPTED".equals(project.status())) {
            project.setStatus("FUNDRAISING");
            eventPublisher.publish(new ProjectFundraisingStartedEvent(project));
        }
    }

}

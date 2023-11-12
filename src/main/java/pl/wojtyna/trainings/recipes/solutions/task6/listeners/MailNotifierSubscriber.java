package pl.wojtyna.trainings.recipes.solutions.task6.listeners;

import pl.wojtyna.trainings.recipes.solutions.task6.domain.Event;
import pl.wojtyna.trainings.recipes.solutions.task6.services.EventSubscriber;
import pl.wojtyna.trainings.recipes.solutions.task6.services.InvestorAndBorrowerFinder;
import pl.wojtyna.trainings.recipes.solutions.task6.services.MailAddressFinder;
import pl.wojtyna.trainings.recipes.solutions.task6.services.MailNotifications;

public class MailNotifierSubscriber implements EventSubscriber {

    private final MailNotifications mailNotifications;
    private final InvestorAndBorrowerFinder investorAndBorrowerFinder;
    private final MailAddressFinder mailAddressFinder;

    public MailNotifierSubscriber(MailNotifications mailNotifications,
                                  InvestorAndBorrowerFinder investorAndBorrowerFinder,
                                  MailAddressFinder mailAddressFinder) {
        this.mailNotifications = mailNotifications;
        this.investorAndBorrowerFinder = investorAndBorrowerFinder;
        this.mailAddressFinder = mailAddressFinder;
    }

    @Override
    public void handle(Event event) {
        System.out.println("Sending mail notification for " + event.getClass().getSimpleName());
        var borrower = investorAndBorrowerFinder.findBorrowerByName(extractBorrowerFrom(event));
        mailNotifications.sendMail(mailAddressFinder.findMailAddress(borrower),
                                   "Some subject",
                                   "Some message");
    }

    @Override
    public boolean supports(Class<? extends Event> type) {
        return true;
    }

    private String extractBorrowerFrom(Event event) {
        // some fake borrower extraction
        // here will be some more complex logic
        return "George The Borrower";
    }
}

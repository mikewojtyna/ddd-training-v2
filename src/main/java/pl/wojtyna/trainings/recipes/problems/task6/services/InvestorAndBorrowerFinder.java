package pl.wojtyna.trainings.recipes.problems.task6.services;

import pl.wojtyna.trainings.recipes.problems.task6.domain.Borrower;
import pl.wojtyna.trainings.recipes.problems.task6.domain.Investor;

public class InvestorAndBorrowerFinder {

    private final InvestorsRegistry investorsRegistry = new InvestorsRegistry();
    private final BorrowersRegistry borrowersRegistry = new BorrowersRegistry();

    public Investor findByName(String name) {
        return investorsRegistry.getInvestors().stream().filter(investor -> investor.name().equals(name)).findAny()
                                .orElseThrow();
    }

    public Borrower findBorrowerByName(String name) {
        return borrowersRegistry.getBorrowers().stream().filter(borrower -> borrower.name().equals(name)).findAny()
                                .orElseThrow();
    }
}

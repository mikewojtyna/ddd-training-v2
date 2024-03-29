package pl.wojtyna.trainings.recipes.problems.task6.services;

import pl.wojtyna.trainings.recipes.problems.task6.domain.Investor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InvestorsRegistry {

    private final List<Investor> investors;

    public InvestorsRegistry() {
        this.investors = loadInitialDataFromSomeVerySlowDatabase();
    }

    public void register(Investor investor) {
        investors.add(investor);
    }

    public void unregister(Investor investor) {
        investors.remove(investor);
    }

    public List<Investor> getInvestors() {
        return investors;
    }

    private List<Investor> loadInitialDataFromSomeVerySlowDatabase() {
        try {
            TimeUnit.SECONDS.sleep(2);
            return new ArrayList<>();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

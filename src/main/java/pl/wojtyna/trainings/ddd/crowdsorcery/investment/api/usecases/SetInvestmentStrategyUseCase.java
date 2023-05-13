package pl.wojtyna.trainings.ddd.crowdsorcery.investment.api.usecases;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import pl.wojtyna.trainings.ddd.crowdsorcery.investment.invest.Strategies;
import pl.wojtyna.trainings.ddd.crowdsorcery.investment.invest.Strategy;

@PrimaryPort
public class SetInvestmentStrategyUseCase {

    private final Strategies strategies;

    public SetInvestmentStrategyUseCase(Strategies strategies) {
        this.strategies = strategies;
    }

    public void setInvestmentStrategy(Strategy strategy) {
        strategies.set(strategy);
    }
}

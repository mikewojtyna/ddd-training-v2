package pl.wojtyna.trainings.ddd.crowdsorcery.fundraising;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;
import pl.wojtyna.trainings.ddd.crowdsorcery.investment.invest.Investor;

public class FundraisingSystem {

    public ByFunction<Investor, BasedOnFunction<ProjectForm, DomainEvents>> startFundraising() {
        return null;
    }

    @FunctionalInterface
    public interface ByFunction<S, R> {

        R by(S s);
    }

    @FunctionalInterface
    public interface BasedOnFunction<S, R> {

        R basedOn(S s);
    }
}

package pl.wojtyna.trainings.ddd.crowdsorcery.fundraising;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;
import pl.wojtyna.trainings.ddd.crowdsorcery.investment.invest.Investor;

public record ProjectFundraisingStarted(Investor investor, ProjectForm projectForm) implements DomainEvent {

}

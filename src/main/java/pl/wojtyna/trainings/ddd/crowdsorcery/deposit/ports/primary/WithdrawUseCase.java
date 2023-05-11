package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.ports.primary;

import org.joda.money.Money;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.EventPublisher;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.AccountId;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.ports.secondary.AccountRepository;

public class WithdrawUseCase {

    private final AccountRepository accountRepository;
    private final EventPublisher eventPublisher;

    public WithdrawUseCase(AccountRepository accountRepository, EventPublisher eventPublisher) {
        this.accountRepository = accountRepository;
        this.eventPublisher = eventPublisher;
    }

    public void withdraw(Money amount, AccountId id) {
        accountRepository.load(id).ifPresent(account -> {
            var events = account.withdraw(amount);
            accountRepository.save(account);
            events.publishUsing(eventPublisher);
        });
    }
}

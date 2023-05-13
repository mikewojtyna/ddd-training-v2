package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.api.usecases.WithdrawUseCase;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Account;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.AccountId;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.AccountRepository;

import java.util.Optional;

@Configuration
public class DepositContextConfig {

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepository() {
            @Override
            public Optional<Account> load(AccountId id) {
                return Optional.empty();
            }

            @Override
            public void save(Account account) {

            }
        };
    }

    @Bean
    public WithdrawUseCase withdrawUseCase(AccountRepository accountRepository, DomainEventPublisher eventPublisher) {
        return new WithdrawUseCase(accountRepository, eventPublisher);
    }
}

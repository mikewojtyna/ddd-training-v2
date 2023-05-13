package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.api.usecases.CreateAccountUseCase;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.api.usecases.WithdrawUseCase;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Account;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.AccountId;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.AccountRepository;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.PaymentVerifiedPolicy;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment.DepositInitiatedPolicy;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment.PaymentProcessor;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.event.LocalEventsHandler;

import java.util.Optional;

@Configuration
public class DepositContextConfig {

    @Bean
    public CreateAccountUseCase createAccountUseCase(AccountRepository accountRepository) {
        return new CreateAccountUseCase(accountRepository);
    }

    @Bean
    public PaymentVerifiedPolicy paymentVerifiedPolicy(AccountRepository accountRepository,
                                                       DomainEventPublisher eventPublisher) {
        return new PaymentVerifiedPolicy(accountRepository, eventPublisher);
    }

    @Bean
    public LocalEventsHandler localEventsHandler(DepositInitiatedPolicy depositInitiatedPolicy,
                                                 PaymentVerifiedPolicy paymentVerifiedPolicy) {
        return new LocalEventsHandler(depositInitiatedPolicy, paymentVerifiedPolicy);
    }

    @Bean
    public DepositInitiatedPolicy depositInitiatedPolicy(PaymentProcessor paymentProcessor) {
        return new DepositInitiatedPolicy(paymentProcessor);
    }

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

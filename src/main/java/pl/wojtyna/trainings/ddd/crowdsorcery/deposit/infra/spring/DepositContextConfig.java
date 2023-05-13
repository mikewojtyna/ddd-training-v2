package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEventPublisher;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.api.usecases.WithdrawUseCase;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.*;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment.DepositInitiatedPolicy;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment.PaymentProcessor;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.secondary.PaymentGatewayBoundedContextIntegrationProcessor;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.secondary.PendingPayments;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentGateway;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentToken;

import java.util.Optional;

@Configuration
public class DepositContextConfig {

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
    public PaymentProcessor paymentProcessor() {
        return new PaymentGatewayBoundedContextIntegrationProcessor(PaymentGateway.defaultGateway(),
                                                                    new PendingPayments() {
                                                                        @Override
                                                                        public void add(PaymentToken paymentToken,
                                                                                        Deposit deposit) {

                                                                        }

                                                                        @Override
                                                                        public PaymentToken getPaymentToken(Deposit deposit) {
                                                                            return null;
                                                                        }
                                                                    });
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

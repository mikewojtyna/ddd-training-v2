package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainPolicy;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.DepositInitiated;

public class DepositInitiatedPolicy implements DomainPolicy {

    private final PaymentProcessor paymentProcessor;

    public DepositInitiatedPolicy(PaymentProcessor paymentProcessor) {this.paymentProcessor = paymentProcessor;}

    public void handle(DepositInitiated event) {
        paymentProcessor.process(event.deposit());
    }
}

package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.secondary.paymentctxacl;

import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Deposit;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentToken;

public interface PendingPayments {

    void add(PaymentToken paymentToken, Deposit deposit);

    PaymentToken getPaymentToken(Deposit deposit);
}

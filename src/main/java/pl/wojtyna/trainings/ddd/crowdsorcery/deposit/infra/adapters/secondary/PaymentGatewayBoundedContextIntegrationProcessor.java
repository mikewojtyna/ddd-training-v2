package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.secondary;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Deposit;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.confirmation.DepositConfirmed;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.confirmation.PaymentProcessor;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentEvent;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentGateway;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentRequest;

import java.util.concurrent.Flow;

@SecondaryAdapter
public class PaymentGatewayBoundedContextIntegrationProcessor implements PaymentProcessor {

    // this is a dependency on another bounded context
    // we keep it isolated from our domain as a form of ACL
    private final PaymentGateway paymentGateway;
    private final PendingPayments pendingPayments;

    public PaymentGatewayBoundedContextIntegrationProcessor(PaymentGateway paymentGateway,
                                                            PendingPayments pendingPayments) {
        this.paymentGateway = paymentGateway;
        this.pendingPayments = pendingPayments;
    }

    @Override
    public void process(Deposit deposit) {
        var paymentToken = paymentGateway.pay(translateToPaymentGatewayRequest(deposit));
        pendingPayments.add(paymentToken, deposit);
    }

    @Override
    public Flow.Publisher<DepositConfirmed> confirmationEvents(Deposit deposit) {
        return translate(paymentGateway.events(pendingPayments.getPaymentToken(deposit)));
    }

    private Flow.Publisher<DepositConfirmed> translate(Flow.Publisher<PaymentEvent> events) {
        throw new UnsupportedOperationException();
    }

    private PaymentRequest translateToPaymentGatewayRequest(Deposit deposit) {
        throw new UnsupportedOperationException();
    }
}

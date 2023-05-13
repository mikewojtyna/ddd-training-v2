package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.secondary.paymentctxacl;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Deposit;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment.PaymentProcessor;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment.PaymentVerified;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentEvent;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentGateway;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentRequest;

import java.util.concurrent.Flow;

@SecondaryAdapter
public class PaymentGatewayBoundedContextIntegrationProcessor implements PaymentProcessor {

    // this is a dependency on another bounded context
    // we keep it isolated from our domain
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
    public Flow.Publisher<PaymentVerified> verifiedEvents(Deposit deposit) {
        return translate(paymentGateway.events(pendingPayments.getPaymentToken(deposit)));
    }

    private Flow.Publisher<PaymentVerified> translate(Flow.Publisher<PaymentEvent> events) {
        throw new UnsupportedOperationException();
    }

    private PaymentRequest translateToPaymentGatewayRequest(Deposit deposit) {
        throw new UnsupportedOperationException();
    }
}

package pl.wojtyna.trainings.ddd.crowdsorcery.payment.api;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import java.util.concurrent.Flow;

@PrimaryPort
public interface PaymentGateway {

    PaymentToken pay(PaymentRequest paymentRequest);

    boolean isVerified(PaymentToken paymentToken);

    Flow.Publisher<PaymentEvent> events(PaymentToken token);
}

package pl.wojtyna.trainings.ddd.crowdsorcery.payment.crypto;

import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentEvent;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentGateway;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentRequest;
import pl.wojtyna.trainings.ddd.crowdsorcery.payment.api.PaymentToken;

import java.util.concurrent.Flow;

public class CryptoProvider implements PaymentGateway {

    @Override
    public PaymentToken pay(PaymentRequest paymentRequest) {
        return null;
    }

    @Override
    public boolean isVerified(PaymentToken paymentToken) {
        return false;
    }

    @Override
    public Flow.Publisher<PaymentEvent> events(PaymentToken token) {
        return null;
    }
}

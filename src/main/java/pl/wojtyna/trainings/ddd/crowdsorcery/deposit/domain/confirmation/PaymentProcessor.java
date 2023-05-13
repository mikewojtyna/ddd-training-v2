package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.confirmation;

import org.jmolecules.architecture.hexagonal.SecondaryPort;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Deposit;

import java.util.concurrent.Flow;

@SecondaryPort
public interface PaymentProcessor {

    void process(Deposit deposit);

    Flow.Publisher<DepositConfirmed> confirmationEvents(Deposit deposit);
}

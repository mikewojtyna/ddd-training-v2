package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.payment;

import org.jmolecules.architecture.hexagonal.SecondaryPort;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.Deposit;

@SecondaryPort
public interface PaymentProcessor {

    void process(Deposit deposit);
}

package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.api.usecases;

import org.jmolecules.architecture.hexagonal.PrimaryPort;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.AccountRepository;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account.DepositAccount;

@PrimaryPort
public class CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount() {
        accountRepository.save(newAccount());
    }

    private DepositAccount newAccount() {
        throw new UnsupportedOperationException();
    }
}

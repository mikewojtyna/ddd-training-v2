package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.ports.secondary;

import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.Account;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.AccountId;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> load(AccountId id);

    void save(Account account);
}

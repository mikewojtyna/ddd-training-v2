package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.secondary;

import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.Account;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.AccountId;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.ports.secondary.AccountRepository;

import java.util.Optional;

public class InMemoryAccountRepository implements AccountRepository {

    @Override
    public Optional<Account> load(AccountId id) {
        return Optional.empty();
    }

    @Override
    public void save(Account account) {

    }
}

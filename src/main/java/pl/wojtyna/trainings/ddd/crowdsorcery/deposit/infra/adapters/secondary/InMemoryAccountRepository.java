package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.secondary;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.Account;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.AccountId;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.AccountRepository;

import java.util.Optional;

@SecondaryAdapter
public class InMemoryAccountRepository implements AccountRepository {

    @Override
    public Optional<Account> load(AccountId id) {
        return Optional.empty();
    }

    @Override
    public void save(Account account) {

    }
}

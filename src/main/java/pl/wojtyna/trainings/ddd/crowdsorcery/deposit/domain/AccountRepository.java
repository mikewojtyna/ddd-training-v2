package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import java.util.Optional;

@SecondaryPort
public interface AccountRepository {

    Optional<Account> load(AccountId id);

    void save(Account account);
}

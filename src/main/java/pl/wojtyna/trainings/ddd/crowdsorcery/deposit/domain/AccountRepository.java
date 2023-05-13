package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain;

import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.jmolecules.ddd.annotation.Repository;

import java.util.Optional;

@Repository
@SecondaryPort
public interface AccountRepository {

    Optional<Account> load(AccountId id);

    void save(Account account);
}

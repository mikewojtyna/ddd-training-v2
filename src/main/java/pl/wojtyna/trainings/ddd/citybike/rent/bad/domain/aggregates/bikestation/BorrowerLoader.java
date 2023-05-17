package pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation;

import java.util.Optional;

public interface BorrowerLoader {

    Optional<Borrower> borrowerOfId(BorrowerId borrowerId);
}

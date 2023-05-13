package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.account;

public record PendingDeposit(Deposit deposit) {

    public ConfirmedDeposit confirm() {
        return new ConfirmedDeposit(deposit);
    }

    public static PendingDeposit of(Deposit deposit) {
        return new PendingDeposit(deposit);
    }
}

package pl.wojtyna.trainings.ddd.crowdsorcery.investment.invest;

import org.joda.money.Money;
import pl.wojtyna.trainings.ddd.crowdsorcery.investment.transfer.Account;
import pl.wojtyna.trainings.ddd.crowdsorcery.investment.transfer.TransferOperations;

public class InvestOperations {

    private final TransferOperations transferOperations;

    public InvestOperations(TransferOperations transferOperations) {
        this.transferOperations = transferOperations;
    }

    public void invest(Asset asset, Money amount, Investor investor) {
        transferOperations.transfer(findAccountOf(asset), findAccountOf(investor), amount);
    }

    private Account findAccountOf(Investor investor) {
        throw new UnsupportedOperationException();
    }

    private Account findAccountOf(Asset asset) {
        throw new UnsupportedOperationException();
    }
}

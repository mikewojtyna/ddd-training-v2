package pl.wojtyna.trainings.solutions.task1;

import org.joda.money.Money;

public interface DepositService {

    void makeDeposit(Money money, InvestorId investorId);

    void withdraw(Money money, InvestorId investorId);
}

package pl.wojtyna.trainings.recipes.citybike.solution.billing.domain;

import org.joda.money.Money;

import java.util.UUID;

public class BillingDomainService {

    public void charge(UUID userId, Money amount) {
        // charge user
    }

    public void chargeBack(UUID userId, Money amount) {
        // charge back user
    }
}

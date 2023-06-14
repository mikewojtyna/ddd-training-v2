package pl.wojtyna.trainings.recipes.citybike.solution.billing.api;

import org.joda.money.Money;
import pl.wojtyna.trainings.recipes.citybike.solution.billing.domain.BillingDomainService;

import java.util.UUID;

public class ChargeUseCase {

    private final BillingDomainService billingDomainService;

    public ChargeUseCase(BillingDomainService billingDomainService) {
        this.billingDomainService = billingDomainService;
    }

    public void charge(UUID userId, Money amount) {
        billingDomainService.charge(userId, amount);
    }
}

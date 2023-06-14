package pl.wojtyna.trainings.recipes.citybike.solution.billing.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.recipes.citybike.solution.billing.api.ChargeUseCase;
import pl.wojtyna.trainings.recipes.citybike.solution.billing.domain.BillingDomainService;

@Configuration
public class SpringBillingContextConfig {

    @Bean
    public BillingDomainService billingDomainService() {
        return new BillingDomainService();
    }

    @Bean
    public ChargeUseCase chargeUseCase(BillingDomainService billingDomainService) {
        return new ChargeUseCase(billingDomainService);
    }
}

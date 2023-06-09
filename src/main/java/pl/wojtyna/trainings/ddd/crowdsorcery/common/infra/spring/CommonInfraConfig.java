package pl.wojtyna.trainings.ddd.crowdsorcery.common.infra.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEventPublisher;

@Configuration
public class CommonInfraConfig {

    @Bean
    public DomainEventPublisher domainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new SpringEventPublisher(applicationEventPublisher);
    }
}

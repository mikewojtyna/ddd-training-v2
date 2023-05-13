package pl.wojtyna.trainings.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.infra.spring.CommonInfraConfig;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.DepositBoundedContextMarker;
import pl.wojtyna.trainings.ddd.crowdsorcery.profile.ProfileBoundedContextMarker;

@SpringBootApplication(scanBasePackageClasses = {CommonInfraConfig.class, DepositBoundedContextMarker.class, ProfileBoundedContextMarker.class})
public class DddTrainingV2Application {

    public static void main(String[] args) {
        SpringApplication.run(DddTrainingV2Application.class, args);
    }

}

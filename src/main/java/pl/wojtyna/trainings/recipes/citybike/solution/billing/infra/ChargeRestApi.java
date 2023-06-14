package pl.wojtyna.trainings.recipes.citybike.solution.billing.infra;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtyna.trainings.recipes.citybike.solution.billing.api.ChargeUseCase;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class ChargeRestApi {

    private final ChargeUseCase chargeUseCase;

    public ChargeRestApi(ChargeUseCase chargeUseCase) {this.chargeUseCase = chargeUseCase;}

    @PostMapping("/billing/charge")
    public void charge(@RequestBody ChargeRequest request) {
        chargeUseCase.charge(UUID.fromString(request.userId()),
                             Money.of(CurrencyUnit.of(request.currency()), new BigDecimal(request.amount())));
    }

    private record ChargeRequest(String userId, String amount, String currency) {
    }
}

package pl.wojtyna.trainings.recipes.citybike.solution.penalty.infra;

import kong.unirest.Unirest;
import pl.wojtyna.trainings.recipes.citybike.solution.penalty.domain.PenaltyImposer;

import java.util.UUID;

public class BillingContextPenaltyImposer implements PenaltyImposer {

    @Override
    public void imposePenalty(UUID bikeId) {
        Unirest.post("http://localhost:8080/billing/charge")
               .header("Content-Type", "application/json")
               .body(
                   """
                   {"userId": %s, "amount": 10.00, "currency": "PLN"}
                   """.formatted(findOwnerOf(bikeId))
               )
               .asString();
    }

    private UUID findOwnerOf(UUID bikeId) {
        throw new UnsupportedOperationException();
    }
}

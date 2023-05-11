package pl.wojtyna.trainings.ddd.crowdsorcery.deposit.infra.adapters.primary;

import org.joda.money.Money;
import org.springframework.web.bind.annotation.*;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.domain.AccountId;
import pl.wojtyna.trainings.ddd.crowdsorcery.deposit.ports.primary.WithdrawUseCase;

@RestController
@RequestMapping("/accounts/{accountId}/withdrawals")
public class WithdrawRestApi {

    private final WithdrawUseCase withdrawUseCase;

    public WithdrawRestApi(WithdrawUseCase withdrawUseCase) {
        this.withdrawUseCase = withdrawUseCase;
    }

    @PostMapping
    public void withdraw(@RequestBody WithdrawRequest request, @PathVariable("accountId") String accountId) {
        withdrawUseCase.withdraw(toAmount(request), toAccountId(accountId));
    }

    private AccountId toAccountId(String accountId) {
        throw new UnsupportedOperationException();
    }

    private Money toAmount(WithdrawRequest request) {
        throw new UnsupportedOperationException();
    }
}

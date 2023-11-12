package pl.wojtyna.trainings.recipes.solutions.task6.services;

import pl.wojtyna.trainings.recipes.solutions.task6.domain.Borrower;
import pl.wojtyna.trainings.recipes.solutions.task6.domain.Investor;

public interface MailAddressFinder {

    String findMailAddress(Investor investor);

    String findMailAddress(Borrower borrower);
}

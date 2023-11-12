package pl.wojtyna.trainings.recipes.solutions.task6.services;

public interface MailNotifications {

    void sendMail(String to, String subject, String body);
}

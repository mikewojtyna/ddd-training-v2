package pl.wojtyna.trainings.solutions.task1;

public interface DefaultHandlingService {

    void markProjectAsDefaulted(ProjectId projectId);

    void recover(ProjectId projectId);

    void markProjectAsRecovered(ProjectId projectId);
}

package ru.mail.dimaushenko.task.syberry_test_task.service;

import java.util.List;
import ru.mail.dimaushenko.task.syberry_test_task.service.model.Task;

public interface Scheduler {

    public List<Task> schedule(List<Task> tasks);

}

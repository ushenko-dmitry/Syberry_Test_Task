package ru.mail.dimaushenko.task.syberry_test_task.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ru.mail.dimaushenko.task.syberry_test_task.service.Scheduler;
import ru.mail.dimaushenko.task.syberry_test_task.service.model.Task;

public class SchedulerImpl implements Scheduler {

    private final List<Task> sortedTasks = new ArrayList<>();

    @Override
    public List<Task> schedule(List<Task> tasks) {
        int amountSortedTasks = sortedTasks.size();
        for (Task task : tasks) {
            if (!sortedTasks.contains(task)) {
                int amountPredecessors = 0;
                for (Task sortedTask : sortedTasks) {
                    if (task.getPredecessors().contains(sortedTask.getName())) {
                        amountPredecessors++;
                    }
                }
                if (task.getPredecessors().isEmpty() || task.getPredecessors().size() == amountPredecessors) {
                    sortedTasks.add(task);
                }
            }
        }
        if (sortedTasks.size() < tasks.size()) {
            if (amountSortedTasks == sortedTasks.size()) {
                return Collections.emptyList();
            }
            schedule(tasks);
        }
        return sortedTasks;
    }

}

package ru.mail.dimaushenko.task.syberry_test_task.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import ru.mail.dimaushenko.task.syberry_test_task.service.Scheduler;
import ru.mail.dimaushenko.task.syberry_test_task.service.model.Task;

public class SchedulerImplTest {

    public SchedulerImplTest() {
    }

    @Test
    public void testSchedule_Valid_1() {
        Task E = new Task("E", Arrays.asList("B"));
        Task D = new Task("D", Arrays.asList("A", "B"));
        Task A = new Task("A", Arrays.asList());
        Task B = new Task("B", Arrays.asList("A"));
        Task C = new Task("C", Arrays.asList("D", "B"));
        Task F = new Task("F", Arrays.asList("E"));

        List<Task> tasks = Arrays.asList(
                E,
                D,
                A,
                B,
                C,
                F
        );
        Scheduler scheduler = new SchedulerImpl();
        List<Task> schedule = scheduler.schedule(tasks);

        List<Task> result = Arrays.asList(A, B, E, D, C, F);
        assertThat(schedule, is(result));
    }

    @Test
    public void testSchedule_Valid_2() {
        Task D = new Task("D", Arrays.asList());
        Task A = new Task("A", Arrays.asList("B"));
        Task B = new Task("B", Arrays.asList("C"));
        Task C = new Task("C", Arrays.asList("D"));

        List<Task> tasks = Arrays.asList(
                D,
                A,
                B,
                C
        );
        Scheduler scheduler = new SchedulerImpl();
        List<Task> schedule = scheduler.schedule(tasks);

        List<Task> result = Arrays.asList(D, C, B, A);
        assertThat(schedule, is(result));
    }

    @Test
    public void testSchedule_Valid_3() {
        Task A = new Task("A", Arrays.asList());
        Task B = new Task("B", Arrays.asList());
        Task C = new Task("C", Arrays.asList());
        Task D = new Task("D", Arrays.asList());

        List<Task> tasks = Arrays.asList(
                A,
                B,
                C,
                D
        );
        Scheduler scheduler = new SchedulerImpl();
        List<Task> schedule = scheduler.schedule(tasks);

        List<Task> result = Arrays.asList(A, B, C, D);
        assertThat(schedule, is(result));
    }

    @Test
    public void testSchedule_NotValid() {
        Task D = new Task("D", Arrays.asList("A"));
        Task A = new Task("A", Arrays.asList("B"));
        Task B = new Task("B", Arrays.asList("C"));
        Task C = new Task("C", Arrays.asList("D"));

        List<Task> tasks = Arrays.asList(
                D,
                A,
                B,
                C
        );
        Scheduler scheduler = new SchedulerImpl();
        List<Task> schedule = scheduler.schedule(tasks);

        List<Task> result = Collections.emptyList();
        assertThat(schedule, is(result));
    }

}

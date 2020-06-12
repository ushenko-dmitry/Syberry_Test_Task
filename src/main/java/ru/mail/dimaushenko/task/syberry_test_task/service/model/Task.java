package ru.mail.dimaushenko.task.syberry_test_task.service.model;

import java.util.List;

public class Task {

    private String name;
    private List<String> predecessors;

    public Task(String name, List<String> predecessors) {
        this.name = name;
        this.predecessors = predecessors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(List<String> predecessors) {
        this.predecessors = predecessors;
    }

}

package com.company.jmixpm.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "PM_SUBTASK", indexes = {
        @Index(name = "IDX_PM_SUBTASK_TASK", columnList = "TASK_ID")
})
@Entity(name = "pm_Subtask")
public class Subtask {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "ESTIMATION", nullable = false)
    @NotNull
    private Integer estimation;

    @Column(name = "COMPLETED", nullable = false)
    @NotNull
    private Boolean completed = false;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "TASK_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
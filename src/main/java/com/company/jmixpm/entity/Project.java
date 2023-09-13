package com.company.jmixpm.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "PM_PROJECT", indexes = {
        @Index(name = "IDX_PM_PROJECT_UNQ", columnList = "NAME", unique = true)
})
@Entity(name = "pm_Project")
public class Project {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @Column(name = "DEFAULT_TASK_PRIORITY")
    private Integer defaultTaskPriority;

    @Column(name = "DEFAULT_PROJECT", nullable = false)
    @NotNull
    private Boolean defaultProject = false;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public TaskPriority getDefaultTaskPriority() {
        return defaultTaskPriority == null ? null : TaskPriority.fromId(defaultTaskPriority);
    }

    public void setDefaultTaskPriority(TaskPriority defaultTaskPriority) {
        this.defaultTaskPriority = defaultTaskPriority == null ? null : defaultTaskPriority.getId();
    }

    public Boolean getDefaultProject() {
        return defaultProject;
    }

    public void setDefaultProject(Boolean defaultProject) {
        this.defaultProject = defaultProject;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @PostConstruct
    public void postConstruct() {
        setDefaultTaskPriority(TaskPriority.MEDIUM);
    }
}
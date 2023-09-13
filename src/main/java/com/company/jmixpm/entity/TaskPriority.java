package com.company.jmixpm.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum TaskPriority implements EnumClass<Integer> {

    LOW(10),
    MEDIUM(20),
    HIGH(30);

    private final Integer id;

    TaskPriority(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static TaskPriority fromId(Integer id) {
        for (TaskPriority at : TaskPriority.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
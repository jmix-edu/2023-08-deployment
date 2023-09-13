package com.company.jmixpm.security;

import com.company.jmixpm.entity.Task;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "ViewAssignedTasksRole", code = ViewAssignedTasksRole.CODE)
public interface ViewAssignedTasksRole {
    String CODE = "view-assigned-tasks-role";


    @JpqlRowLevelPolicy(entityClass = Task.class,
            where = "{E}.assignee.id = :current_user_id")
    void task();
}
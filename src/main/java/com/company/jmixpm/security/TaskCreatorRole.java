package com.company.jmixpm.security;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Subtask;
import com.company.jmixpm.entity.Task;
import com.company.jmixpm.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "TaskCreator", code = TaskCreatorRole.CODE)
public interface TaskCreatorRole {
    String CODE = "task-creator";

    @EntityAttributePolicy(entityClass = Project.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Project.class, actions = EntityPolicyAction.READ)
    void project();

    @EntityAttributePolicy(entityClass = Task.class, attributes = "dueDate", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Task.class, attributes = {"id", "name", "assignee", "project", "priority", "subtasks"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Task.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void task();

    @EntityAttributePolicy(entityClass = Subtask.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Subtask.class, actions = EntityPolicyAction.ALL)
    void subtask();

    @MenuPolicy(menuIds = {"pm_Task.browse", "pm_Project.browse", "pm_User.browse"})
    @ScreenPolicy(screenIds = {"pm_Task.browse", "pm_Task.edit", "pm_Project.browse", "pm_Subtask.edit", "pm_User.browse", "pm_Project.edit"})
    void screens();

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();
}
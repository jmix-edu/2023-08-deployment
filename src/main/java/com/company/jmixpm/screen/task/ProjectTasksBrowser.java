package com.company.jmixpm.screen.task;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.DialogMode;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

@UiController("pm_ProjectTasksBrowser")
@UiDescriptor("project-tasks-browser.xml")
@DialogMode(width = "800", height = "600")
public class ProjectTasksBrowser extends Screen {
    @Autowired
    private CollectionLoader<Task> tasksDl;

    public ProjectTasksBrowser withProject(@Nullable Project project) {
        if (project != null) {
            tasksDl.setParameter("projectId", project.getId());
        } else {
            tasksDl.removeParameter("projectId");
        }

        tasksDl.load();

        return this;
    }
}
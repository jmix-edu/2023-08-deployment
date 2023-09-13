package com.company.jmixpm.screen.task;

import com.company.jmixpm.app.TaskImportService;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("pm_Task.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
public class TaskBrowse extends StandardLookup<Task> {
    @Autowired
    private TaskImportService taskImportService;

    @Autowired
    private CollectionLoader<Task> tasksDl;

    @Autowired
    private Notifications notifications;

    @Subscribe("importBtn")
    public void onImportBtnClick(final Button.ClickEvent event) {
        int size = taskImportService.importTask();
        tasksDl.load();

        notifications.create()
                .withCaption("Tasks imported: " + size)
                .show();
    }
}
package lk.ijse.projectboard.service;

import lk.ijse.projectboard.modal.ProjectTask;
import org.springframework.stereotype.Service;

public interface ProjectTaskService {
    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask);

    public Iterable<ProjectTask> findAll();

    public ProjectTask getById(int id);


    public void deleteProjectTask(int id);
}

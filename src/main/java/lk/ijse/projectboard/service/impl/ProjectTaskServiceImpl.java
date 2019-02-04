package lk.ijse.projectboard.service.impl;

import lk.ijse.projectboard.modal.ProjectTask;
import lk.ijse.projectboard.repository.ProjectTaskRepository;
import lk.ijse.projectboard.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Override
    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {
        if(null == projectTask.getStatus() || "" == projectTask.getStatus()){
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    @Override
    public Iterable<ProjectTask> findAll() {
        return projectTaskRepository.findAll();
    }

    @Override
    public ProjectTask getById(int id) {
        return projectTaskRepository.findById(id).get();
    }

    @Override
    public void deleteProjectTask(int id) {
        ProjectTask projectTask = projectTaskRepository.findById(id).get();
        projectTaskRepository.delete(projectTask);
    }
}

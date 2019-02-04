package lk.ijse.projectboard.repository;

import lk.ijse.projectboard.modal.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Integer> {
}

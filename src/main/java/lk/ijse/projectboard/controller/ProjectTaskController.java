package lk.ijse.projectboard.controller;

import lk.ijse.projectboard.modal.ProjectTask;
import lk.ijse.projectboard.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/board")
@CrossOrigin
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("")
    public ResponseEntity<?> addPTTBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
        if(result.hasErrors()){
            HashMap<String,String> errorMap=new HashMap<>();
            for (FieldError error:result.getFieldErrors()) {
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<HashMap<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
        }
        ProjectTask p=projectTaskService.saveOrUpdateProjectTask(projectTask);
        return new ResponseEntity<ProjectTask>(p,HttpStatus.CREATED);

    }
    @GetMapping("/all")
    public Iterable<ProjectTask> getAllPTs(){
        return projectTaskService.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getProjectByID(@PathVariable int id ){
        ProjectTask p=projectTaskService.getById(id);
        return new ResponseEntity<ProjectTask>(p,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable int id){
        projectTaskService.deleteProjectTask(id);
        return new ResponseEntity<String>("Project Task Has Successfully Deleted",HttpStatus.OK);
    }

}

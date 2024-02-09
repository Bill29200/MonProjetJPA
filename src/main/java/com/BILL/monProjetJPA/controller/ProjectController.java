package com.BILL.monProjetJPA.controller;

import com.BILL.monProjetJPA.model.Project;
import com.BILL.monProjetJPA.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    //...................................................................
    //                              Create
    //...................................................................
    @PostMapping("/add")
    public Project create (@RequestBody Project project) {return projectService.create(project);}
    //...................................................................
    //                              Read
    //...................................................................
    @GetMapping("/all")
    public List<Project> getAll(){return projectService.getAll();}
    @GetMapping("/get/{name}")
    public Project findByName(String name){return projectService.findByName(name);}
    @GetMapping("/count")
    public Long count(){ return projectService.count();}
    //...................................................................
    //                              Update
    //...................................................................
    @PutMapping("/update")
    public  ResponseEntity<Project> update(@RequestBody Project project){
        Project updateProject = projectService.update(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }
    //...................................................................
    //                              Delete
    //...................................................................
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete (@RequestBody Project project){
        projectService.delete(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

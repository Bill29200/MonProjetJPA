package com.BILL.monProjetJPA.service;

import com.BILL.monProjetJPA.model.Project;
import com.BILL.monProjetJPA.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    //...................................................................
    //                              Create
    //...................................................................
    public Project create(Project project){ return projectRepository.save(project);}
    //...................................................................
    //                              Read
    //...................................................................
    public List<Project> getAll() {return projectRepository.findAll();}

    public Project findByName(String name) {return  projectRepository.findByName(name);}

    public Long count() {return projectRepository.count();}
    //...................................................................
    //                              Update
    //...................................................................
    public Project update(Project project) {return projectRepository.save(project);}
    //...................................................................
    //                              Delete
    //...................................................................
    public void delete(Project project) { projectRepository.delete(project);}
}

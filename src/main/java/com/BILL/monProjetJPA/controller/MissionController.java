package com.BILL.monProjetJPA.controller;


import com.BILL.monProjetJPA.model.Employee;
import com.BILL.monProjetJPA.model.Mission;
import com.BILL.monProjetJPA.model.Mission;
import com.BILL.monProjetJPA.service.MissionService;
import com.BILL.monProjetJPA.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;

    //...................................................................
    //                              Create
    //...................................................................
    @PostMapping("/add")
    public Mission create(@RequestBody Mission mission) {
        return missionService.create(mission);
    }
    //...................................................................
    //                              Read
    //...................................................................
    @GetMapping(path = "/all")
    public ResponseEntity<List<Mission>> getAll() {
        List<Mission> missions = missionService.getAll();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    @GetMapping(path ="/get/{name}")
    public Mission getMissionByName(@PathVariable("name") String name) {
        return missionService.findByMissionName(name);

    }

    @GetMapping("/count")
    public Long count() {
        return missionService.count();
    }

    //...................................................................
    //                            Update
    //...................................................................
    @PutMapping("/update")
    public ResponseEntity<Mission> update(@RequestBody Mission mission) {
        Mission updateMission = missionService.update(mission);
        return new ResponseEntity<>(updateMission, HttpStatus.OK);
    }

    //......................................................................
    //                 Delete
    //......................................................................
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Mission mission) {
        missionService.delete(mission);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //......................................................................
}
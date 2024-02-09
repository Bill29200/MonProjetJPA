package com.BILL.monProjetJPA.service;

import com.BILL.monProjetJPA.model.Mission;
import com.BILL.monProjetJPA.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    @Autowired
    private MissionRepository missionRepository;
    //...................................................................
    //                              Create
    //...................................................................
    public Mission create(Mission mission)
    {
        return missionRepository.save(mission);
    }
    //...................................................................
    //                              Read
    //...................................................................
    public List<Mission> getAll()
    {
        return missionRepository.findAll();
    }

    public Mission findByMissionName(String name)
    {
        return missionRepository.findByMissionName(name);
    }

    public Long count()
    {
        return  missionRepository.count();
    }
    //...................................................................
    //                              Update
    //...................................................................
    public Mission update(Mission mission)
    {
        return missionRepository.save(mission);
    }
    //...................................................................
    //                              Delete
    //...................................................................
    public void delete(Mission mission)
    {
        missionRepository.delete(mission);
    }
}

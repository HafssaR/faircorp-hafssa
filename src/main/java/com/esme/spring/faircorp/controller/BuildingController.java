package com.esme.spring.faircorp.controller;


import com.esme.spring.faircorp.model.BuildingDto;
import com.esme.spring.faircorp.model.LightDto;
import com.esme.spring.faircorp.model.RoomDto;
import com.esme.spring.faircorp.repository.BuildingDao;
import com.esme.spring.faircorp.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    @Autowired
    private BuildingDao buildingDao;

    @Autowired
    private RoomDao roomDao;

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public List<RoomDto> findRoomsByBuilding(@PathVariable Long id) {
        return buildingDao.findRoomsByBuilding(id).stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }



}

package com.esme.spring.faircorp.controller;


import com.esme.spring.faircorp.model.Building;
import com.esme.spring.faircorp.model.BuildingDto;
import com.esme.spring.faircorp.model.LightDto;
import com.esme.spring.faircorp.model.RoomDto;
import com.esme.spring.faircorp.repository.BuildingDao;
import com.esme.spring.faircorp.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingDto::new)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public List<RoomDto> findRoomsByBuilding(@PathVariable Long id) {
        return buildingDao.findRoomsByBuilding(id).stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        building.setName(dto.getName());
        buildingDao.save(building);
        return new BuildingDto(building);
    }

}

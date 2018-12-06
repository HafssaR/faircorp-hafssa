package com.esme.spring.faircorp.controller;


import com.esme.spring.faircorp.model.*;
import com.esme.spring.faircorp.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    @Autowired
    private RoomDao roomDao;

    @CrossOrigin
    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping (path = "/{name}")
    public List<LightDto> getRoomState(@PathVariable String name){
        Room room = roomDao.findRoomByName(name).get(0);
        List<Light> roomLights = room.getLightList();
        return roomLights.stream()
                .map(LightDto::new)
                .collect(Collectors.toList());

    }



}

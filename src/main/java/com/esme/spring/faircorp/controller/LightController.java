package com.esme.spring.faircorp.controller;

import com.esme.spring.faircorp.model.Light;
import com.esme.spring.faircorp.model.LightDto;
import com.esme.spring.faircorp.model.Status;
import com.esme.spring.faircorp.repository.LightDao;
import com.esme.spring.faircorp.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lights")
@Transactional
public class LightController {

    @Autowired
    private LightDao lightDao;

    @Autowired
    private RoomDao roomDao;

    @CrossOrigin
    @GetMapping
    public List<LightDto> findAll() {
        return lightDao.findAll()
                .stream()
                .map(LightDto::new)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public LightDto findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDto(light)).orElse(null);
    }

    @CrossOrigin
    @PutMapping(path = "/{id}/switch")
    public LightDto switchStatus(@PathVariable Long id) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setStatus(light.getStatus() == Status.ON ? Status.OFF: Status.ON);
        return new LightDto(light);
    }

    @CrossOrigin
    @PostMapping
    public LightDto create(@RequestBody LightDto dto) {
        Light light = null;
        if (dto.getId() != null) {
            light = lightDao.findById(dto.getId()).orElse(null);
        }

         if (light == null) {
            System.out.println(dto.getLevel());
            System.out.println(dto.getRoomId());
            light = lightDao.save(new Light(roomDao.getOne(dto.getRoomId()), dto.getLevel(), dto.getStatus()));
        } else {
            light.setLevel(dto.getLevel());
            light.setStatus(dto.getStatus());
            lightDao.save(light);
        }

        return new LightDto(light);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }



}

package com.esme.spring.faircorp.repository;

import com.esme.spring.faircorp.model.Building;
import com.esme.spring.faircorp.model.Room;

import java.util.List;

public interface BuildingDaoCustom {
    List<Room> findRoomsByBuilding(Long id_building);
}

package com.esme.spring.faircorp.repository;

import com.esme.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDaoCustom {
    public List<Room> findRoomByName(String name);
}

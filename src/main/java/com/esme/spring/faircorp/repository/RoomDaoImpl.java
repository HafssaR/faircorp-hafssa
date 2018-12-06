package com.esme.spring.faircorp.repository;


import com.esme.spring.faircorp.model.Room;
import com.esme.spring.faircorp.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomByName(String name) {
        String jpql = "select rm from Room rm where rm.name = :roomName";
        return em.createQuery(jpql, Room.class)
                .setParameter("roomName", name)
                .getResultList();
    }
}

package com.esme.spring.faircorp.repository;

import com.esme.spring.faircorp.model.Building;
import com.esme.spring.faircorp.model.Light;
import com.esme.spring.faircorp.model.Room;
import com.esme.spring.faircorp.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoImpl implements BuildingDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomsByBuilding(Long id_building) {
        String jpql = "select r from Room r where r.building.id=:value";
        return em.createQuery(jpql, Room.class)
                .setParameter("value", id_building )
                .getResultList();
    }


}

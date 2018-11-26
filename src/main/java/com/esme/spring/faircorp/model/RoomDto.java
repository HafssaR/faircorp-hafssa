package com.esme.spring.faircorp.model;


public class RoomDto {

    private Long id;
    private String name;
    private Integer floor;
    private Long building_id;


    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.building_id = room.getBuilding().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }

    public Long getBuilding_id() {
        return building_id;
    }
}

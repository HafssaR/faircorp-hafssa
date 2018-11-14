package com.esme.spring.faircorp.model;

import javax.persistence.*;

@Entity
public class Light {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne
    private Room room;

    public Light(Room room, Integer level, Status status) {
        this.level = level;
        this.status = status;
        this.room = room;
    }
    public Light(){

    }
    public Light(Integer level, Status status) {
        this.level = level;
        this.status = status;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }


}

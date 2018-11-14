package com.esme.spring.faircorp.repository;

import com.esme.spring.faircorp.model.Light;

import java.util.List;

public interface LightDaoCustom {
    List<Light> findOnLights();
}

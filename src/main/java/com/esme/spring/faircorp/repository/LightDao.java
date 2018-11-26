package com.esme.spring.faircorp.repository;

import com.esme.spring.faircorp.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LightDao extends JpaRepository<Light, Long>, LightDaoCustom{

}

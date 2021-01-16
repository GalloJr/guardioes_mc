package com.gallo.guardioes_mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallo.guardioes_mc.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
	
}

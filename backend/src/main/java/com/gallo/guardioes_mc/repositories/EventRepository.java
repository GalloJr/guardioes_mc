package com.gallo.guardioes_mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.gallo.guardioes_mc.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT DISTINCT obj FROM Event obj JOIN FETCH obj.members WHERE obj.status = 0 ORDER BY obj.moment ASC")
    List<Event> findEventsWithMembers();
    
    @Query("SELECT e FROM Event e inner JOIN e.members m WHERE m.rank = ?1")
    List<Event> findEventsWithRank(String rank);
    
}

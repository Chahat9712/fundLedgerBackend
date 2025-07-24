package com.hack.hack25.repository;

import com.hack.hack25.model.Participants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participants, String> {

    Participants findByUserId(String userId);
}

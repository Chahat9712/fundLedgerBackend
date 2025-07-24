package com.hack.hack25.repository;

import com.hack.hack25.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, String> {

    Participant findByUserId(String userId);
}

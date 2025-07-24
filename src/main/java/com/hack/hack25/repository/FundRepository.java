package com.hack.hack25.repository;

import com.hack.hack25.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRepository extends JpaRepository<Fund, String> {

    List<Fund> findByFundType(String fundType);
    Fund findByFundName(String fundName);
}

package com.hack.hack25.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participant extends User {

    private double balance;
    private double loanedAmount;

    @ManyToMany(mappedBy = "participants")
    @JsonBackReference(value = "fund-participant")
    private List<Fund> participantFunds = new ArrayList<>();

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "participant-transaction")
    private List<Transaction> transactions = new ArrayList<>();
}

package com.hack.hack25.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundId;
    private String fundName;
    private String fundType;
    private double fundValue;
    private double loanValue;
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true)
    @JsonBackReference
    private Admin admin;
    @ManyToMany
    @JoinTable(
            name = "fund_participants",
            joinColumns = @JoinColumn(name = "fund_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    @JsonManagedReference(value = "fund-participant")
    private List<Participant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "fund", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "fund-transaction")
    private List<Transaction> transactions = new ArrayList<>();
}


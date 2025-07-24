package com.hack.hack25.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private double transactionAmount;
    private Date transactionDate;
    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false)
    @JsonBackReference(value = "participant-transaction")
    private Participant participant;
    @ManyToOne
    @JoinColumn(name = "fund_id", nullable = false)
    @JsonBackReference(value = "fund-transaction")
    private Fund fund;
}

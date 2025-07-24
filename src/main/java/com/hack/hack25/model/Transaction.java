package com.hack.hack25.model;

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
    @JoinColumn(name = "user_id", nullable = false)
    private Participant participants;
    @ManyToOne
    @JoinColumn(name = "fund_id", nullable = false)
    private Fund fund;
}

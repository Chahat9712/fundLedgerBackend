package com.hack.hack25.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FundResponseDTO {

    private String fundName;
    private List<String> participants;
    private String highestContributor;
    private double fundValue;
    private double loanValue;
}

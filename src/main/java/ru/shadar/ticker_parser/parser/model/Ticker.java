package ru.shadar.ticker_parser.parser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Ticker {

    @Id
    @Column(unique = true, nullable = false)
    private String name;
    private String company;
    private String sector;
    private String industry;
}


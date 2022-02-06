package ru.shadar.ticker_parser.parser.dto;

import lombok.Data;

@Data
public class TickerDto {
    private String name;
    private String company;
    private String sector;
    private String industry;
}
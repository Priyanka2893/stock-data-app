package com.stock.stock_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String name;
    private Double price;
    private Double changesPercentage;
    private Double change;
    private Double dayLow;
    private Double dayHigh;
    private Double yearHigh;
    private Double yearLow;
    private Long marketCap;
    private Double priceAvg50;
    private Double priceAvg200;
    private String exchange;
    private Long volume;
    private Long avgVolume;
    private Double open;
    private Double previousClose;
    private Double eps;
    private Double pe;

    private String earningsAnnouncement;
    private Long sharesOutstanding;
    private Long timestamp;
}


package com.stock.stock_demo.controller;

import com.stock.stock_demo.service.StockTestService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "http://localhost:5173")
public class StockTestController {
    private StockTestService service;

    public StockTestController(StockTestService service){
        this.service = service;
    }
    @GetMapping("/{symbol}")
    public String getStockQuote(@PathVariable String symbol){
        return service.getStockQuote(symbol);
    }
}

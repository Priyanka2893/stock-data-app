package com.stock.stock_demo.controller;

import com.stock.stock_demo.entity.Stock;
import com.stock.stock_demo.entity.dto.StockDto;
import com.stock.stock_demo.service.StockTestService;
import com.stock.stock_demo.service.impl.StockServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:5173")
public class StockController {
    private StockTestService service1;
    private StockServiceImpl service;

    public StockController(StockTestService service1,StockServiceImpl service){
        this.service1 = service1;
        this.service = service;
    }
    @GetMapping("/fmp/{symbol}")
    public Stock getStockQuote(@PathVariable String symbol){
        return service.getStockByFMPSymbol(symbol);
    }
    @PostMapping("/{symbol}")
    public Stock saveStock(@PathVariable String symbol){
        return service.saveStock(symbol);
    }
    @GetMapping
    public List<Stock> getListOfStock(){
        return service.getAllStocks();
    }

    @GetMapping("/{symbol}")
    public Stock getStockBySymbol(@PathVariable String symbol){
        return service.getStockBySymbol(symbol);
    }

}

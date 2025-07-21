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

    public StockController(StockTestService service){
        this.service1 = service;
    }
    @GetMapping("/{symbol}")
    public String getStockQuote(@PathVariable String symbol){
        return service1.getStockQuote(symbol);
    }
    @PostMapping()
    public Stock saveStock(@RequestBody StockDto stockDto){
        return service.saveStock(stockDto);
    }
    @GetMapping
    public List<Stock> getListOfStock(){
        return service.getAllStocks();
    }

}

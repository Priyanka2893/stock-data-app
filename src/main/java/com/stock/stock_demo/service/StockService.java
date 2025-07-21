package com.stock.stock_demo.service;

import com.stock.stock_demo.entity.Stock;
import com.stock.stock_demo.entity.dto.StockDto;

import java.util.List;

public interface StockService {
    Stock saveStock(StockDto dto);
    List<Stock> getAllStocks();

}


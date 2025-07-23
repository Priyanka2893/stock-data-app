package com.stock.stock_demo.service;

import com.stock.stock_demo.entity.Stock;
import com.stock.stock_demo.entity.dto.StockDto;

import java.util.List;

public interface StockService {
    Stock saveStock(String symbol);
    List<Stock> getAllStocks();

    Stock getStockBySymbol(String symbol);

    Stock getStockByFMPSymbol(String symbol);
}


package com.stock.stock_demo.service.impl;

import com.stock.stock_demo.entity.Stock;
import com.stock.stock_demo.entity.dto.StockDto;
import com.stock.stock_demo.repository.StockRepository;
import com.stock.stock_demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private ModelMapper mapper;
    private StockRepository repository;

    @Override
    public Stock saveStock(StockDto dto) {
        Stock stock = mapper.map(dto, Stock.class);
        repository.save(stock);
        return stock;
    }

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks = repository.findAll();
        return stocks;
    }
}

package com.stock.stock_demo.service.impl;

import com.stock.stock_demo.entity.Stock;
import com.stock.stock_demo.entity.dto.StockDto;
import com.stock.stock_demo.repository.StockRepository;
import com.stock.stock_demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Value("${api.key}")
    private String apiKey;

    private ModelMapper mapper;

    private StockRepository repository;

    private RestTemplate restTemplate;

    public StockServiceImpl(ModelMapper mapper, StockRepository repository, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Stock saveStock(String symbol) {
        String url = "https://financialmodelingprep.com/api/v3/quote/" + symbol + "?apikey=" + apiKey;

        ResponseEntity<StockDto[]> response = restTemplate.getForEntity(url, StockDto[].class);
        StockDto[] stockDtos = response.getBody();
        System.out.println("Response from api : " + Arrays.toString(response.getBody()));
        if (stockDtos != null && stockDtos.length > 0) {
            Stock stock = mapper.map(stockDtos[0], Stock.class);
            return repository.save(stock);
        } else {
            throw new RuntimeException("No stock data found for symbol: " + symbol);
        }
    }

    @Override
    public Stock getStockByFMPSymbol(String symbol) {
        String url = "https://financialmodelingprep.com/api/v3/quote/" + symbol + "?apikey=" + apiKey;

        ResponseEntity<StockDto[]> response = restTemplate.getForEntity(url, StockDto[].class);
        StockDto[] stockDtos = response.getBody();
        if (stockDtos != null && stockDtos.length > 0) {
            Stock stock = mapper.map(stockDtos[0], Stock.class);
            return stock;
        } else {
            throw new RuntimeException("No stock data found for symbol: " + symbol);
        }
    }
    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks = repository.findAll();
        return stocks;
    }

    @Override
    public Stock getStockBySymbol(String symbol) {
        return repository.findBySymbol(symbol);
    }


}

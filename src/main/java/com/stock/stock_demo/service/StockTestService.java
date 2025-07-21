package com.stock.stock_demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class StockTestService {
    @Value("${api.key}")
    private String apiKey;

    public String getStockQuote(String symbol) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL("https://financialmodelingprep.com/api/v3/quote/" + symbol + "?apikey=" + apiKey);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    response.append(line);
                }
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return response.toString();

    }
}

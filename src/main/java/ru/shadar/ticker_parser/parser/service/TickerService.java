package ru.shadar.ticker_parser.parser.service;

import org.springframework.stereotype.Service;
import ru.shadar.ticker_parser.parser.model.Ticker;

import java.util.List;

@Service
public interface TickerService {
    public void save(Ticker ticker);
    public boolean isExist(String tickerName);
    public List<Ticker> getAllTickers();
}

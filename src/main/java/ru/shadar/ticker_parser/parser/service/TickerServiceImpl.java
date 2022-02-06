package ru.shadar.ticker_parser.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shadar.ticker_parser.parser.model.Ticker;
import ru.shadar.ticker_parser.parser.repository.TickersRepository;

import java.util.List;

@Service
public class TickerServiceImpl implements TickerService {

    @Autowired
    TickersRepository tickersRepository;

    @Override
    public void save(Ticker ticker) {
        tickersRepository.save(ticker);
    }

    @Override
    public boolean isExist(String tickerName) {
        boolean rsl = false;
        List<Ticker> tickers = tickersRepository.findAll();
        for (Ticker ticker : tickers) {
            if (ticker.getName().equals(tickerName)){
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public List<Ticker> getAllTickers() {
        return tickersRepository.findAll();
    }
}

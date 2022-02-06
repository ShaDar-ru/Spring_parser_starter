package ru.shadar.ticker_parser.parser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadar.ticker_parser.parser.model.Ticker;
import ru.shadar.ticker_parser.parser.service.TickerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TickerController {

    @Autowired
    private TickerService tickerService;

    @GetMapping(value = "/tickers")
    public List<Ticker> getAllTickers() {
        return tickerService.getAllTickers();
    }
}

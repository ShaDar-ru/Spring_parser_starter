package ru.shadar.ticker_parser.parser.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.shadar.ticker_parser.parser.model.Ticker;

import java.io.IOException;

@Component
public class ParseTicker {

    @Autowired
    TickerService tickerService;

    @Scheduled(fixedDelay = 600000)
    public void parseNewTicker() {
        String url = "https://finviz.com/screener.ashx?v=111&f=idx_sp500&o=-marketcap";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByClass("table-light");
            Element table = elements.get(0).child(0);
            for (int i = 1; i < table.children().size(); i++) {
                Element row = table.child(i);
                var tickerName = row.getElementsByClass("screener-link-primary")
                        .get(0).ownText().toString();
                if (!tickerService.isExist(tickerName)) {
                    Ticker ticker = Ticker.builder()
                            .name(tickerName)
                            .company(row.getElementsByClass("screener-link").get(1).text())
                            .sector(row.getElementsByClass("screener-link").get(2).text())
                            .industry(row.getElementsByClass("screener-link").get(3).text())
                            .build();
                    System.out.println(ticker.getName());
                    tickerService.save(ticker);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
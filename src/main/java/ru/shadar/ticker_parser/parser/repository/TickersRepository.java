package ru.shadar.ticker_parser.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shadar.ticker_parser.parser.model.Ticker;

@Repository
public interface TickersRepository extends JpaRepository<Ticker, String> {
}

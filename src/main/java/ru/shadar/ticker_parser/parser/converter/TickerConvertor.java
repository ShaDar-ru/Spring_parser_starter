package ru.shadar.ticker_parser.parser.converter;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import ru.shadar.ticker_parser.parser.dto.TickerDto;
import ru.shadar.ticker_parser.parser.model.Ticker;

@Component
public class TickerConvertor {
    private final ModelMapper modelMapper;

    public TickerConvertor() {
        this.modelMapper = new ModelMapper();
    }

    public TickerDto convertToDto(Ticker ticker) {
        return modelMapper.map(ticker, TickerDto.class);
    }
}

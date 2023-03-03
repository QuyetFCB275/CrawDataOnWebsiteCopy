package com.city.of.leander.service.craw;

import com.city.of.leander.model.dto.PokemonProduct;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CrawData {
    Integer getTotalElementPages() throws IOException;

    void crawData() throws IOException, InterruptedException;

}

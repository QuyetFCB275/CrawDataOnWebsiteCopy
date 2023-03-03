package com.craw.data.service.read;

import com.craw.data.model.dto.PokemonProduct;

import java.io.IOException;
import java.util.List;

public interface ReadData {
    public List<PokemonProduct> getPoducts() throws IOException;
}

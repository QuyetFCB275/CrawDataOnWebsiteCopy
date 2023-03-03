package com.craw.data.service.read;

import com.craw.data.model.dto.PokemonProduct;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadDataService implements ReadData{

    @Override
    public List<PokemonProduct> getPoducts() throws IOException {
        List<PokemonProduct> products = new ArrayList<>();
        File file = new File("data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null){
            String[] product = st.split(",");
            PokemonProduct item = PokemonProduct.builder()
                    .name(product[0]).price(product[1])
                    .image(product[2]).url(product[3]).build();
            products.add(item);
        }
        return products;
    }
}

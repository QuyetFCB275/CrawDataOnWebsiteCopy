package com.craw.data.service.craw;

import com.craw.data.model.dto.PokemonProduct;
import com.craw.data.service.connection.ConnectionPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class ThreadCraw implements Runnable{
    private List<PokemonProduct> pokemonProducts;
    private ConnectionPage connection;
    private String urlPage;
    private int index;

    @Override
    public void run() {
        Document connectionPage = null;
        try {
            connectionPage = connection.getConnection(this.urlPage, this.index);
            Elements products = connectionPage.select("li.product");

            products.stream().forEach(product ->{
                PokemonProduct pokemonProduct = PokemonProduct.builder()
                        .url(product.selectFirst("a").attr("href"))
                        .image(product.selectFirst("img").attr("src"))
                        .name(product.selectFirst("h2").text())
                        .price(product.selectFirst("span").text())
                        .build();
                this.pokemonProducts.add(pokemonProduct);
            });

            writeFile(pokemonProducts);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void writeFile(List<PokemonProduct> pokemonProducts){
        File path = new File("data.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("");

            Iterator<PokemonProduct> iterator = pokemonProducts.iterator();

            while (iterator.hasNext()) {
                try {
                    PokemonProduct item = iterator.next();
                    bufferedWriter.write(item.getName() + "," + item.getPrice()  + "," + item.getImage() + "," + item.getUrl());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

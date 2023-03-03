package com.craw.data.service.craw;

import com.craw.data.model.dto.PokemonProduct;
import com.craw.data.service.connection.ConnectionPage;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class CrawDataService implements CrawData {

    private final ConnectionPage connection;

    @Value("${page.url}")
    private String urlPage;

    @Value("${page.url.root}")
    private String urlRoot;


    @Value("${page.total.number}")
    private String elementCssPage;

    @Override
    public Integer getTotalElementPages() throws IOException {
        Elements elements = connection.getConnection(urlRoot).select(elementCssPage);

        return elements.stream().map(CrawDataService::convertToNumber)
                .max(Comparator.comparing(Integer::valueOf)).get();
    }

    private static Integer convertToNumber(Element element){
        try {
            return Integer.parseInt(Jsoup.parse(String.valueOf(element)).body().text());
        }
        catch (Exception e){
            return 0;
        }
    }

    @Override
    public void crawData() throws IOException {
        Integer totalPages = getTotalElementPages();
        List<PokemonProduct> pokemonProducts = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int index = 1; index <= totalPages ; index ++){
            executorService.execute(
                    ThreadCraw.builder().pokemonProducts(pokemonProducts)
                    .connection(connection)
                    .urlPage(urlPage).index(index).build());
        }
        executorService.shutdown();
    }
}

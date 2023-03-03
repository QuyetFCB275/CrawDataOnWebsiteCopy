package com.city.of.leander;

import com.city.of.leander.service.craw.CrawData;
import com.city.of.leander.service.craw.CrawDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class CrawCityOfLeanderApplication {


//    public static void main(String[] args) {
//        SpringApplication.run(CrawCityOfLeanderApplication.class, args);
//
//        Document doc;
//
//        try {
//            // fetching the target website
//            doc = Jsoup.connect("https://scrapeme.live/shop/page/2")
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
//                    .header("Accept-Language", "*")
//                    .get();
//
//            List<PokemonProduct> pokemonProducts = new ArrayList<>();
//
//// retrieving the list of product HTML elements
//            Elements products = doc.select("li.product");
//            Elements paginationElements = doc.select("a.page-numbers");
//// iterating over the list of HTML products
//            for (Element product : products) {
//                PokemonProduct pokemonProduct = new PokemonProduct();
//
//                // extracting the data of interest from the product HTML element
//                // and storing it in pokemonProduct
//                pokemonProduct.setUrl(product.selectFirst("a").attr("href"));
//                pokemonProduct.setImage(product.selectFirst("img").attr("src"));
//                pokemonProduct.setName(product.selectFirst("h2").text());
//                pokemonProduct.setPrice(product.selectFirst("span").text());
//
//                // adding pokemonProduct to the list of the scraped products
//                pokemonProducts.add(pokemonProduct);
//            }
//            pokemonProducts.forEach(s->{
//                System.out.println(s.toString());
//            });
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(CrawCityOfLeanderApplication.class, args);

        CrawDataService crawDataService = (CrawDataService) context.getBean("crawDataService");

        crawDataService.crawData();
    }

//    public static void scrapeProductPage(
//            List<PokemonProduct> pokemonProducts,
//            Set<String> pagesDiscovered,
//            List<String> pagesToScrape
//    ) throws IOException {
//        Document doc = Jsoup
//                .connect("https://scrapeme.live/shop")
//                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
//                .header("Accept-Language", "*")
//                .get();
//
//        // the current web page is about to be scraped and
//        // should no longer be part of the scraping queue
//        String url = pagesToScrape.remove(0);
//
//        pagesDiscovered.add(url);
//
//        // scraping logic omitted for brevity...
//
//        // retrieving the list of product HTML elements
//        Elements products = doc.select("li.product");
//
//        // iterating over the list of HTML products
//        for (Element product : products) {
//            PokemonProduct pokemonProduct = new PokemonProduct();
//
//            // extracting the data of interest from the product HTML element
//            // and storing it in pokemonProduct
//            pokemonProduct.setUrl(product.selectFirst("a").attr("href"));
//            pokemonProduct.setImage(product.selectFirst("img").attr("src"));
//            pokemonProduct.setName(product.selectFirst("h2").text());
//            pokemonProduct.setPrice(product.selectFirst("span").text());
//
//            // adding pokemonProduct to the list of the scraped products
//            pokemonProducts.add(pokemonProduct);
//        }
//        Elements paginationElements = doc.select("a.page-numbers");
//        // iterating over the pagination HTML elements
//        for (Element pageElement : paginationElements) {
//            // the new link discovered
//            String pageUrl = pageElement.attr("href");
//
//            // if the web page discovered is new and should be scraped
//            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
//                pagesToScrape.add(pageUrl);
//            }
//
//            // adding the link just discovered
//            // to the set of pages discovered so far
//            pagesDiscovered.add(pageUrl);
//        }
//    }
}

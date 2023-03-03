package com.craw.data.controller;

import com.craw.data.model.dto.DataDto;
import com.craw.data.model.dto.PokemonProduct;
import com.craw.data.service.craw.CrawData;
import com.craw.data.service.read.ReadData;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CrawController {

    private final CrawData crawData;
    private final ReadData readData;

    @Operation(description = "Access swagger : http://localhost:8081/swagger-ui/index.html")
    @PostMapping("crawls")
    public ResponseEntity<DataDto> crawlingData() throws IOException, InterruptedException {
        crawData.crawData();
        return ResponseEntity.ok(
                DataDto.builder().isSuccess(true).status(HttpStatus.OK.value()).message("Crawl data is successful !")
                .build());
    }

    @GetMapping("crawls")
    public ResponseEntity<List<PokemonProduct>> readData() throws IOException {
        return ResponseEntity.ok(readData.getPoducts());
    }

}

package com.city.of.leander.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PokemonProduct {
    private String url;
    private String image;
    private String name;
    private String price;

    @Override
    public String toString() {
        return "PokemonProduct{" +
                "url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

package org.example.dp.buider;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
public class Article {
    private Long id;

    @Builder.Default
    private String title = "Title Placeholder";

    @Singular
    private List<String> tags;
}
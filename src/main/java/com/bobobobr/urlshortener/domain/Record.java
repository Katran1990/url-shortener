package com.bobobobr.urlshortener.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(indexName = "url")
public class Record {

    @Id
    private String id;
    private String url;
}

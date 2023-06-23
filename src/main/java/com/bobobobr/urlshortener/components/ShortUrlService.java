package com.bobobobr.urlshortener.components;

import com.bobobobr.urlshortener.domain.Record;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShortUrlService {

    private static String URL = "http://bobobo.br:8080/";
    private final UrlRepository repository;

    public String shortenUrl(String url) {
        int count = 0;
        var id = RandomStringUtils.randomAlphanumeric(8);
        while (repository.existsById(id) && ++count <= 5) id = RandomStringUtils.randomAlphanumeric(8);
        repository.save(new Record(id, url));
        return URL + id;
    }

    @Cacheable("url")
    public String findUrlByKey(String key) {
        return repository.findById(key)
                .map(Record::getUrl)
                .orElseThrow(() -> new IllegalArgumentException("Url wasn't found"));
    }
}

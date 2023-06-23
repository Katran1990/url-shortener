package com.bobobobr.urlshortener.components;

import com.bobobobr.urlshortener.domain.Record;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends ElasticsearchRepository<Record, String> {
}

package com.keya.artisanback.exposition;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SubscriberEntityRepository extends ElasticsearchRepository<SubscriberEntity,Long> {
}

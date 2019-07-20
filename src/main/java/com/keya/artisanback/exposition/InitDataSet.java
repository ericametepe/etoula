package com.keya.artisanback.exposition;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Slf4j
public class InitDataSet {


    private static final String INDEX_NAME = "artisan";
    private static final String INDEX_TYPE = "subscriber";

    @Autowired
    SubscriberEntityRepository repository;
    @Autowired
    ElasticsearchTemplate template;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            bulk(i);
        }
    }

    public void bulk(int k) {
        try {
            if (!template.indexExists(INDEX_NAME)) {
                template.createIndex(INDEX_NAME);
            }
            ObjectMapper mapper = new ObjectMapper();
            List<IndexQuery> queries = new ArrayList<>();
            List<SubscriberEntity> subscriberEntities = createSubscriberEntities();
            for (SubscriberEntity employee : subscriberEntities) {
                IndexQuery indexQuery = new IndexQuery();
                indexQuery.setId(employee.getId().toString());
                indexQuery.setSource(mapper.writeValueAsString(employee));
                indexQuery.setIndexName(INDEX_NAME);
                indexQuery.setType(INDEX_TYPE);
                queries.add(indexQuery);
            }
            if (queries.size() > 0) {
                template.bulkIndex(queries);
            }
            template.refresh(INDEX_NAME);
            log.info("BulkIndex completed: {}", k);
        } catch (Exception e) {
            log.error("Error bulk index", e);
        }
    }

    private List<SubscriberEntity> createSubscriberEntities() {
        List<SubscriberEntity> subscriberEntities = new ArrayList<>();
        int id = (int) repository.count();
        for (int i = id; i < 100 + id; i++) {
            Random r = new Random();
            SubscriberEntity subscriber =SubscriberEntity.builder()
                    .id(Long.valueOf(i))
                    .email("erictepe".concat(String.valueOf(i).concat("@yahoo.fr")))
                    .phone("070608".concat(String.valueOf(i)))
                    .role(RoleEnum.JOBBER.name())
                    .build();
            subscriberEntities.add(subscriber);
        }
        return subscriberEntities;
    }

}

package com.keya.artisanback.exposition;

import java.util.List;

public interface SubscriberRepository {
    Subscriber save(Subscriber subscriber);

    List<SubscriberEntity> findAll();
}

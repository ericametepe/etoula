package com.keya.artisanback.exposition;

import java.util.List;

public interface SubscriptionManager {
    Subscriber create(Subscriber suscriber);

    List<Subscriber> findAll();

}

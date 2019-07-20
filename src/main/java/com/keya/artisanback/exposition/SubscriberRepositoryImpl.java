package com.keya.artisanback.exposition;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class SubscriberRepositoryImpl implements SubscriberRepository {
    private final SubscriberEntityRepository subscriberEntityRepository;

    @Override
    public Subscriber save(Subscriber subscriber) {
        ModelMapper modelMapper = new ModelMapper();
        SubscriberEntity subscriberEntity = modelMapper.map(subscriber,SubscriberEntity.class);
        SubscriberEntity entity=  subscriberEntityRepository.save(subscriberEntity);
       return modelMapper.map(entity,Subscriber.class);
    }

    @Override
    public List<SubscriberEntity> findAll() {
        return Lists.newArrayList(subscriberEntityRepository.findAll());
    }
}

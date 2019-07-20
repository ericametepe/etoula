package com.keya.artisanback.exposition;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubscriptionManagerImpl implements SubscriptionManager{

    private final SubscriberRepository subscriberRepository;

    @Override
    public Subscriber create(Subscriber suscriber) {
        return subscriberRepository.save(suscriber);
    }

    @Override
    public List<Subscriber> findAll() {
        List<SubscriberEntity> subscriberEntities = subscriberRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
       List<Subscriber> subscribers = subscriberEntities.stream().map(subscriberEntity -> modelMapper.map(subscriberEntity,Subscriber.class)).collect(Collectors.toList());
        return subscribers;
    }
}

package com.keya.artisanback.exposition;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class SubscriptionResource {
    private final SubscriptionManager subscriptionManager;

    @PostMapping(value="/subscribe")
    public ResponseEntity<?> create(@RequestBody SubscriberRequestDTO subscriberRequestDTO){
        ModelMapper modelMapper = new ModelMapper();
        Subscriber suscriber = modelMapper.map(subscriberRequestDTO,Subscriber.class);
        Subscriber subscriber= subscriptionManager.create(suscriber);
        SubscriberDTO subscriberResponseDTO = modelMapper.map(subscriber,SubscriberDTO.class);
        return new ResponseEntity<>(subscriberResponseDTO, HttpStatus.CREATED);

    }

    @GetMapping(value="/subscribers")
    public ResponseEntity<List<SubscriberDTO>> getAll(){
       List<Subscriber> subscribers = subscriptionManager.findAll();
       ModelMapper modelMapper = new ModelMapper();
       List<SubscriberDTO> subscriberDTOS =subscribers.stream().map(subscriber -> modelMapper.map(subscriber,SubscriberDTO.class)).collect(Collectors.toList());
        return  new ResponseEntity<>(subscriberDTOS,HttpStatus.OK);
    }

}

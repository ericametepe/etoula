package com.keya.artisanback.exposition;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SubscriberResponseDTO {
    private SubscriberRequestDTO subscriberRequestDTO;
    private String message;

}

package com.keya.artisanback.exposition;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Document(indexName = "subscriber")
public class SubscriberEntity {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String password;
    @Field(type = FieldType.Text)
    private String email;
    @Field(type = FieldType.Text)
    private String phone;
    @Field(type = FieldType.Text)
    private String role;
    @Field(type = FieldType.Date)
    private LocalDateTime subscriptionDate;

}

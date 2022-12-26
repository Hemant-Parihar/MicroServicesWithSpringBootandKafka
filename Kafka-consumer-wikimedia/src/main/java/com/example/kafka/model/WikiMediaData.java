package com.example.kafka.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WikiMediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}

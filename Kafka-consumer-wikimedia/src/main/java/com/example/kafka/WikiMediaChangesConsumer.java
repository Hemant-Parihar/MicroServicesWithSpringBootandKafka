package com.example.kafka;

import com.example.kafka.model.WikiMediaData;
import com.example.kafka.repo.WikiMediaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaChangesConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesConsumer.class);

    @Autowired
    private WikiMediaRepo wikiMediaRepo;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> %s", message));
        WikiMediaData wikiMediaData = new WikiMediaData();
        wikiMediaData.setWikiEventData(message);
        wikiMediaRepo.save(wikiMediaData);
    }

}

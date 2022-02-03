package dev.gokhana.sse.service;

import dev.gokhana.sse.model.LiveScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

@Service
public class CampaignProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignProcessor.class);

    private final List<Consumer<LiveScore>> listeners = new CopyOnWriteArrayList<>();

    public void consumer(Consumer<LiveScore> listener) {
        listeners.add(listener);
        LOGGER.info("New one added, total consumer: {}", listeners.size());
    }

    public void process(LiveScore liveScore) {
        LOGGER.info("Processing live score: {}", liveScore);
        listeners.forEach(listener -> listener.accept(liveScore));
    }
}

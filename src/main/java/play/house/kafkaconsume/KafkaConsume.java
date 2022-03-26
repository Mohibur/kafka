package play.house.kafkaconsume;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class KafkaConsume {
  Gson gson = new Gson();
  @KafkaListener(topics = "quickstart-events", groupId = "kafka-consumer-group")
  public void listenWithHeaders(@Payload String payload) {
    Greeting g = gson.fromJson(payload, Greeting.class);
    System.out.println("Received Message: " + g.name);
  }
}

package com.akkademy;

import java.util.HashMap;
import java.util.Map;

import com.akkademy.messages.GetRequest;
import com.akkademy.messages.KeyNotFoundException;
import com.akkademy.messages.SetRequest;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class AkkademyDb extends AbstractActor {

	protected final LoggingAdapter log = Logging.getLogger(context().system(), this);

	protected final Map<String, Object> map = new HashMap<>();

	private AkkademyDb() {
		receive(ReceiveBuilder
				.match(SetRequest.class, message -> {
					log.info("Received Set request: {}", message);
					map.put(message.getKey(), message.getValue());
					sender().tell(new Status.Success(message.getKey()), self());
				})
				.match(GetRequest.class, message -> {
					log.info("Received Get request: {}", message);
					String value = (String)map.get(message.key);
					Object response = (value != null) ? value : new Status.Failure(new KeyNotFoundException(message.key));
					sender().tell(response, self());
				})
				.matchAny(o -> sender().tell(new Status.Failure(new ClassNotFoundException()), self())).build());
	}
}

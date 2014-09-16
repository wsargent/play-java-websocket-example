package actors;


import akka.actor.ActorRef;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import backend.StockSentimentActor;

public class ActorManagerExtensionImpl implements Extension {

    private final ActorRef stockManagerClient;
    private final ActorRef stockSentimentActor;

    public ActorManagerExtensionImpl(ExtendedActorSystem system) {
        stockManagerClient = system.actorOf(StockManagerClient.props(), "stockManagerClient");
        stockSentimentActor = system.actorOf(StockSentimentActor.props(), "stockSentimentActor");
    }

    public ActorRef getStockManagerClient() {
        return stockManagerClient;
    }

    public ActorRef getStockSentimentActor() {
        return stockSentimentActor;
    }
}

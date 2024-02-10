import java.util.*;

public class Market implements MarketBehavior, QueueBehavior {
    private List<Actor> queue = new ArrayList<>();
    private List<Actor> readyToLeaveQueue = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println("Добро пожаловать в наш магазин!");
        queue.add(actor);
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actorList) {
        for (Actor actor : actorList) {
            queue.remove(actor);
        }
        System.out.println("Всего доброго!");
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();

    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
        System.out.println(actor.getName() + " теперь в очереди");
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakerOrder(true);
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
            }
        }
    }

    @Override
    public void releaseFromQueue(){
        for (Actor actor : queue) {
        if (actor.isTakeOrder() && !readyToLeaveQueue.contains(actor)) {
            readyToLeaveQueue.add(actor);
            System.out.println(actor.getName() + " покидает очередь"); }
    }
        queue.removeAll(readyToLeaveQueue);
        readyToLeaveQueue.clear();
    }
}
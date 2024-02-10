public interface ActorBehaviour {
    void setMakerOrder(boolean makerOrder);
    void setTakeOrder(boolean takeOrder);
    boolean isMakeOrder();
    boolean isTakeOrder();
}

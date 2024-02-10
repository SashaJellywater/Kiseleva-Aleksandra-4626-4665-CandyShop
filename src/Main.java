import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Human visitor1 = new Human("Lola");
        Human visitor2 = new Human("Tom");
        List<Actor>visitors = new ArrayList<>();
        visitors.add(visitor1);
        visitors.add(visitor2);


        market.acceptToMarket(visitor1);
        market.acceptToMarket(visitor2);
        market.update();
        market.releaseFromMarket(visitors);
    }
}
package beverages_decorator;

public class ExtraShot extends BeverageDecorator {
    
    public ExtraShot(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 12;
    }
}

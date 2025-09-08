package beverages_decorator;

public class VanillaSyrup extends BeverageDecorator {
    
    public VanillaSyrup(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 6;
    }
}

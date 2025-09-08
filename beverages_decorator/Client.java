package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		
		Beverage cappuccino = new Cappuccino();
		System.out.println("Cappuccino cost: " + cappuccino.cost());
		
		Beverage latte = new Latte();
		System.out.println("Latte cost: " + latte.cost());
		
		Beverage cappuccinoWithMilk = new Milk(new Cappuccino());
		System.out.println("Cappuccino with Milk cost: " + cappuccinoWithMilk.cost());
		
		Beverage fancyLatte = new WhippedCream(new Sugar(new Latte()));
		System.out.println("Latte with Sugar and Whipped Cream cost: " + fancyLatte.cost());
		
		Beverage deluxeCappuccino = new ExtraShot(
			new VanillaSyrup(
				new WhippedCream(
					new Milk(
						new Sugar(new Cappuccino())
					)
				)
			)
		);
		System.out.println("Deluxe Cappuccino (Sugar + Milk + Whipped Cream + Vanilla Syrup + Extra Shot) cost: " + deluxeCappuccino.cost());
		
		Beverage premiumLatte = new WhippedCream(
			new ExtraShot(
				new VanillaSyrup(
					new Milk(new Latte())
				)
			)
		);
		System.out.println("Premium Latte (Milk + Vanilla Syrup + Extra Shot + Whipped Cream) cost: " + premiumLatte.cost());
		
		Beverage base = new Cappuccino();
		System.out.println("Base Cappuccino: " + base.cost());
		
		base = new Sugar(base);
		System.out.println("+ Sugar: " + base.cost());
		
		base = new Milk(base);
		System.out.println("+ Milk: " + base.cost());
		
		base = new WhippedCream(base);
		System.out.println("+ Whipped Cream: " + base.cost());
		
		base = new VanillaSyrup(base);
		System.out.println("+ Vanilla Syrup: " + base.cost());
		
		base = new ExtraShot(base);
		System.out.println("+ Extra Shot: " + base.cost());
	}

}
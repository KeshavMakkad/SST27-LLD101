package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        base.move();
        base.attack();
        System.out.println("Stats: Speed=" + base.getSpeed() + ", Damage=" + base.getDamage() + ", Sprite=" + base.getSprite());

        Character speedBoosted = new SpeedBoost(base, 3);
        speedBoosted.move();
        speedBoosted.attack();
        System.out.println("Stats: Speed=" + speedBoosted.getSpeed() + ", Damage=" + speedBoosted.getDamage() + ", Sprite=" + speedBoosted.getSprite());

        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();
        System.out.println("Stats: Speed=" + buffed.getSpeed() + ", Damage=" + buffed.getDamage() + ", Sprite=" + buffed.getSprite());

        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();
        System.out.println("Stats: Speed=" + shiny.getSpeed() + ", Damage=" + shiny.getDamage() + ", Sprite=" + shiny.getSprite());

        Character withoutAura = buffed;
        withoutAura.move();
        withoutAura.attack();
        System.out.println("Stats: Speed=" + withoutAura.getSpeed() + ", Damage=" + withoutAura.getDamage() + ", Sprite=" + withoutAura.getSprite());

        Character complex = new SpeedBoost(
            new GoldenAura(
                new DamageBoost(base, 20)
            ), 
            5
        );
        complex.move();
        complex.attack();
        System.out.println("Stats: Speed=" + complex.getSpeed() + ", Damage=" + complex.getDamage() + ", Sprite=" + complex.getSprite());
    }
}

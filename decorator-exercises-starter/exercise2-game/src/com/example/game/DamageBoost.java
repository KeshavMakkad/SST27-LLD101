package com.example.game;
public class DamageBoost implements Character {
    private final Character wrappedCharacter;
    private final int damageIncrease;

    public DamageBoost(Character character, int damageIncrease) {
        this.wrappedCharacter = character;
        this.damageIncrease = damageIncrease;
    }

    @Override
    public void move() {
        wrappedCharacter.move();
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " [DAMAGE BOOSTED]");
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed();
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage() + damageIncrease;
    }

    @Override
    public String getSprite() {
        return wrappedCharacter.getSprite();
    }
}

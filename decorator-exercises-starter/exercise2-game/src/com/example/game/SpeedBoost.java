package com.example.game;

public class SpeedBoost implements Character {
    private final Character wrappedCharacter;
    private final int speedIncrease;

    public SpeedBoost(Character character, int speedIncrease) {
        this.wrappedCharacter = character;
        this.speedIncrease = speedIncrease;
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite() + " [SPEED BOOSTED]");
    }

    @Override
    public void attack() {
        wrappedCharacter.attack();
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed() + speedIncrease;
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage();
    }

    @Override
    public String getSprite() {
        return wrappedCharacter.getSprite();
    }
}

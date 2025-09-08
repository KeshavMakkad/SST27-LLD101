package com.example.game;

public class GoldenAura implements Character {
    private final Character wrappedCharacter;
    private final int speedBonus = 2;
    private final int damageBonus = 5;

    public GoldenAura(Character character) {
        this.wrappedCharacter = character;
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite() + " [GOLDEN AURA GLOWING] ✨");
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " [GOLDEN AURA STRIKES] ⚡");
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed() + speedBonus;
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage() + damageBonus;
    }

    @Override
    public String getSprite() {
        return "golden_" + wrappedCharacter.getSprite();
    }
}

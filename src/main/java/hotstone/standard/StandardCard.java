package hotstone.standard;

import hotstone.framework.*;

public class StandardCard implements MutableCard {

    private Player owner;
    private final String name;
    private int mana;
    private int attack;
    private int health;
    private boolean isActive = false;

    private void init(int mana, int attack, int health) {
        this.mana = mana;
        this.attack = attack;
        this.health = health;
    }

    public StandardCard(String name) {
        this.owner = null;
        this.name = name;
        switch (name) {
            case GameConstants.UNO_CARD ->
               init(1,1,1);
            case GameConstants.DOS_CARD ->
                init(2,2,2);
            case GameConstants.TRES_CARD ->
                init(3,3,3);
            case GameConstants.CUATRO_CARD ->
                init(2,3,1);
            case GameConstants.CINCO_CARD ->
                init(3,5,1);
            case GameConstants.SEIS_CARD ->
                init(2,1,3);
            case GameConstants.SIETE_CARD ->
                init(3,2,4);
            case GameConstants.SOVS_CARD ->
                init(0,1,1);
            case GameConstants.BROWN_RICE_CARD ->
                init(1,1,2);
            case GameConstants.FRENCH_FRIES_CARD ->
                init(1,2,1);
            case GameConstants.GREEN_SALAD_CARD ->
                init(2,2,3);
            case GameConstants.TOMATO_SALAD_CARD ->
                init(2,3,2);
            case GameConstants.POKE_BOWL_CARD ->
                init(3,2,4);
            case GameConstants.PUMPKIN_SOUP_CARD ->
                init(4,2,7);
            case GameConstants.NOODLE_SOUP_CARD ->
                init(4,5,3);
            case GameConstants.SPRING_ROLLS_CARD ->
                init(5,3,7);
            case GameConstants.BAKED_SALMON_CARD ->
                init(5,8,2);
            default ->
                throw(new IllegalArgumentException("Name not recognized."));
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getManaCost() {
        return mana;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {this.attack = attack;}

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public String getEffectDescription() {
        return "";
    }

    public void setActive(boolean b) {
        isActive = b;
    }

    public void hurt(int amount) {
        health -= amount;
    }

}

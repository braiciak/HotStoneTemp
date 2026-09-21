package hotstone.framework;

public interface PowerStrategy {
    void usePower(Game game);
    String getName();
    String getDescription();
    int getPowerCost();
}

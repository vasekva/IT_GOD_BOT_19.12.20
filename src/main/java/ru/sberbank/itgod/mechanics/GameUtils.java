package ru.sberbank.itgod.mechanics;

import ru.sberbank.itgod.mechanics.params.GameParameters;
import ru.sberbank.itgod.mechanics.params.MapSettings;
import ru.sberbank.itgod.mechanics.state.GameState;

public class GameUtils {

    public static void checkForNullReferences(final GameParameters p) {
        if (p == null)
            throw new IllegalArgumentException("Null reference in GameParameters");
        if (p.getTowers() == null)
            throw new IllegalArgumentException("Null reference in Towers");
        if (p.getForges() == null)
            throw new IllegalArgumentException("Null reference in Forges");
        if (p.getCreeps() == null)
            throw new IllegalArgumentException("Null reference in Creeps");
    }

    public static void checkForNullReferences(final GameState g) {
        if (g == null)
            throw new IllegalArgumentException("Null reference in GameState");
        if (g.getBuildingStates() == null || g.getBuildingStates().contains(null))
            throw new IllegalArgumentException("Null reference in buildingStates");
        if (g.getSquadStates() == null || g.getSquadStates().contains(null))
            throw new IllegalArgumentException("Null reference in squadStates");
    }

    public static void checkForNullReferences(final MapSettings s) {
        if (s == null)
            throw new IllegalArgumentException("Null reference in MapSettings");
        if (s.getMapUnity() == null || s.getMapUnity().getPositions() == null)
            throw new IllegalArgumentException("Null reference in MapUnity");
        if (s.getPlayerColors() == null)
            throw new IllegalArgumentException("Null reference in Teams");
        if (s.getTowers() == null || s.getTowers().values().contains(null))
            throw new IllegalArgumentException("Null reference in Towers");
        if (s.getForges() == null || s.getForges().values().contains(null))
            throw new IllegalArgumentException("Null reference in Forges");
        if (s.getLinks() == null)
            throw new IllegalArgumentException("Null reference in Link");
    }
}

package ru.sberbank.itgod.bot.heroes;

import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.HeroType;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.mechanics.Vector3;
import ru.sberbank.itgod.mechanics.actions.BuffAction;

public class Warrior extends Hero {
    public Warrior(final PlayerColor playerColor, final Team team) {
        super(playerColor, team, HeroType.WARRIOR);
    }

    /**
     * Берсерк. Усиливает движущиеся войска в заданной области
     *
     * @param location - координаты x, y
     */
    public void berserk(final Vector3 location) {
        final BuffAction action = new BuffAction(getPlayerColor(), location.getX(), location.getY(), Abilities.BERSERK);
        asyncSender.put(action);
    }

    /**
     * Рык. Распугивает соперника в башне. При применении войска соперника разбегаются по другим своим башням.
     * Если других башен нет, останутся сидеть в этой
     *
     * @param enemyTowerId - идентификатор целевой башни противника
     */
    public void growl(final int enemyTowerId) {
        final BuffAction action = new BuffAction(getPlayerColor(), enemyTowerId, Abilities.GROWL);
        asyncSender.put(action);
    }
}

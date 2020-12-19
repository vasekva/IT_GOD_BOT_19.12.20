package ru.sberbank.itgod.bot.heroes;

import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.HeroType;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.mechanics.Vector3;
import ru.sberbank.itgod.mechanics.actions.BuffAction;

public class BlackSmith extends Hero {
    public BlackSmith(PlayerColor playerColor, Team team) {
        super(playerColor, team, HeroType.BLACKSMITH);
    }

    /**
     * Урон по площади. Не действует на берсерков. Начинает дейстовать через секунду.
     *
     * @param location - координаты x, y
     */
    public void areaDamage(final Vector3 location) {
        final BuffAction action = new BuffAction(getPlayerColor(), location.getX(), location.getY(), Abilities.AREA_DAMAGE);
        asyncSender.put(action);
    }

    /**
     * Защита своей башни (или союзника)
     *
     * @param myTowerId - идентификатор целевой башни
     */
    public void armor(final int myTowerId) {
        final BuffAction action = new BuffAction(getPlayerColor(), myTowerId, Abilities.ARMOR);
        asyncSender.put(action);
    }
}

package ru.sberbank.itgod.bot.heroes;

import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.HeroType;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.mechanics.actions.BuffAction;

public class Mage extends Hero {

    public Mage(PlayerColor playerColor, Team team) {
        super(playerColor, team, HeroType.MAGE);
    }

    /**
     * Чума. Применяется на башню противника и убивает в нем войска
     *
     * @param enemyTargetId - идентификатор целевой башни противника
     */
    public void plague(final int enemyTargetId) {
        final BuffAction action = new BuffAction(getPlayerColor(), enemyTargetId, Abilities.PLAGUE);
        asyncSender.put(action);
    }

    /**
     * Обмен. Меняет башни местами и усредняет количество войск
     *
     * @param enemyTowerId - идентификатор целевой башни противника
     * @param myTowerId    - идентификатор вашей башни
     */
    public void exchange(final int myTowerId, final int enemyTowerId) {
        final BuffAction action = new BuffAction(getPlayerColor(), myTowerId, enemyTowerId, Abilities.BUILD_EXCHANGE);
        asyncSender.put(action);
    }
}

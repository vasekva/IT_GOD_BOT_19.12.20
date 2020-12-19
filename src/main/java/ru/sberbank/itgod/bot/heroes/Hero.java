package ru.sberbank.itgod.bot.heroes;

import lombok.Data;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.HeroType;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.mechanics.Vector3;
import ru.sberbank.itgod.mechanics.actions.BuffAction;
import ru.sberbank.itgod.mechanics.actions.MoveAction;
import ru.sberbank.itgod.mechanics.actions.TowerAction;
import ru.sberbank.itgod.websocket.AsyncSender;

@Data
public abstract class Hero {

    AsyncSender asyncSender = AsyncSender.getInstance();

    private PlayerColor playerColor;
    private Team team;
    private final HeroType heroType;

    public Hero(final PlayerColor playerColor, final Team team, final HeroType heroType) {
        this.playerColor = playerColor;
        this.team = team;
        this.heroType = heroType;
    }

    /**
     * Передвижение войск
     *
     * @param sourceTowerId - идентификатор исходной башни
     * @param targetTowerId - идентификатор целевой башни
     * @param part          - направляемая часть войск [0,1]
     */
    public void move(final int sourceTowerId, final int targetTowerId, final float part) {
        final MoveAction action = new MoveAction(playerColor, sourceTowerId, targetTowerId, part);
        asyncSender.put(action);
    }

    public void boost(final Vector3 location) {
        final BuffAction action = new BuffAction(playerColor, location.getX(), location.getY(), Abilities.SPEED_UP);
        asyncSender.put(action);
    }

    public void upgradeTower(final int towerId) {
        final TowerAction action = new TowerAction(playerColor, towerId);
        asyncSender.put(action);
    }
}

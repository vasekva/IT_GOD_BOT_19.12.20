package ru.sberbank.itgod.bot;

import lombok.extern.slf4j.Slf4j;
import ru.sberbank.itgod.bot.api.BotApi;
import ru.sberbank.itgod.bot.heroes.BlackSmith;
import ru.sberbank.itgod.bot.heroes.Mage;
import ru.sberbank.itgod.bot.heroes.Warrior;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.exceptions.IntegrationException;
import ru.sberbank.itgod.mechanics.Vector3;
import ru.sberbank.itgod.mechanics.state.BuildingState;
import ru.sberbank.itgod.mechanics.state.GameState;
import ru.sberbank.itgod.mechanics.state.SquadState;
import ru.sberbank.itgod.mechanics.state.UnitState;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ru.sberbank.itgod.enums.HeroType.*;


@Slf4j
public class Bot {

    /**
     * Основной класс для стратегии бота.
     * Внутри одного цикла (1 игровой тик, 100мс) серверу может быть отправлено не больше 30 сообщений! (Защита от бесконечных циклов)
     */
    public void play(final BotApi game) throws IntegrationException {
        while (true) {
            final PlayerColor myColor = game.getHero().getPlayerColor();
            final GameState gameState = game.getGameState();

            final List<BuildingState> myBuildings = game.getBuildings(gameState, myColor);
            final List<BuildingState> enemyBuildings = game.getEnemyBuildings(gameState, myColor);

            final List<SquadState> mySquads = game.getSquads(gameState, myColor);
            final List<SquadState> enemySquads = game.getEnemySquads(gameState, myColor);

            final List<SquadState> myMovingSquads = game.getMovingSquads(mySquads);
            final List<SquadState> enemyMovingSquads = game.getMovingSquads(enemySquads);

            final List<Abilities> abilitiesOnCooldown = game.getAbilitiesOnCooldown(gameState, myColor);

            switch (game.getHero().getHeroType()) {
                case WARRIOR:
                    playWarrior(abilitiesOnCooldown, myMovingSquads, game, enemyBuildings);
                    break;
                case BLACKSMITH:
                    playBlacksmith(abilitiesOnCooldown, myBuildings, game, enemyMovingSquads);
                    break;
                case MAGE:
                    playMage(abilitiesOnCooldown, myBuildings, game, enemyBuildings);
                    break;
            }

            for (final BuildingState botBuildingState : game.getBuildings(gameState, game.getHero().getPlayerColor())) {
                for (final BuildingState enemyBuildingState : enemyBuildings) {
                    if (botBuildingState.getCreepsCount() > enemyBuildingState.getCreepsCount() * game.getParameters().getDefaultDefenseParameter() + 7) {
                        game.getHero().move(botBuildingState.getId(), enemyBuildingState.getId(), 1);
                        break;
                    }
                }
            }

            if (!abilitiesOnCooldown.contains(Abilities.SPEED_UP)) {
                for (final SquadState squad : myMovingSquads) {
                    final Vector3 position = game.getSquadPosition(squad);
                    game.getHero().boost(position);
                    break;
                }
            }
        }
    }

    private void playWarrior(final List<Abilities> abilitiesOnCooldown, final List<SquadState> myMovingSquads,
                             final BotApi game, final List<BuildingState> enemyBuildings) {
        if (!abilitiesOnCooldown.contains(Abilities.BERSERK)) {
            for (final SquadState squad : myMovingSquads) {
                final Vector3 position = game.getSquadPosition(squad);
                ((Warrior) game.getHero()).berserk(position);
                break;
            }
        }

		if (!abilitiesOnCooldown.contains(Abilities.GROWL)) {
			enemyBuildings.stream()
					.filter(x -> x.getPlayerColor() != PlayerColor.WHITE)
					.max(Comparator.comparingInt(BuildingState::getCreepsCount))
					.ifPresent(growlTower -> ((Warrior) game.getHero()).growl(growlTower.getId()));
		}
	}

    private void playMage(final List<Abilities> abilitiesOnCooldown, final List<BuildingState> myBuildings,
                          final BotApi game, final List<BuildingState> enemyBuildings) {
        if (abilitiesOnCooldown.contains(Abilities.BUILD_EXCHANGE) && abilitiesOnCooldown.contains(Abilities.PLAGUE))
            return;

        final List<BuildingState> otherPlayersBuildings = enemyBuildings.stream()
                .filter(x -> x.getPlayerColor() != PlayerColor.WHITE).collect(Collectors.toList());

        if (!abilitiesOnCooldown.contains(Abilities.BUILD_EXCHANGE)) {
            myBuildings.sort(Comparator.comparingInt(BuildingState::getCreepsCount));
            final BuildingState myTower = myBuildings.get(0);

            otherPlayersBuildings.sort(Comparator.comparingInt(BuildingState::getCreepsCount));
            final BuildingState enemyTower = otherPlayersBuildings.get(otherPlayersBuildings.size() - 1); //TODO сделать настройку рокировки

            ((Mage) game.getHero()).exchange(myTower.getId(), enemyTower.getId());
            log.info("HERE {} {}", myTower.getId(), enemyTower.getId());
        }

		if (!abilitiesOnCooldown.contains(Abilities.PLAGUE)) {
			otherPlayersBuildings.stream()
					.max(Comparator.comparingInt(BuildingState::getCreepsCount))
					.ifPresent(plagueTower -> ((Mage) game.getHero()).plague(plagueTower.getId()));
		}
	}

    private void playBlacksmith(final List<Abilities> abilitiesOnCooldown, final List<BuildingState> myBuildings,
                                final BotApi game, final List<SquadState> enemyMovingSquads) {
        if (!abilitiesOnCooldown.contains(Abilities.AREA_DAMAGE)) {
            for (final SquadState squad : enemyMovingSquads) {
                final Vector3 position = game.getSquadPosition(squad);
                ((BlackSmith) game.getHero()).areaDamage(position);
            }
        }
        if (!abilitiesOnCooldown.contains(Abilities.ARMOR)) {
            for (final BuildingState building : myBuildings)
                ((BlackSmith) game.getHero()).armor(building.getId()); //TODO доработать защиту башень
        }
    }
}

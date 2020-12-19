package ru.sberbank.itgod.mechanics;

import ru.sberbank.itgod.mechanics.state.SquadState;

import java.util.List;

public class MapUtility {

    public static Vector3 getSquadCenterPosition(final SquadState squad, final LinksStorage linksStorage) {
        final Integer fromId = squad.getFromId();
        final Integer toId = squad.getToId();
        final Double partOfPath = squad.getWay().getTraveled() / squad.getWay().getTotal();

        final List<Vector3> pos = linksStorage.getFromStorage(fromId, toId);
        final Double absolutePart = linksStorage.getDistance(fromId, toId) * partOfPath;

        Double distance = 0d;

        if (fromId < toId) {
            for (int i = 0; i < pos.size() - 1; i++) {
                final Vector3 first = pos.get(i);
                final Vector3 second = pos.get(i + 1);
                first.setZ(0d);
                second.setZ(0d);
                final Double localDistance = Vector3.distance(first, second);
                distance += localDistance;
                if (distance >= absolutePart) {
                    final double localAbsPath = absolutePart - distance + localDistance;
                    final double localPart = localAbsPath / localDistance;
                    return Vector3.lerp(first, second, localPart);
                }
            }
        } else {
            for (int i = pos.size() - 1; i > 0; i--) {
                final Vector3 first = pos.get(i);
                final Vector3 second = pos.get(i - 1);
                first.setZ(0d);
                second.setZ(0d);
                final Double localDistance = Vector3.distance(first, second);
                distance += localDistance;
                if (distance >= absolutePart) {
                    final double localAbsPath = absolutePart - distance + localDistance;
                    final double localPart = localAbsPath / localDistance;
                    return Vector3.lerp(first, second, localPart);
                }
            }
        }
        return new Vector3(0, 0, 0);
    }
}

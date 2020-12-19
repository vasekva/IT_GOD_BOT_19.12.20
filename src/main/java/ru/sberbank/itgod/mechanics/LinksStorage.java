package ru.sberbank.itgod.mechanics;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.exception.NullArgumentException;

import java.util.HashMap;
import java.util.List;

/**
 * Класс, хранящий в себе пути между всеми зданиями на карте.
 * Внешний ключ - id строения, внутренняя хэшмап содержит id всех друних строений на карте и пути до них
 */
@Slf4j
public class LinksStorage {

    private final HashMap<Integer, HashMap<Integer, List<Vector3>>> storage = new HashMap<>();

    public void addAllLinksToStorage(List<Link> links) {
        for (final Link link : links) {
            addToStorage(link);
        }
    }

    private void addCorrectly(final Integer first, final Integer second, final List<Vector3> vector) {
        storage.putIfAbsent(first, new HashMap<>());
        final HashMap<Integer, List<Vector3>> result = storage.get(first);
        result.put(second, vector);
    }

    private void addToStorage(Link link) {
        if (link == null || link.getFrom() == null || link.getTo() == null || link.getVectors() == null)
            throw new NullArgumentException();
        if (link.getFrom() < link.getTo())
            addCorrectly(link.getFrom(), link.getTo(), link.getVectors());
        else
            addCorrectly(link.getTo(), link.getFrom(), link.getVectors());
    }

    private List<Vector3> getCorrectly(final Integer first, final Integer second) {
        final HashMap<Integer, List<Vector3>> result = storage.get(first);
        if (result == null) {
            log.error("Tower id {} isn't in storage list. Storage list: {}", first, storage);
            return null;
        }
        return result.get(second);
    }

    public List<Vector3> getFromStorage(final Integer first, final Integer second) {
        if (first == null || second == null)
            throw new NullArgumentException();
        if (first < second)
            return getCorrectly(first, second);
        return getCorrectly(second, first);
    }

    public Double getDistance(Integer fromId, Integer toId) {
        if (fromId.equals(toId))
            return 0d;
        List<Vector3> wayPoints = getFromStorage(fromId, toId);
        Double result = 0d;
        for (int i = 0; i < wayPoints.size() - 1; i++)
            result += Vector3.distance(wayPoints.get(i), wayPoints.get(i + 1));
        return result;
    }
}

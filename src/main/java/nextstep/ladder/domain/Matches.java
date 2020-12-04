package nextstep.ladder.domain;

import java.util.Map;
import java.util.Objects;

public class Matches {

    private final Map<Player, Result> matches;

    public Matches(Map<Player, Result> matches) {
        this.matches = matches;
    }

    public Result find(String nameToFind) {
        Player playerFound = matches.keySet()
                .stream()
                .filter(player -> player.hasName(nameToFind))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("there's no player of that name"));

        return matches.get(playerFound);
    }

    public Map<Player, Result> getMatches() {
        return matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matches matches1 = (Matches) o;
        return Objects.equals(matches, matches1.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }
}

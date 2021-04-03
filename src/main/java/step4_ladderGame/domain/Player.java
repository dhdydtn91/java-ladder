package step4_ladderGame.domain;

import java.util.Objects;

public class Player {

    private final Name name;
    private final Position position;

    private Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(String name, int position) {
        return new Player(Name.of(name), Position.of(position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

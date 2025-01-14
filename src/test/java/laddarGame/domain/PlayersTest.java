package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayersTest {

    @DisplayName("입력 받은 이름 만큼 플레이어를 만든다.")
    @Test
    void Player() {
        Players players = new Players("LG,SKT");

        assertEquals(2, players.playerCount());
    }

    @DisplayName("같은 포지션에 두명은 있을 수 없다..")
    @Test
    void duplicate() {
        Player Player1 = new Player("LG", 0);
        Player Player2 = new Player("SKT", 0);

        assertThrows(IllegalArgumentException.class, () -> new Players(List.of(Player1, Player2)));
    }

}
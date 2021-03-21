package laddarGame.domain;

import laddarGame.dto.PlayerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> playerList;
    private static final String DELIMITER = ",";

    public Players(String playerNames) {
        List<Player> playerList = playerList(nameParser(playerNames));
        isDuplicatePosition(playerList);
        this.playerList = playerList;
    }

    public Players(List<Player> playerList) {
        isDuplicatePosition(playerList);
        this.playerList = playerList;
    }

    private List<Player> playerList(String[] names) {
        List<Player> players = new ArrayList<>();
        for (int position = 0; position < names.length; position++) {
            players.add(new Player(names[position], position));
        }
        return players;
    }

    private String[] nameParser(String playerNames) {
        return playerNames.split(DELIMITER);
    }

    public int playerCount() {
        return playerList.size();
    }

    public int distinctCount(List<Player> players) {
        return (int) players.stream()
                .map(Player::getPosition)
                .distinct()
                .count();
    }

    public void isDuplicatePosition(List<Player> playerList) {
        int distinctCount = distinctCount(playerList);
        if (distinctCount != playerList.size()) {
            throw new IllegalArgumentException("같은 포지션에 두명이 있을 수 없습니다.");
        }
    }

    public int maxNameLength() {
        int maxLength = 0;
        for (Player player : playerList) {
            maxLength = player.maxNameLength(maxLength);
        }
        return maxLength;
    }

    public List<Player> toList() {
        return playerList;
    }

    public List<PlayerDto> plyersDto() {
        return playerList.stream()
                .map(Player::playerDto)
                .collect(Collectors.toList());
    }
}

package laddarGame.domain;

import laddarGame.dto.LineDto;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static laddarGame.domain.Line.ONE;
import static laddarGame.domain.Line.ZERO;

//각 사다리 라인을 관리하는 일급컬렉션
public class Ladder {

    private final List<Line> lines;

    public Ladder(int playerCount, int ladderHeight) {
        this(createLines(playerCount, ladderHeight));
    }

    public static List<Line> createLines(int playerCount, int ladderHeight) {
        return Stream.generate(() -> new Line(playerCount))
                .limit(ladderHeight)
                .collect(toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<LineDto> linesDto() {
        return lines.stream()
                .map(Line::lineDto)
                .collect(toList());
    }

    public List<String> play(Players players) {
        final Players[] result = {players};
        return lines.stream().map(line -> result[ZERO] = line.play(result[ZERO]))
                .skip(lines.size() - ONE)
                .collect(toList())
                .get(ZERO)
                .getPlayerName();
    }
}

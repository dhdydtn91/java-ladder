package nextstep.ladder.view;

import java.io.PrintStream;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream out = System.out;
    public static final String GET_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요.";
    public static final String GET_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String GET_FIRST_LINE_RESULT_MESSAGE = "실행 결과를 입력하세요.";
    public static final String GET_NAME_TO_FIND = "결과를 보고 싶은 사람은?";

    public static String getNames() {
        out.println(GET_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public static int getHeight() {
        out.println(GET_HEIGHT_MESSAGE);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("please input number");
        }
    }

    public static String getResults() {
        out.println(GET_FIRST_LINE_RESULT_MESSAGE);
        return scanner.nextLine();
    }

    public static String getNameToFind() {
        out.println(GET_NAME_TO_FIND);
        return scanner.nextLine();
    }
}
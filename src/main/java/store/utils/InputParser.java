package store.utils;

import java.util.List;

public class InputParser {

    private static final String PRODUCTS_DELIMITER = ",";
    private static final String PRODUCT_DELIMITER = "-";

    private InputParser() {
    }

    public static List<String> parseAndSubUserInput(String parse) {
        String substring = parse.substring(1, parse.length() - 1);
        return List.of(substring.split(PRODUCT_DELIMITER));
    }

    public static List<String> parseByDelimiter(String userInput) {
        return List.of(userInput.split(PRODUCTS_DELIMITER));
    }

}

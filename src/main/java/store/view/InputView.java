package store.view;

import static store.view.ErrorMessage.NOT_BLANK_INPUT;
import static store.view.ErrorMessage.NOT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String PURCHASE_PRODUCT_MESSAGE = "구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])";
    private static final String CONTINUE_PURCHASE_MESSAGE = "감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)";
    private static final Pattern NUMBER = Pattern.compile("\\d+");

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String userInput() {
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    public String purchaseInput() {
        printMessage(PURCHASE_PRODUCT_MESSAGE);
        return userInput();
    }

    public String continuePurchase() {
        printMessage(CONTINUE_PURCHASE_MESSAGE);
        return userInput();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void validateInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(NOT_BLANK_INPUT.getMessage());
        }
    }

    private void validateNumber(String userInput) {
        if (!NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

}

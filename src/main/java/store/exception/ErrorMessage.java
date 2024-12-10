package store.exception;

public enum ErrorMessage {

    OVER_STOCK_PURCHASE("재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}

package store.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import store.domain.Promotion;
import store.domain.Promotions;
import store.utils.FileParser;

public class StoreService {

    private static final String PROMOTION_FILE_DIRECTORY = "src/main/resources/promotions.md";
    private static final String DATE_TIME_FORMAT = "yyyy-mm-dd";

    public Promotions createPromotions() {
        List<String> lines = FileParser.readFile(PROMOTION_FILE_DIRECTORY);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        Promotions promotions = Promotions.create();

        for (String line : lines) {
            List<String> promotionInfo = FileParser.parseDelimiter(line);
            Promotion promotion = createPromotion(promotionInfo, formatter);
            promotions.addPromotion(promotion);
        }
        return promotions;
    }

    private Promotion createPromotion(List<String> promotionInfo, DateTimeFormatter formatter) {
        String name = promotionInfo.get(0);
        int buy = Integer.parseInt(promotionInfo.get(1));
        int get = Integer.parseInt(promotionInfo.get(2));
        LocalDate startDate = LocalDate.parse(promotionInfo.get(3), formatter);
        LocalDate endDate = LocalDate.parse(promotionInfo.get(4), formatter);
        return Promotion.of(name, buy, get, startDate, endDate);
    }

}

package store.domain;

import java.util.ArrayList;
import java.util.List;

public class Promotions {

    private List<Promotion> promotions;

    private Promotions() {
        this.promotions = new ArrayList<>();
    }

    public static Promotions create() {
        return new Promotions();
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public Promotion findPromotionByName(String name) {
        return promotions.stream()
                .filter(promotion -> promotion.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}

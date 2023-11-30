package com.gildedrose.items;

import com.gildedrose.StoredItem;

public class BaskstagePasses extends StoredItem {

    private static final int QUALITY_ZERO = 0;

    public BaskstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void changeQuality() {

        increaseQuality(QUALITY_INCREASE_DEFAULT_QUANTITY);

        if (stageStartBefore(10)) {
            increaseQuality(QUALITY_INCREASE_DEFAULT_QUANTITY);
        }

        if (stageStartBefore(5)) {
            increaseQuality(QUALITY_INCREASE_DEFAULT_QUANTITY);
        }
    }

    private boolean stageStartBefore(int days) {
        return this.sellIn <= days;
    }


    @Override
    public void changeQualitySellInOver() {
        this.quality = QUALITY_ZERO;
    }
}

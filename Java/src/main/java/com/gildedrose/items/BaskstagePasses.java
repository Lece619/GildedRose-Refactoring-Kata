package com.gildedrose.items;

import com.gildedrose.StoredItem;

public class BaskstagePasses extends StoredItem {

    private static final int QUALITY_ZERO = 0;
    private static final int QUALITY_INCREASE_5DAYS_BEFORE = 3;
    private static final int QUALITY_INCREASE_10DAYS_BEFORE = 2;

    public BaskstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void changeQuality() {
        
        if (stageStartBefore(5)) {
            increaseQuality(QUALITY_INCREASE_5DAYS_BEFORE);
            return;
        }

        if (stageStartBefore(10)) {
            increaseQuality(QUALITY_INCREASE_10DAYS_BEFORE);
            return;
        }

        increaseQuality(QUALITY_INCREASE_DEFAULT_QUANTITY);       
    }

    private boolean stageStartBefore(int days) {
        return this.sellIn <= days;
    }


    @Override
    public void changeQualitySellInOver() {
        this.quality = QUALITY_ZERO;
    }
}

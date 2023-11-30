package com.gildedrose.items;

import com.gildedrose.StoredItem;

public class AgedBrie extends StoredItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void changeQuality() {
        increaseQuality(QUALITY_INCREASE_DEFAULT_QUANTITY);
    }

    @Override
    protected void changeQualitySellInOver() {
        increaseQuality(QUALITY_INCREASE_DEFAULT_QUANTITY);
        return;
    }
}

package com.gildedrose.items;

import com.gildedrose.StoredItem;

public class Sulfuras extends StoredItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void changeSellIn() {
        return;
    }

    @Override
    public void changeQuality() {
        return;
    }

    @Override
    protected void changeQualitySellInOver() {
        return;
    }
}

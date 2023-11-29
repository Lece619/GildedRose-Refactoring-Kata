package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BaskstagePasses;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.Sulfuras;

public abstract class StoredItem extends Item {

    private static final int QUALITY_MAX_QUANTITY = 50;
    private static final int QUALITY_MIN_QUANTITY = 0;
    private static final int QUALITY_INCREASE_QUANTITY = 1;
    private static final int QUALITY_DECREASE_QUANTITY = 1;
    private static final int SELLIN_DECREASE_QUANTITY = 1;
    private static final int SELLIN_MIN_QUANTITY = 0;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public StoredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static StoredItem createStoredItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item.name, item.sellIn, item.quality);
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BaskstagePasses(item.name, item.sellIn, item.quality);
            case SULFURAS_HAND_OF_RAGNAROS:
                return new Sulfuras(item.name, item.sellIn, item.quality);
            default:
                return new NormalItem(item.name, item.sellIn, item.quality);
        }
    }

    public void changeDay() {

        changeSellIn();
        changeQuality();

        if (sellInDayOver()) {
            changeQualitySellInOver();
        }
    }

    private boolean sellInDayOver() {
        return this.sellIn < SELLIN_MIN_QUANTITY;
    }

    protected void changeSellIn() {
        this.sellIn = this.sellIn - SELLIN_DECREASE_QUANTITY;
    }

    protected void changeQuality() {
        decreaseQuality();
    }

    protected void changeQualitySellInOver() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        this.quality = Math.max(this.quality - QUALITY_DECREASE_QUANTITY, QUALITY_MIN_QUANTITY);
    }

    protected void increaseQuality() {
        this.quality = Math.min(this.quality + QUALITY_MAX_QUANTITY, QUALITY_MAX_QUANTITY);
    }
}

package com.gildedrose;

import com.gildedrose.Items.Aged_Brie;
import com.gildedrose.Items.Baskstage_passes;
import com.gildedrose.Items.Sulfuras;

public abstract class StoredItems extends Item{

    public StoredItems(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static StoredItems createStoredItem(String name, int sellIn, int quality) {
        switch (name) {
            case "Aged Brie":
                return new Aged_Brie(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Baskstage_passes(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(name, sellIn, quality);
            default:
                throw new IllegalArgumentException("Item not found");
        }
    }

    public void changeSellin() {
        this.sellIn--;
    }

    public abstract void changeQuality();
}

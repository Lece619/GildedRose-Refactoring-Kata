package com.gildedrose;

import com.gildedrose.Items.Aged_Brie;
import com.gildedrose.Items.Baskstage_passes;
import com.gildedrose.Items.Sulfuras;

public abstract class StoredItem extends Item{

    public StoredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static StoredItem createStoredItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new Aged_Brie(item.name, item.sellIn, item.quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Baskstage_passes(item.name, item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item.name, item.sellIn, item.quality);
            default:
                throw new IllegalArgumentException("Item not found");
        }
    }

    public void changeSellin() {
        this.sellIn--;
    }

    public abstract void changeQuality();
}

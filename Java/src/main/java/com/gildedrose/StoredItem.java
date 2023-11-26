package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BaskstagePasses;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.Sulfuras;

public abstract class StoredItem extends Item{

    public StoredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static StoredItem createStoredItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item.name, item.sellIn, item.quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BaskstagePasses(item.name, item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item.name, item.sellIn, item.quality);
            default:
                return new NormalItem(item.name, item.sellIn, item.quality);
        }
    }

    public void changeSellin() {
        this.sellIn--;
    }

    public void changeQuality(){
        if(this.quality > 0) {
            this.quality = this.quality - 1;
        }

        if(this.sellIn < 0 && this.quality > 0) {
            this.quality = this.quality - 1;
        }
    }
}

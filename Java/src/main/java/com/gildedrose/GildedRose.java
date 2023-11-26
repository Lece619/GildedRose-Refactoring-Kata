package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    StoredItem[] items;

    public GildedRose(Item[] items) {
        this.items = storeItem(items);
    }

    public StoredItem[] storeItem(Item[] items){
        return Arrays.stream(items).map(StoredItem::createStoredItem).toArray(StoredItem[]::new);
    }

    //재설계가 아닌 리팩토링이므로, 기존의 로직을 그대로 가져옴
    public void updateQuality() {
        for (StoredItem item : items) {

            item.changeSellin();

            if (!isAgedBrie(item)
                && !isBackstagePasses(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality = item.quality - 1;
                    }
                }
            }

            if(isAgedBrie(item)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (isBackstagePasses(item)) {
                item.quality = item.quality + 1;
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }


            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePasses(item)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}

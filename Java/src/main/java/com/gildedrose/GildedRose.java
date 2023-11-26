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

    public void updateQuality() {

        Arrays.stream(items).forEach(StoredItem::changeDay);

    }

}

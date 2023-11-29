package com.gildedrose;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    // TODO TEST 코드 작성
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            Item item = items[i];
            ItemComparisonRecord comparisonRecord = new ItemComparisonRecord(item);
            if (comparisonRecord.isLegendItem()) continue;

            if (comparisonRecord.isNormalAndPositiveQuality()) item.quality = comparisonRecord.isSellInNegativeNumber() ?
                item.quality-2 :
                item.quality-1;

            // TODO 추가된 변경 사항
            if (comparisonRecord.isSoBadAndPositiveQuality()) item.quality = comparisonRecord.isSellInNegativeNumber() ?
                item.quality-4 :
                item.quality-2;

            if (comparisonRecord.isSpecialAndQualityUnder50()) item.quality++;

            if (comparisonRecord.isBackStageProcess()) {
                if (item.sellIn < 11) item.quality++;
                if (item.sellIn < 6) item.quality++;
            } else if (comparisonRecord.isBackStageProcessInCaseNegativeSellIn()) item.quality = 0;


            if (comparisonRecord.isAgedBrieProcess()) item.quality++;


            item.sellIn--;
        }
    }
}

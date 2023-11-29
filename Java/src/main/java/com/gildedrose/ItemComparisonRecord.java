package com.gildedrose;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 아이템의 비교 연산을 통한 논리 자료형의 레코드
public record ItemComparisonRecord(
    boolean isNameAgedBrie, boolean isNameBackstagePasses, boolean isQualityNaturalNumber, boolean isSellInNegativeNumber,
    boolean isQualityUnder50, boolean isNormalItem, boolean isLegendItem, boolean isSoBadItem) {
public static final String AGED_BRIE = "Aged Brie", BACK_STAGE = "Backstage passes to a TAFKAL80ETC concert", SULFURAS = "Sulfuras, Hand of Ragnaros", CONJURED="Conjured";
private static final String[] specialItemNames, legendItemNames, soBadItemNames;
private static final Set<String> specialItemNameSet, legendItemNameSet, soBadItemNameSet; // 특수 아이템  // 전설 아이템
// 추후 해당 배열에 존재 하는 이름을 객체로 추출하면 된다. (각 특수 아이템, 각 노멀 아이템, 각 특수 아이템에 포함된 전설 아이템)
static{
    specialItemNames = new String[]{AGED_BRIE, BACK_STAGE, SULFURAS};
    legendItemNames = new String[]{SULFURAS};
    soBadItemNames = new String[]{CONJURED};
    specialItemNameSet = new HashSet<>(Arrays.asList(specialItemNames));
    legendItemNameSet = new HashSet<>(Arrays.asList(legendItemNames));
    soBadItemNameSet = new HashSet<>(Arrays.asList(soBadItemNames));
    }
public ItemComparisonRecord(Item item) {
    this(
    item.name.equals("Aged Brie"),
    item.name.equals("Backstage passes to a TAFKAL80ETC concert"),
    item.quality > 0,
    item.sellIn < 0,
    item.quality < 50,
    checkNormalItem(item),
    checkLegendItem(item),
    checkSoBadItem(item));
    }
private static boolean checkSoBadItem(Item item) {
    return soBadItemNameSet.contains(item.name);
    }
private static boolean checkLegendItem(Item item) {
    return legendItemNameSet.contains(item.name);
    }
private static boolean checkNormalItem(Item item) {
    return !specialItemNameSet.contains(item.name);
    }

/**
 * TODO새로 추가 된 요구사항
 * <h2><li>짱 나쁜 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이 음수라면 -4, 그렇지 않다면 -2 감소시킨다.</li></h2>
 * @return isNormalItem && isQualityNaturalNumber
 */
public boolean isSoBadAndPositiveQuality() {
    return isSoBadItem && isQualityNaturalNumber;
    }

/**
 * <h2><li>노멀 아이템이고 퀄리티가 자연수라면 퀄리티를 감소하는데 판매기간이 음수라면 -2, 그렇지 않다면 -1 감소시킨다.</li></h2>
 * @return isNormalItem && isQualityNaturalNumber
 */
public boolean isNormalAndPositiveQuality() {
    return isNormalItem && isQualityNaturalNumber;
    }

/**
 * <h2><li> 특수 아이템이고 퀄리티의 최대 값인 50 이하라면 퀄리티를 1씩 증가시킨다. </li></h2>
 * @return !isNormalItem && isQualityUnder50
 */
public boolean isSpecialAndQualityUnder50(){
    return !isNormalItem && isQualityUnder50;
    }

/**
 * <h2><li>특수 아이템 중 백스테이지이면서 판매일이 음수가 아니고 퀄리티가 50 이하일 때 판매일이 10 이하면 퀄리티 1를 추가 증가 5이하면 2를 추가 증가</li></h2>
 * @return isNameBackstagePasses && isQualityUnder50 && !isSellInNegativeNumber
 */
public boolean isBackStageProcess(){
    return isNameBackstagePasses && isQualityUnder50 && !isSellInNegativeNumber;
    }

/**
 * <h2><li>판매일이 음수인 경우 즉, 콘서트 종료 시에는 무조건 0으로 떨어짐</li></h2>
 * @return isNameBackstagePasses && isQualityUnder50 && isSellInNegativeNumber
 */
public boolean isBackStageProcessInCaseNegativeSellIn(){
    return isNameBackstagePasses && isQualityUnder50 && isSellInNegativeNumber;
    }

/**
 * <h2><li>특수 아이템 중 오래된 브리치즈이면서 판매일이 음수이면서 퀄리티가 50이하일 때 추가로 퀄리티가 1씩 추가 증가</li></h2>
 * @return isNameBackstagePasses && isQualityUnder50 && isSellInNegativeNumber
 */
public boolean isAgedBrieProcess(){
    return isNameAgedBrie && isQualityUnder50 && isSellInNegativeNumber;
    }
    }

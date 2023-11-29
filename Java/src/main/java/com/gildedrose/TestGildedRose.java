package com.gildedrose;

public class TestGildedRose {

    /**
     * 간단한 테스트를 통해서 ItemComparisonRecord 클래스의 isSellInNegativeNumber() 메서드가
     * Item 클래스의 sellIn 필드의 음수 여부를 정확하게 판단하는지 확인한다.
     *
     * 결과 : case 1 item 객체의 sellin이 변경되지 않았을때 음수 판단
     * sellIn : 1
     * false
     * case 2 item 객체의 sellin이 변경되었을때 음수 판단
     * ItemComparisonRecord = new ItemComparisonRecord(item);
     * 인스턴스 생성 후
     * sellIn : 1 -> -1 로 변경시
     * isSellInNegativeNumber() 메서드는 false 를 반환하게 된다
     *
     * why? : ItemComparisonRecord 클래스의 생성자에서 Item 클래스의 인스턴스를 받아서
     * ItemComparisonRecord 클래스를 생성하고 Item 클래스 값을 사용해서
     * 정적 필드인 isSellInNegativeNumber 를 초기화 시키기 때문에
     * Item 클래스의 sellIn 필드의 값이 변경되어도 ItemComparisonRecord 클래스의
     * isSellInNegativeNumber 필드의 값은 변경되지 않는다.
     *
     */
    public static void main(String[] args) {
        Item item = new Item("foo", 1, 0);
        ItemComparisonRecord comparisonRecord = new ItemComparisonRecord(item);
        System.out.println(" sellIn : " + item.sellIn);
        System.out.println(comparisonRecord.isSellInNegativeNumber());
        item.sellIn = -1;
        System.out.println(" sellIn : " + item.sellIn);
        System.out.println(comparisonRecord.isSellInNegativeNumber());
    }

}

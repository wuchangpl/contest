package com.contest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    
	/**
     * 如果：没有初始化商品
     * 当  ：执行更新品质
     * 则  ：不报错
     * @author jiashengzhong
     * */
    @Test
    public void if_dosenot_have_item(){
        GildedRose gildedRose = new GildedRose(null);
        
        gildedRose.updateQuality();
    }
    
	/**
     * 如果：有一个普通商品，其销售期为2天，品质为20
     * 当  ：过1天后
     * 则  ：该商品销售期为1，品质为19
     * @author jiashengzhong
     * */
    @Test
    public void normal_sellIn_2_quality_20_after_1days_will_sellin_1_quality_19(){
    	Item[] items = new Item[] { new Item("normal", 2, 20) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].sellIn);
        assertEquals(19, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个普通商品，其销售期为2天，品质为20
     * 当  ：过3天后
     * 则  ：该商品销售期为0，品质为16
     * @author jiashengzhong
     * */
    @Test
    public void normal_sellIn_2_quality_20_after_1days_will_sellin_0_quality_16(){
    	Item[] items = new Item[] { new Item("normal", 2, 20) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].sellIn);
        assertEquals(16, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个普通商品，其销售期为5天，品质为1
     * 当  ：过3天后
     * 则  ：该商品销售期为2，品质为0
     * @author jiashengzhong
     * */
    @Test
    public void normal_sellIn_5_quality_3_after_1days_sellin_2_quality_0s(){
    	Item[] items = new Item[] { new Item("normal", 5, 1) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertEquals(2, gildedRose.items[0].sellIn);
        assertEquals(0, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个"Aged Brie"（法国干酪），其销售期为2天，品质为3
     * 当  ：过一天后
     * 则  ：该商品销售期为1，品质为4
     * @author jiashengzhong
     * */
    @Test
    public void aged_brie_sellIn_2_quality_3_after_1days_sellin_1_quality_4(){
    	Item[] items = new Item[] { new Item("Aged Brie", 2, 3) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].sellIn);
        assertEquals(4, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个"Aged Brie"（法国干酪），其销售期为5天，品质为49
     * 当  ：过2天后
     * 则  ：该商品销售期为4，品质为50
     * @author jiashengzhong
     * */
    @Test
    public void aged_brie_sellIn_5_quality_49_after_2days_sellin_3_quality_50(){
    	Item[] items = new Item[] { new Item("Aged Brie", 5, 49) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertEquals(3, gildedRose.items[0].sellIn);
        assertEquals(50, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个传奇商品"Sulfuras"，其销售期为1天，品质为80
     * 当  ：过一天后
     * 则  ：该商品销售期为1，品质为80
     * @author jiashengzhong
     * */
    @Test
    public void sulfuras_sellIn_1_quality_80_after_oneday_sellin_1_quality_80(){
    	Item[] items = new Item[] { new Item("Sulfuras", 1, 80) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].sellIn);
        assertEquals(80, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个"Backstage passes"商品，其销售期为11天，品质为30
     * 当  ：过一天后
     * 则  ：该商品销售期为10，品质为31
     * */
    @Test
    public void backstage_passes_sellIn_11_quality_30_after_oneday_sellin_10_quality_31(){
    	Item[] items = new Item[] { new Item("Backstage passes", 11, 30) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();

        assertEquals(10, gildedRose.items[0].sellIn);
        assertEquals(31, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个"Backstage passes"商品，其销售期为11天，品质为30
     * 当  ：过一天后
     * 则  ：该商品销售期为10，品质为31
     * @author jiashengzhong
     * */
    @Test
    public void backstage_passes_sellIn_11_quality_30_after_oneday_will_sellin_10_quality_31(){
    	Item[] items = new Item[] { new Item("Backstage passes", 11, 30) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();

        assertEquals(10, gildedRose.items[0].sellIn);
        assertEquals(31, gildedRose.items[0].quality);
    }
    /**
     * 如果：有一个"Backstage passes"商品，其销售期为10天，品质为31
     * 当  ：过一天后
     * 则  ：该商品销售期为9，品质为33
     * @author jiashengzhong
     * */
    @Test
    public void backstage_passes_sellIn_10_quality_31_after_oneday_will_sellin_9_quality_33(){
    	Item[] items = new Item[] { new Item("Backstage passes", 10, 31) };
        GildedRose gildedRose = new GildedRose(items);
        
    	gildedRose.updateQuality();

        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(33, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个"Backstage passes"商品，其销售期为5天，品质为30
     * 当  ：过一天后
     * 则  ：该商品销售期为4，品质为33
     * @author jiashengzhong
     * */
    @Test
    public void backstage_passes_sellIn_5_quality_30_after_oneday_will_sellin_4_quality_33(){
    	Item[] items = new Item[] { new Item("Backstage passes", 5, 30) };
        GildedRose gildedRose = new GildedRose(items);
        
    	gildedRose.updateQuality();
        assertEquals(4, gildedRose.items[0].sellIn);
        assertEquals(33, gildedRose.items[0].quality);
    }
    
    /**
     * 如果：有一个"Backstage passes"商品，其销售期为1天，品质为30
     * 当  ：过一天后
     * 则  ：该商品销售期为0，品质为0
     * @author jiashengzhong
     * */
    @Test
    public void b2ackstage_passes_sellIn_1_quality_30_after_oneday_will_sellin_0_quality_0(){
    	Item[] items = new Item[] { new Item("Backstage passes", 1, 30) };
        GildedRose gildedRose = new GildedRose(items);
        
        gildedRose.updateQuality();
        
        assertEquals(0, gildedRose.items[0].sellIn);
        assertEquals(0, gildedRose.items[0].quality);
    }
}

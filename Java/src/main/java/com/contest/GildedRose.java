package com.contest;

class GildedRose {

	private static String BACKSTAGE_PASSES = "Backstage passes";
	private static String AGED_BRIE = "Aged Brie";
	private static String SULFURAS = "Sulfuras";

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		if (items == null || items.length == 0) {
			return;
		}
		for (Item item : items) {
			if (SULFURAS.equals(item.name)) {
				;
			} else if (BACKSTAGE_PASSES.equals(item.name)) {
				item.quality = calc_backstage_passes_quality(item);
				item.sellIn = calc_sellIn(item.sellIn);
			} else if (AGED_BRIE.equals(item.name)) {
				item.quality = clac_quality(item.quality, 1);
				item.sellIn = calc_sellIn(item.sellIn);
			} else {
				if (item.sellIn == 0) {
					item.quality = clac_quality(item.quality, -2);
				} else {
					item.sellIn = item.sellIn - 1;
					item.quality = clac_quality(item.quality, -1);
				}
			}
		}

	}

	/**
	 * 计算销售期
	 * @param int 销售期
	 */
	public int calc_sellIn(int sellIn) {
		int result = 0;
		if (sellIn > 0) {
			result = sellIn - 1;
		}
		return result;
	}
	/**
	 * 计算 剧场后台通行证 的品质
	 * @param Item 剧场后台通行证
	 */
	public int calc_backstage_passes_quality(Item item) {
		int result = 0;
		if (item.sellIn > 10) {
			result = clac_quality(item.quality, 1);
		} else if (item.sellIn <= 10 && item.sellIn > 5) {
			result = clac_quality(item.quality, 2);
		} else if (item.sellIn <= 5 && item.sellIn > 1) {
			result = clac_quality(item.quality, 3);
		} else {
			result = 0;
		}
		return result;
	}

	/**
	 * 计算品质
	 * @param int 品质值
	 * @param int 加减数值
	 */
	public int clac_quality(int quality, int value) {
		int result = quality + value;
		if (result < 0) {
			result = 0;
		} else if (result > 50) {
			result = 50;
		}
		return result;
	}
}

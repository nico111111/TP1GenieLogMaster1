package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {
	
    @Test
    void testItemNormalDecaySellIn() {
        Item[] items = new Item[] { new Item("Anneau de force du Dragon +5", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(4));
    }
	
	@Test
	void testItemNormalDecayQuality() {
        Item[] items = new Item[] { new Item("Anneau de force du Dragon +5", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(19));
    }

	@Test
	void testItemEndOfDateDecayQuality() {
        Item[] items = new Item[] { new Item("Anneau de force du Dragon +5", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(18));
    }

	@Test
	void testQualityNotNegative() {
        Item[] items = new Item[] { new Item("Anneau de force du Dragon +5", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(0));
    }

	@Test
	void testAgedBrieQualityAugment() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(6));
    }
	
	@Test
	void testAgedBrieQualityNoMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(50));
    }

	@Test
	void testSulfurasQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(80));
    }

	@Test
	void testPassQualityMoreThanTen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(16));
    }

	@Test
	void testPassQualityLessThanTenMoreThanFive() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(17));
    }

	@Test
	void testPassQualityLessThanFive() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(18));
    }

	@Test
	void testPassQualityZeroSellInZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(0));
    }

	@Test
	void testPassQualityNoMoreThanFifty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(50));
    }

	@Test
	void testAgedBrieQualityDoubleWhen0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(14));
    }
    
    @Test
	void testAgedBrieQualityNoMoreThan50Perimed() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(50));
    }

}

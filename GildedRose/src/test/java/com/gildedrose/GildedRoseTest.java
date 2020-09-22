package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {
	String normal = "Anneau de force du Dragon +5";
	String brie = "Aged Brie";
	String backStage = "Backstage passes to a TAFKAL80ETC concert";
	String conjured = "Conjured Mana Cake";
	String sulfuras = "Sulfuras, Hand of Ragnaros";

  @Test
  void testItemNormalDecaySellIn() {
    Item[] items = new Item[] { new Item(normal, 5, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].sellIn, is(4));
  }
	
	@Test
	void testItemNormalDecayQuality() {
    Item[] items = new Item[] { new Item(normal, 5, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(19));
  }

	@Test
	void testItemEndOfDateDecayQuality() {
    Item[] items = new Item[] { new Item(normal, 0, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(18));
  }

	@Test
	void testQualityNotNegative() {
      Item[] items = new Item[] { new Item(normal, 0, 0) };
      GildedRose app = new GildedRose(items);
      app.updateQuality();
      assertThat(app.getItems()[0].quality, is(0));
  }

	@Test
	void testQualityNotNegativeAgainIf1AndPerimed() {
    Item[] items = new Item[] { new Item(normal, 0, 1) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

	@Test
	void testAgedBrieQualityAugment() {
    Item[] items = new Item[] { new Item(brie, 5, 5) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(6));
  }
	
	@Test
	void testAgedBrieQualityNoMoreThan50() {
    Item[] items = new Item[] { new Item(brie, 5, 50) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(50));
  }

	@Test
	void testAgedBrieQualityDoubleWhen0() {
    Item[] items = new Item[] { new Item(brie, 0, 12) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(14));
  }
    
  @Test
	void testAgedBrieQualityNoMoreThan50Perimed() {
    Item[] items = new Item[] { new Item(brie, 0, 49) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(50));
  }

	@Test
	void testSulfurasQuality() {
    Item[] items = new Item[] { new Item(sulfuras, 0, 80) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(80));
  }

	@Test
	void testPassQualityMoreThanTen() {
    Item[] items = new Item[] { new Item(backStage, 20, 15) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(16));
  }

	@Test
	void testPassQualityLessThanTenMoreThanFive() {
    Item[] items = new Item[] { new Item(backStage, 10, 15) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(17));
  }

	@Test
	void testPassQualityLessThanFive() {
    Item[] items = new Item[] { new Item(backStage, 5, 15) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(18));
  }

	@Test
	void testPassQualityZeroSellInZero() {
    Item[] items = new Item[] { new Item(backStage, 0, 15) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

	@Test
	void testPassQualityNoMoreThanFifty() {
    Item[] items = new Item[] { new Item(backStage, 4, 49) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(50));
  }

	@Test
	void testPassQualityMoreThanFifty() {
    Item[] items = new Item[] { new Item(backStage, 4, 55) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(55));
  }

	@Test
	void testConjuredQualityNormal() {
    Item[] items = new Item[] { new Item(conjured, 4, 25) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(23));
  }

	@Test
	void testConjuredQualityPerimed() {
    Item[] items = new Item[] { new Item(conjured, 0, 25) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(21));
  }

	@Test
	void testConjuredQualityNoLessThan0() {
    Item[] items = new Item[] { new Item(conjured, 0, 1) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

	@Test
	void testConjuredQuality0() {
    Item[] items = new Item[] { new Item(conjured, 0, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

}

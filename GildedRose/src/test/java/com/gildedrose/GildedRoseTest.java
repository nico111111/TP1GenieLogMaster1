package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {
  static String normal = "Anneau de force du Dragon +5";
  static String brie = "Aged Brie";
  static String backStage = "Backstage passes to a TAFKAL80ETC concert";
  static String conjured = "Conjured Mana Cake";
  static String sulfuras = "Sulfuras, Hand of Ragnaros";

  @Test
  void testItemNormalDecaySellIn() {
    final Item[] items = new Item[] {new Item(normal, 5, 20) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].sellIn, is(4));
  }

  @Test
  void testItemNormalDecayQuality() {
    final Item[] items = new Item[] {new Item(normal, 5, 20) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(19));
  }

  @Test
  void testItemEndOfDateDecayQuality() {
    final Item[] items = new Item[] {new Item(normal, 0, 20) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(18));
  }

  @Test
  void testQualityNotNegative() {
    final Item[] items = new Item[] {new Item(normal, 0, 0) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

  @Test
  void testQualityNotNegativeAgainIf1AndPerimed() {
    final Item[] items = new Item[] {new Item(normal, 0, 1) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

  @Test
  void testAgedBrieQualityAugment() {
    final Item[] items = new Item[] {new Item(brie, 5, 5) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(6));
  }

  @Test
  void testAgedBrieQualityNoMoreThan50() {
    final Item[] items = new Item[] {new Item(brie, 5, 50) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(50));
  }

  @Test
  void testAgedBrieQualityDoubleWhen0() {
    final Item[] items = new Item[] {new Item(brie, 0, 12) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(14));
  }

  @Test
  void testAgedBrieQualityNoMoreThan50Perimed() {
    final Item[] items = new Item[] {new Item(brie, 0, 49) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(50));
  }

  @Test
  void testSulfurasQuality() {
    final Item[] items = new Item[] {new Item(sulfuras, 0, 80) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(80));
  }

  @Test
  void testPassQualityMoreThanTen() {
    final Item[] items = new Item[] {new Item(backStage, 20, 15) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(16));
  }

  @Test
  void testPassQualityLessThanTenMoreThanFive() {
    final Item[] items = new Item[] {new Item(backStage, 10, 15) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(17));
  }

  @Test
  void testPassQualityLessThanFive() {
    final Item[] items = new Item[] {new Item(backStage, 5, 15) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(18));
  }

  @Test
  void testPassQualityZeroSellInZero() {
    final Item[] items = new Item[] {new Item(backStage, 0, 15) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

  @Test
  void testPassQualityNoMoreThanFifty() {
    final Item[] items = new Item[] {new Item(backStage, 4, 49) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(50));
  }

  @Test
  void testPassQualityMoreThanFifty() {
    final Item[] items = new Item[] {new Item(backStage, 4, 55) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(55));
  }

  @Test
  void testConjuredQualityNormal() {
    final Item[] items = new Item[] {new Item(conjured, 4, 25) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(23));
  }

  @Test
  void testConjuredQualityPerimed() {
    final Item[] items = new Item[] {new Item(conjured, 0, 25) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(21));
  }

  @Test
  void testConjuredQualityNoLessThan0() {
    final Item[] items = new Item[] {new Item(conjured, 0, 1) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

  @Test
  void testConjuredQuality0() {
    final Item[] items = new Item[] {new Item(conjured, 0, 0) };
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.getItems()[0].quality, is(0));
  }

}

package com.gildedrose;
import java.util.*;

class GildedRose {
  private static int maxQuality = 50;
  private static int decayRate = 1;
  private static int backstageTier1 = 11;
  private static int backstageTier2 = 6;
  
  private static String brie = "Aged Brie";
  private static String backStage = "Backstage passes to a TAFKAL80ETC concert";
  private static String sulfuras = "Sulfuras, Hand of Ragnaros";
  private static String conjured = "Conjured Mana Cake";

  private Item[] items;

  GildedRose(Item[] listeitem) {
    this.items = listeitem;
  }

  public Item[] getItems() {
    return this.items;
  }

  public void setItems(Item[] listeitem) {
    this.items = listeitem;
  }

  public void updateQuality() {
    final List<String> listAevite = Arrays.asList(new String[]{brie, backStage, sulfuras, conjured});
    for (int i = 0; i < items.length; i++) {
      if (!items[i].name.equals(sulfuras)) {
        items[i].sellIn = items[i].sellIn - decayRate;
      }
      if (!listAevite.contains(items[i].name)) {
        updateNormaux(items[i]);
      }
      if (items[i].name.equals(brie)) {
        updateAgedBrie(items[i]);
      }
      if (items[i].name.equals(backStage)) {
        updateBackStage(items[i]);
      }
      if (items[i].name.equals(conjured)) {
        updateConjured(items[i]);
      }
    }
  }

  public void updateNormaux(Item item) {
    if (item.quality > 0) {
      if (item.sellIn < 0 && item.quality >= decayRate * 2) {
        item.quality = item.quality - decayRate * 2;
      } else {
        item.quality = item.quality - decayRate;
      }
    }
  }

  public void updateAgedBrie(Item item) {
    if (item.quality < maxQuality) {
      item.quality = item.quality + decayRate;
      if (item.sellIn < 0 && item.quality < maxQuality) {
        item.quality = item.quality + decayRate;
      }
    }
  }

  public void updateBackStage(Item item) {
    if (item.quality < maxQuality) {
      if (item.sellIn > 0) {
        item.quality = item.quality + decayRate;
        if (item.sellIn < backstageTier1 && item.quality < maxQuality) {
          item.quality = item.quality + decayRate;
        }
        if (item.sellIn < backstageTier2 && item.quality < maxQuality) {
          item.quality = item.quality + decayRate;
        }
      } else {
        item.quality = 0;
      }
    }
  }

  public void updateConjured(Item item) {
    if (item.quality > 0) {
      if (item.sellIn < 0) {
        item.quality = item.quality - decayRate * 4;
      } else {
        item.quality = item.quality - decayRate * 2;
      }
    }
    if (item.quality < 0) {
      item.quality = 0;
    }
  }
}

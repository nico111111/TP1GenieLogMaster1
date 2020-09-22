package com.gildedrose;
import java.util.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
		List<String> listAevite = Arrays.asList(new String[]{"Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"});
        for (int i = 0; i < items.length; i++) {       
        	if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            } 
        	if (!listAevite.contains(items[i].name)) {
                if (items[i].quality > 0) {
                	if (items[i].sellIn < 0) {
                		items[i].quality = items[i].quality - 2;
                	}else {
                    	items[i].quality = items[i].quality - 1;
                	}
                }   
            } 
            if (items[i].name.equals("Aged Brie")){
            	AgedBrie(items[i]);
            }
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
            	BackStage(items[i]);
            }
        }
    }   
    
     
    public void AgedBrie(Item item){
    	if (item.quality < 50) {
			item.quality = item.quality + 1;
			if (item.sellIn < 0 && item.quality < 50) {
				item.quality = item.quality + 1;
			}
		}      
    }
    
    
    public void BackStage(Item item){   
    	if (item.quality < 50) {
    		if (item.sellIn > 0) {
				item.quality = item.quality + 1;
				if (item.sellIn < 11 && item.quality < 50) {
					item.quality = item.quality + 1;
				}
				if (item.sellIn < 6 && item.quality < 50) {
					item.quality = item.quality + 1;
				}
	    	}else{
	    		item.quality = 0;
	    	}
    	}
    }
}

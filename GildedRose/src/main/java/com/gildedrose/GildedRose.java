package com.gildedrose;
import java.util.*;

class GildedRose {
	int maxQuality=50;
	int decayRate=1;
	int backstageTier1=11;
	int backstageTier2=6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
		List<String> listAevite = Arrays.asList(new String[]{"Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros","Conjured Mana Cake"});
        for (int i = 0; i < items.length; i++) {       
        	if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - decayRate;
            } 
        	if (!listAevite.contains(items[i].name)) {
                normaux(items[i]);
            } 
            if (items[i].name.equals("Aged Brie")){
            	agedBrie(items[i]);
            }
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
            	backStage(items[i]);
            }
			if (items[i].name.equals("Conjured Mana Cake")){
            	conjured(items[i]);
            }
        }
    }   
    
    public void normaux(Item item){
		if (item.quality > 0) {
        	if (item.sellIn < 0 && item.quality >= decayRate*2) {
        		item.quality = item.quality - decayRate*2;
        	}else {
            	item.quality = item.quality - decayRate;
        	}
        }   
	}

    public void agedBrie(Item item){
    	if (item.quality < maxQuality) {
			item.quality = item.quality + decayRate;
			if (item.sellIn < 0 && item.quality < maxQuality) {
				item.quality = item.quality + decayRate;
			}
		}      
    }
    
    
    public void backStage(Item item){  
    	if (item.quality < maxQuality) {
    		if (item.sellIn > 0) {
				item.quality = item.quality + decayRate;
				if (item.sellIn < backstageTier1 && item.quality < maxQuality) {
					item.quality = item.quality + decayRate;
				}
				if (item.sellIn < backstageTier2 && item.quality < maxQuality) {
					item.quality = item.quality + decayRate;
				}
	    	}else{
	    		item.quality = 0;
	    	}
    	}
    }

	public void conjured(Item item){
		if (item.quality > 0) {
        	if (item.sellIn < 0) {
        		item.quality = item.quality - decayRate*4;
        	}else {
            	item.quality = item.quality - decayRate*2;
        	}
        }
		if (item.quality<0){
			item.quality=0;
		}   	
	}
}

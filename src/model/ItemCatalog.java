package model;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {
    private List<Item> itemCatalog = new ArrayList<>();
    private int nextProductNumber;

    public ItemCatalog() {
        nextProductNumber = 1;
        itemCatalog.add(new Item(nextProductNumber++,"Lemon Oil",44.75,false,"Worth","images/lemonOil.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Lemon Grass Oil",35.25,true,"Cures","images/lemonGrassOil.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Cinnamon Oil", 71.22,true,"Aids","images/cinnamonOil.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Rosemary Oil",17.17,true,"Don't","images/RosemaryOils.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Peppermint Oil",9.91,false,"Have ","images/PeppermintOils.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Tea Tree Oil",103.52,true,"Men ","images/TeaTreeOils.jpg"));
        itemCatalog.add(new Item(nextProductNumber++," Sweet Orange Oil",4.44,false,"A ","images/SweetOrangeOils.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Eucalyptus Oil",17.77,false,"An ","images/EucalyptusOils.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Lavender Oil",13.33,false,"The ","images/LavenderOils.jpg"));
    }

    public List<Item> getItemCatalog() {
        return itemCatalog;
    }

    public List<Item> getFeaturedItemCatalog() {
        List<Item> item = new ArrayList<>();

        for(Item i: itemCatalog) {
            if (i.isFeatured()) {
                item.add(i);
            }
        }
        return item;
    }
    public Item getSingleItem(int itemNum) {
        Item item=null;

        for(Item i: itemCatalog) {
            if (i.getProductNumber() == itemNum) {
                return i;
            }
        }
        return item;
    }
}

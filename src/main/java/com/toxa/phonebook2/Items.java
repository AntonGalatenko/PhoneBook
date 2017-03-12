package com.toxa.phonebook2;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private List<Item> items;

    public Items(){
        items = new ArrayList<Item>();

        items.add(new Item("Иван","Портник", "+380931231212", "опис1"));
        items.add(new Item("Коля","Сушка", "+380503216565", "опис2"));
        items.add(new Item("Катя","Сточка", "+380679875656", "опис3"));
        items.add(new Item("Люда","Перемка", "+380632583636", "опис4"));
    }

    public void add(Item item){
        items.add(item);
    }

    public List<Item> get(){
        return items;
    }

    public void delete(String phone){
        phone = "+" + phone;

        for(Item itm : items)
            if(itm.getPhone().equals(phone)){
                items.remove(itm);
                break;
            }


    }
}

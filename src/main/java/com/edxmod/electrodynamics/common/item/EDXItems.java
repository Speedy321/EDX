package com.edxmod.electrodynamics.common.item;

import com.edxmod.electrodynamics.common.item.component.*;
import com.edxmod.electrodynamics.common.item.prefab.EDXBasicItem;
import com.edxmod.electrodynamics.common.item.tool.*;
import com.edxmod.electrodynamics.common.item.tool.hammer.*;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.ArrayList;

/**
 * @author Thlayli.
 */
public class EDXItems {

    private static ArrayList<Item> itemList;
    /*Tools*/
    public static ItemPeelingSpud itemBarkSpud;
    public static ItemTreeTap itemTreeTap;
    public static ItemRedstoneEmitter itemRedstoneEmitter;
    public static ItemScrewdriver itemScrewdriver;
    public static ItemSolderingIron itemSolderingIron;
    public static ItemWireCutter itemWireCutter;
    public static ItemWirelessScanner itemWirelessScanner;
    public static ItemHandSieve itemHandSieve;
    public static ItemMixingJar itemMixingJar;
    public static ItemSinteringTray itemSinteringTray;
    public static ItemHammer itemHammer;
    public static ItemSledgeHammer itemSledgeHammer;
    /*Components*/
    public static EDXBasicItem itemBucketLatex;


    public static void init() {
        initItems();
        registerItems();
    }

    private static void initItems() {
        itemList = new ArrayList<Item>(1);
        /*tools*/
        itemList.add(itemBarkSpud = new ItemPeelingSpud());
        itemList.add(itemTreeTap = new ItemTreeTap());
        itemList.add(itemRedstoneEmitter = new ItemRedstoneEmitter());
        itemList.add(itemScrewdriver = new ItemScrewdriver());
        itemList.add(itemSolderingIron = new ItemSolderingIron());
        itemList.add(itemWireCutter = new ItemWireCutter());
        itemList.add(itemWirelessScanner = new ItemWirelessScanner());
        itemList.add(itemHandSieve = new ItemHandSieve());
        itemList.add(itemMixingJar = new ItemMixingJar());
        itemList.add(itemSinteringTray = new ItemSinteringTray());
        itemList.add(itemHammer = new ItemHammer());
        itemList.add(itemSledgeHammer = new ItemSledgeHammer());
        /*components*/
        itemList.add(itemBucketLatex = new ItemBucketLatex());
    }

    private static void registerItems() {
        for (int i = 0; i < itemList.size(); i++) {
            GameRegistry.registerItem(itemList.get(i), itemList.get(i).getUnlocalizedName(), EDXProps.ID);
        }
    }
}

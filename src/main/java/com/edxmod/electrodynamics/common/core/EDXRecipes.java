package com.edxmod.electrodynamics.common.core;

import net.minecraft.item.crafting.CraftingManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Royalixor
 */
public class EDXRecipes {

    private static List frontRecipes = new ArrayList();

    public static void init() {
        addCraftingRecipes();
        addOreRegistration();
        addSmeltingRecipes();
        CraftingManager.getInstance().getRecipeList().addAll(0, frontRecipes);
    }

    private static void addCraftingRecipes() {
    }

    private static void addOreRegistration() {
    }

    private static void addSmeltingRecipes() {
    }


}

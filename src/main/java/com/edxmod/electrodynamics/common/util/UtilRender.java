package com.edxmod.electrodynamics.common.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

/**
 * @author dmillerw
 */
public class UtilRender {

    public static boolean graphicsCache;

    public static int lightingCache;

    public static void forceGraphics(boolean fancy) {
        graphicsCache = Minecraft.getMinecraft().gameSettings.fancyGraphics;
        Minecraft.getMinecraft().gameSettings.fancyGraphics = fancy;
    }

    public static void resetGraphics() {
        Minecraft.getMinecraft().gameSettings.fancyGraphics = graphicsCache;
    }

    public static void forceLighting(int lighting) {
        lightingCache = Minecraft.getMinecraft().gameSettings.ambientOcclusion;
        Minecraft.getMinecraft().gameSettings.ambientOcclusion = lighting;
    }

    public static void resetLighting() {
        Minecraft.getMinecraft().gameSettings.ambientOcclusion = lightingCache;
    }

    public static void renderItemStack(ItemStack stack, boolean force3D) {
        if (force3D) {
            forceGraphics(true);
        }

        EntityItem item = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, stack);
        item.hoverStart = 0;

        RenderManager.instance.renderEntityWithPosYaw(item, 0, 0, 0, 0, 0);

        if (force3D) {
            resetGraphics();
        }
    }

}

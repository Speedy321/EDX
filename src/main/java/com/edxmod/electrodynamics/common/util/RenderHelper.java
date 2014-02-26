package com.edxmod.electrodynamics.common.util;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import org.lwjgl.opengl.GL11;

/**
 * @author Royalixor
 */
@SideOnly(Side.CLIENT)
public enum RenderHelper {

    instance;

    public boolean fancyOriginal;
    public int lightingOriginal;

    public void forceGraphics(boolean value) {
        fancyOriginal = Minecraft.getMinecraft().gameSettings.fancyGraphics;
        Minecraft.getMinecraft().gameSettings.fancyGraphics = value;
    }

    public void forceLighting(int value) {
        lightingOriginal = Minecraft.getMinecraft().gameSettings.ambientOcclusion;
        Minecraft.getMinecraft().gameSettings.ambientOcclusion = value;
    }

    public void resetLighting() {
        Minecraft.getMinecraft().gameSettings.ambientOcclusion = lightingOriginal;
    }

    public void resetGraphics() {
        Minecraft.getMinecraft().gameSettings.fancyGraphics = fancyOriginal;
    }

    public void renderItem(ItemStack stack) {
        if (stack == null) {
            return;
        }

        forceGraphics(true);

        EntityItem item = new EntityItem(FMLClientHandler.instance().getClient().theWorld);
        item.setEntityItemStack(stack);
        item.hoverStart = 0F;

        RenderManager.instance.renderEntityWithPosYaw(item, 0D, 0D, 0D, 0F, 0F);

        resetGraphics();
    }

    public void setGLColor(int color) {
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        GL11.glColor4f(r, g, b, 1.0F);
    }

    public void renderAllSides(RenderBlocks renderer, Block block) {
        renderAllSides(renderer, block, renderer.overrideBlockTexture);
    }

    public void renderAllSides(RenderBlocks renderblocks, Block block, IIcon icon) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        if (icon != null) {
            renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        if (icon != null) {
            renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        if (icon != null) {
            renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        if (icon != null) {
            renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        if (icon != null) {
            renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
        }
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        if (icon != null) {
            renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
        }
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    public void renderAllSides(int x, int y, int z, Block block, RenderBlocks renderer, IIcon tex) {
        renderer.renderFaceXNeg(block, x, y, z, tex);
        renderer.renderFaceXPos(block, x, y, z, tex);
        renderer.renderFaceZNeg(block, x, y, z, tex);
        renderer.renderFaceZPos(block, x, y, z, tex);
        renderer.renderFaceYNeg(block, x, y, z, tex);
        renderer.renderFaceYPos(block, x, y, z, tex);
    }

    public void renderAllSidesInverted(int x, int y, int z, Block block, RenderBlocks renderer, IIcon tex) {
        renderer.renderFaceXNeg(block, x + 1, y, z, tex);
        renderer.renderFaceXPos(block, x - 1, y, z, tex);
        renderer.renderFaceZNeg(block, x, y, z + 1, tex);
        renderer.renderFaceZPos(block, x, y, z - 1, tex);
        renderer.renderFaceYNeg(block, x, y + 1, z, tex);
        renderer.renderFaceYPos(block, x, y - 1, z, tex);
    }

}

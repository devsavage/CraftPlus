package tv.savageboy74.craftplus.init;

/*
 * ModItems.java
 * Copyright (C) 2015 Savage - github.com/savageboy74
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tv.savageboy74.craftplus.items.DenseDiamond;
import tv.savageboy74.craftplus.items.armor.DenseDiamondArmor;
import tv.savageboy74.craftplus.items.tools.*;
import tv.savageboy74.craftplus.util.Reference;

public class ModItems
{
    private static int DA0;
    private static int DA1;
    private static int DA2;
    private static int DA3;

    public static final Item denseDiamond = new DenseDiamond();
    public static final Item denseSword = new DenseDiamondSword(ModMaterials.denseDiamondTool);
    public static final Item denseHoe = new DenseDiamondHoe(ModMaterials.denseDiamondTool);
    public static final Item denseShovel = new DenseDiamondShovel(ModMaterials.denseDiamondTool);
    public static final Item densePickaxe = new DenseDiamondPickaxe(ModMaterials.denseDiamondTool);
    public static final Item denseAxe = new DenseDiamondAxe(ModMaterials.denseDiamondTool);
    public static final Item denseHelmet = new DenseDiamondArmor(ModMaterials.denseDiamondArmor, DA0, 0).setUnlocalizedName("DenseDiamondHelmet").setTextureName(Reference.mod_id.toLowerCase() + ":" + "dense_diamond_helmet");
    public static final Item denseChest = new DenseDiamondArmor(ModMaterials.denseDiamondArmor, DA1, 1).setUnlocalizedName("DenseDiamondChest").setTextureName(Reference.mod_id.toLowerCase() + ":" + "dense_diamond_chestplate");
    public static final Item denseLeggings = new DenseDiamondArmor(ModMaterials.denseDiamondArmor, DA2, 2).setUnlocalizedName("DenseDiamondLeggings").setTextureName(Reference.mod_id.toLowerCase() + ":" + "dense_diamond_leggings");
    public static final Item denseBoots = new DenseDiamondArmor(ModMaterials.denseDiamondArmor, DA3, 3).setUnlocalizedName("DenseDiamondBoots").setTextureName(Reference.mod_id.toLowerCase() + ":" + "dense_diamond_boots");

    public static void init()
    {
        GameRegistry.registerItem(denseDiamond, "DenseDiamond");
        GameRegistry.registerItem(denseHelmet, "DenseDiamondHelmet");
        GameRegistry.registerItem(denseChest, "DenseDiamondChest");
        GameRegistry.registerItem(denseLeggings, "DenseDiamondLeggings");
        GameRegistry.registerItem(denseBoots, "DenseDiamondBoots");
        GameRegistry.registerItem(denseSword, "DenseDiamondSword");
        GameRegistry.registerItem(denseHoe, "DenseDiamondHoe");
        GameRegistry.registerItem(denseShovel, "DenseDiamondShovel");
        GameRegistry.registerItem(densePickaxe, "DenseDiamondPickaxe");
        GameRegistry.registerItem(denseAxe, "DenseDiamondAxe");
    }
}

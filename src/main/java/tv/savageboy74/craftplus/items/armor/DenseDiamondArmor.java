package tv.savageboy74.craftplus.items.armor;

/*
 * DenseDiamond.java
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

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import tv.savageboy74.craftplus.CraftPlus;
import tv.savageboy74.craftplus.init.ModItems;
import tv.savageboy74.craftplus.util.Reference;

public class DenseDiamondArmor extends ItemArmor
{
    public DenseDiamondArmor(ArmorMaterial material, int renderIndex, int armorType)
    {
        super(material, renderIndex, armorType);
        this.setCreativeTab(CraftPlus.craftPlusTab);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if ((stack.getItem()) == ModItems.denseHelmet || (stack.getItem()) == ModItems.denseChest || (stack.getItem()) == ModItems.denseBoots)
        {
            return Reference.mod_id + ":textures/models/armor/dense_diamond_layer_1.png";
        }

        else if ((stack.getItem()) == ModItems.denseLeggings)
        {
            return Reference.mod_id + ":textures/models/armor/dense_diamond_layer_2.png";
        }

        return null;
    }
}

package tv.savageboy74.craftplus;

/*
 * CraftPlus.java
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

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.MinecraftForge;
import tv.savageboy74.craftplus.handler.ConfigHandler;
import tv.savageboy74.craftplus.init.ModBlocks;
import tv.savageboy74.craftplus.init.ModItems;
import tv.savageboy74.craftplus.util.Logger;
import tv.savageboy74.craftplus.util.Reference;
import tv.savageboy74.craftplus.util.UpdateChecker;
import tv.savageboy74.craftplus.world.WorldGenOre;

import java.io.IOException;

@Mod(modid = Reference.mod_id, name = Reference.mod_name, version = Reference.mod_version)
public class CraftPlus
{
    public static CreativeTabs craftPlusTab;
    WorldGenOre oreGen = new WorldGenOre();


    @Mod.Instance(Reference.mod_id)
    public static CraftPlus instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        craftPlusTab = new CreativeTabs("tabCraftPlus") {
            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ModItems.denseDiamond;
            }
        };

        ModBlocks.init();
        ModItems.init();
        GameRegistry.registerWorldGenerator(oreGen, 0);
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        if (ConfigHandler.checkForUpdates)
        {
            try
            {
                Logger.info("Checking for updates...");
                UpdateChecker.checkForUpdates();
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        Logger.info("Pre-Initialization Complete.");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Logger.info("Initialization Complete.");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Logger.info("Post-Initialization Complete.");
    }

    @SubscribeEvent
    public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
    {
        if (Reference.outdated)
        {
            String text = EnumChatFormatting.GOLD + "[" + Reference.mod_name + "] " +  EnumChatFormatting.WHITE + "This version of " + EnumChatFormatting.GOLD + Reference.mod_name + EnumChatFormatting.WHITE + " is" + EnumChatFormatting.DARK_RED + " outdated!" + EnumChatFormatting.WHITE + "     " + "Newest Version: " + EnumChatFormatting.DARK_GREEN +  Reference.new_version;
            String download = "Download";
            String UPDATE_URL = "https://savageboy74.tv/mods/downloads/CraftPlus-" + Reference.new_version + ".jar";
            event.player.addChatComponentMessage(new IChatComponent.Serializer().func_150699_a("[{\"text\":\"" + text + "\"}," + "{\"text\":\" " + EnumChatFormatting.WHITE + "[" + EnumChatFormatting.GREEN + download + EnumChatFormatting.WHITE + "]\"," + "\"color\":\"green\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":" + "{\"text\":\"Click to download the latest version\",\"color\":\"yellow\"}}," + "\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + UPDATE_URL + "\"}}]"));

        }
    }
}

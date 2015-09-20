package com.thexfactor117.levels.events;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventItemTooltip 
{
	@SubscribeEvent
	public void addInformation(ItemTooltipEvent event)
	{
		ItemStack stack = event.itemStack;
		NBTTagCompound nbt = stack.getTagCompound();
		
		if (nbt != null)
		{			
			/*
			 * 
			 * WEAPONS
			 * 
			 */
			if (stack.getItem() instanceof ItemSword)
			{	
				/*
				 * Tooltip
				 */
				event.toolTip.add("");
				
				if (nbt.getInteger("RARITY") == 0) event.toolTip.add(EnumChatFormatting.ITALIC + "Unknown");
				if (nbt.getInteger("RARITY") == 1) event.toolTip.add(EnumChatFormatting.WHITE + "" + EnumChatFormatting.ITALIC + "Basic");
				if (nbt.getInteger("RARITY") == 2) event.toolTip.add(EnumChatFormatting.DARK_GREEN + "" + EnumChatFormatting.ITALIC + "Uncommon");
				if (nbt.getInteger("RARITY") == 3) event.toolTip.add(EnumChatFormatting.AQUA + "" + EnumChatFormatting.ITALIC + "Rare");
				if (nbt.getInteger("RARITY") == 4) event.toolTip.add(EnumChatFormatting.DARK_PURPLE + "" + EnumChatFormatting.ITALIC + "Legendary");
				if (nbt.getInteger("RARITY") == 5) event.toolTip.add(EnumChatFormatting.GOLD + "" + EnumChatFormatting.ITALIC + "Ancient");
				
				event.toolTip.add("Level: " + nbt.getInteger("LEVEL"));
				
				if (nbt.getInteger("LEVEL") == 1) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/1000");
				if (nbt.getInteger("LEVEL") == 2) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/2500");
				if (nbt.getInteger("LEVEL") == 3) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/5000");
				if (nbt.getInteger("LEVEL") == 4) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/10000");
				if (nbt.getInteger("LEVEL") == 5) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/20000");
				if (nbt.getInteger("LEVEL") == 6) event.toolTip.add("Experience: " + "Max");
				
				event.toolTip.add(event.itemStack.getMaxDamage() - event.itemStack.getItemDamage() + " Durability");
				
				event.toolTip.add("");
				
				if (nbt.getBoolean("FIRE")) event.toolTip.add(EnumChatFormatting.DARK_RED + "Fire");
				if (nbt.getBoolean("FROST")) event.toolTip.add(EnumChatFormatting.AQUA + "Frost");
				if (nbt.getBoolean("POISON")) event.toolTip.add(EnumChatFormatting.DARK_GREEN + "Poison");
				if (nbt.getBoolean("STRENGTH")) event.toolTip.add(EnumChatFormatting.LIGHT_PURPLE + "Strength");
				if (nbt.getBoolean("ETHEREAL")) event.toolTip.add(EnumChatFormatting.BLUE + "Ethereal");
				if (nbt.getBoolean("VOID")) event.toolTip.add(EnumChatFormatting.DARK_PURPLE + "Void");
			}
			
			/*
			 * 
			 * ARMOR
			 * 
			 */
			if (stack.getItem() instanceof ItemArmor)
			{	
				/*
				 * Tooltip
				 */
				event.toolTip.add("");
				event.toolTip.add("Level: " + nbt.getInteger("LEVEL"));
				
				if (nbt.getInteger("LEVEL") == 1) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/100");
				if (nbt.getInteger("LEVEL") == 2) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/250");
				if (nbt.getInteger("LEVEL") == 3) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/500");
				if (nbt.getInteger("LEVEL") == 4) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/1000");
				if (nbt.getInteger("LEVEL") == 5) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE") + "/2000");
				if (nbt.getInteger("LEVEL") == 6) event.toolTip.add("Experience: " + nbt.getInteger("EXPERIENCE"));
				
				event.toolTip.add(stack.getMaxDamage() - stack.getItemDamage() + " Hits Remaining");
				event.toolTip.add("");
				
				if (nbt.getBoolean("HARDENED")) event.toolTip.add(EnumChatFormatting.WHITE + "Hardened");
				if (nbt.getBoolean("POISONED")) event.toolTip.add(EnumChatFormatting.DARK_GREEN + "Poisoned");
				if (nbt.getBoolean("STRENGTH")) event.toolTip.add(EnumChatFormatting.LIGHT_PURPLE + "Strength");
				if (nbt.getBoolean("IMMUNIZATION")) event.toolTip.add(EnumChatFormatting.GOLD + "Immunization");
				if (nbt.getBoolean("ETHEREAL")) event.toolTip.add(EnumChatFormatting.BLUE + "Ethereal");
				if (nbt.getBoolean("VOID")) event.toolTip.add(EnumChatFormatting.DARK_PURPLE + "Void");
			}
		}
	}
}

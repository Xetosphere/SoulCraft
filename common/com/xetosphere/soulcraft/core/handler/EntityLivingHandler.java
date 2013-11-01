package com.xetosphere.soulcraft.core.handler;

import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.xetosphere.soulcraft.item.ModItems;

public class EntityLivingHandler {

	@ForgeSubscribe
	public void onEntityLivingUpdate(LivingUpdateEvent event) {

	}

	@SuppressWarnings("unused")
	@ForgeSubscribe
	public void onEntityLivingDeath(LivingDeathEvent event) {

		Random random = new Random();

		if (event.source.getDamageType().equals("player")) {

			EntityPlayer p = (EntityPlayer) event.source.getEntity();

			if (event.entityLiving instanceof EntityLiving) {

				int chance = random.nextInt(20) + 1;
				if (chance < 2) {
					event.entityLiving.dropItem(ModItems.soul.itemID, 1);
				}
			}
		}

		if (event.source.getSourceOfDamage() instanceof EntityArrow) {
			if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null) {
				if (((EntityArrow) event.source.getSourceOfDamage()).shootingEntity instanceof EntityPlayer) {

					EntityPlayer p = (EntityPlayer) event.source.getEntity();

					if (event.entityLiving instanceof EntityLiving) {

						int chance = random.nextInt(20) + 1;
						if (chance < 2) {
							event.entityLiving.dropItem(ModItems.soul.itemID, 1);
						}
					}
				}
			}
		}
	}

}

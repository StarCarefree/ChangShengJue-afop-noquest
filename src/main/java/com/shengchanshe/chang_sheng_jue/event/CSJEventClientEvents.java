package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.event.kungfu.TreadTheSnowWithoutTraceClientEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID ,value = Dist.CLIENT)
public class CSJEventClientEvents {
    private static Minecraft mc = Minecraft.getInstance();
    @SubscribeEvent
    public static void onKey(InputEvent.Key event) {
        TreadTheSnowWithoutTraceClientEvent.onKey(event);
        onKeys(event);
    }

    public static void onKeys(InputEvent.Key event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;
    }
    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        TreadTheSnowWithoutTraceClientEvent.onFall(event);
    }

    private static final ResourceLocation BUTTON_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/botton.png");

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
    }

}

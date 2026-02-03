package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXiaMerchant;
// 移除了任务类的导入
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractGangLeader extends AbstractWuXiaMerchant {
    // 移除了任务存储相关的字段

    public AbstractGangLeader(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public void resetOffers() {
        this.offers = null; // 强制下次访问时重新生成
    }

    public void openTradingScreen(Player pPlayer, Component pDisplayName, int pLevel) {
        // 实现交易界面打开逻辑
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemInHand = pPlayer.getItemInHand(pHand);
        if (this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (pHand == InteractionHand.MAIN_HAND) {
                pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else {
                if (!this.level().isClientSide) {
                    this.startTrading(pPlayer);
                }
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    /**
     * 移除指定玩家接受的任务
     * @param playerId 玩家UUID
     * @param questId 要删除的任务ID
     */
    public void removeQuest(UUID playerId, UUID questId) {
        // 移除了任务移除逻辑
    }

    /**
     * 移除玩家所有已经接受的任务(acceptedBy为null的任务)
     * @param playerId 玩家UUID
     */
    public void removeUnacceptedQuests(UUID playerId) {
        // 移除了未接受任务的移除逻辑
    }

    /**
     * 清除指定玩家的所有任务
     * @param playerId 玩家UUID
     */
    public void clearPlayerQuests(UUID playerId) {
        // 移除了清除玩家任务的逻辑
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        // 移除了任务数据的保存逻辑
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        // 移除了任务数据的读取逻辑
    }

    /**
     * 获取指定玩家的任务列表
     * @param playerId 玩家UUID
     * @return 该玩家的任务列表(如果没有则创建空列表)
     */
    public List<Object> getPlayerQuests(UUID playerId) {
        // 移除了任务获取逻辑，返回空列表
        return new ArrayList<>();
    }

    /**
     * 为指定玩家添加任务
     * @param playerId 玩家UUID
     * @param quest 要添加的任务
     */
    public void addQuestForPlayer(UUID playerId, Object quest) {
        // 移除了添加任务的逻辑
    }

    /**
     * 获取所有玩家的任务数据(主要用于调试)
     * @return 所有玩家的任务映射
     */
    public Map<UUID, List<Object>> getAllPlayerQuests() {
        // 移除了获取所有任务的逻辑
        return new HashMap<>();
    }
}
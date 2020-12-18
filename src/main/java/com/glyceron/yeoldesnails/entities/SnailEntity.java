package com.glyceron.yeoldesnails.entities;

import com.glyceron.yeoldesnails.init.ModEntityTypes;
import com.glyceron.yeoldesnails.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class SnailEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.DANDELION, Items.CORNFLOWER, Items.BROWN_MUSHROOM, Items.RED_MUSHROOM);

    public SnailEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //func_233666_p_ ---> registerAttributes()
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 4.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, .1D);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        //SPEED VARIABLES ARE FOR TESTING
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 10.D, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        //testing goal
        this.goalSelector.addGoal(4, new GatherNearComposterGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(2);
    }

    @Nullable
    @Override
    // create child method
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return ModEntityTypes.SNAIL.get().create(this.world);
    }

    // Method copied and modified from Alexthe666's AlexMobs mod
    // Method for snails being picked up by buckets
    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        if (itemstack.getItem() == Items.BUCKET && this.isAlive()) {
            this.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);

            ItemStack snailBucket = new ItemStack(ModItems.SNAIL_BUCKET.get());
            if (!this.world.isRemote) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)p_230254_1_, snailBucket);
            }

            if (itemstack.isEmpty()) {
                p_230254_1_.setHeldItem(p_230254_2_, snailBucket);
            } else if (!p_230254_1_.inventory.addItemStackToInventory(snailBucket)) {
                p_230254_1_.dropItem(snailBucket, false);
            }
            this.remove();
            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        }
    }

    public class GatherNearComposterGoal extends MoveToBlockGoal {
        private final SnailEntity snail;

        private GatherNearComposterGoal(SnailEntity snail, double speedIn) {
            super(snail, speedIn, 24);
            this.snail = snail;
            this.field_203112_e = -1;
        }

        public boolean shouldContinueExecuting() {
            return this.timeoutCounter <= 600 && this.shouldMoveTo(this.snail.world, this.destinationBlock);
        }

        public boolean shouldExecute() {
            return super.shouldExecute();
        }

        public boolean shouldMove() {
            return this.timeoutCounter % 160 == 0;
        }

        protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
            BlockState blockstate = worldIn.getBlockState(pos);
            if(blockstate.isIn(Blocks.COMPOSTER)) {
                return blockstate.get(ComposterBlock.LEVEL) >= 1;
            } else {
                return false;
            }
        }
    }

}

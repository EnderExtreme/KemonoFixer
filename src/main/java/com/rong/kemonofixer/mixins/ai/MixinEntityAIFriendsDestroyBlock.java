package com.rong.kemonofixer.mixins.ai;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rong.kemonofixer.Configuration;

import erx.kemonocraft.entity.ai.EntityAIFriendsDestroyBlock;
import net.minecraft.entity.ai.EntityAIBase;

@Mixin(EntityAIFriendsDestroyBlock.class)
public abstract class MixinEntityAIFriendsDestroyBlock extends EntityAIBase {

    @Inject(method = "shouldExecute", at = @At("HEAD"), cancellable = true, remap = false)
    private void onShouldExecute(CallbackInfoReturnable<Boolean> info) {
        if (!Configuration.AI.AI_CAN_DESTROY) {
            info.setReturnValue(false);
        }
    }
    
}
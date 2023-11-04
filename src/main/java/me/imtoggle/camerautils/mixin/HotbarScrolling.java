package me.imtoggle.camerautils.mixin;

import me.imtoggle.camerautils.config.Config;
import net.minecraft.entity.player.InventoryPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryPlayer.class)
public class HotbarScrolling {
    @Inject(method = "changeCurrentItem", at = @At("HEAD"), cancellable = true)
    private void cancelScrolling(int direction, CallbackInfo ci) {
        if (Config.keyBind.isActive()) {
            ci.cancel();
        }
    }
}

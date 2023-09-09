package me.imtoggle.camerautils.mixin;

import me.imtoggle.camerautils.CameraUtils;
import me.imtoggle.camerautils.utils.Level;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = {EntityRenderer.class}, priority = 20000)
public abstract class MixinEntityRenderer {
    @Shadow
    private float thirdPersonDistanceTemp;
    @Shadow
    private float thirdPersonDistance;


    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;thirdPersonDistanceTemp:F"))
    public float thirdPersonDistanceTemp(EntityRenderer instance) {
        return CameraUtils.config.enabled ? Level.level() : this.thirdPersonDistanceTemp;
    }

    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;thirdPersonDistance:F"))
    public float thirdPersonDistance(EntityRenderer instance) {
        return CameraUtils.config.enabled ? Level.level() : this.thirdPersonDistance;
    }

}

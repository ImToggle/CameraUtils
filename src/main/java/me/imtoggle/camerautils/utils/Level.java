package me.imtoggle.camerautils.utils;

import cc.polyfrost.oneconfig.events.event.Stage;
import cc.polyfrost.oneconfig.events.event.TickEvent;
import cc.polyfrost.oneconfig.gui.animations.Animation;
import cc.polyfrost.oneconfig.gui.animations.EaseInOutQuad;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import me.imtoggle.camerautils.config.Config;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;

public class Level {

    private static final Minecraft mc = Minecraft.getMinecraft();

    private static Animation animation;

    private static float distanceScrolled;

    public static float finallevel;

    public static float level() {
        int perspective = mc.gameSettings.thirdPersonView;

        if (perspective != 0) {
            if (Config.scroll) {
                if (Config.keyBind.isActive()) {
                    int moved = Mouse.getDWheel();
                    if (moved > 0) {
                        distanceScrolled -= 0.5F;
                    } else if (moved < 0) {
                        distanceScrolled += 0.5F;
                    }
                } else if (Config.back) {
                    distanceScrolled = Config.distance;
                }
            } else {
                distanceScrolled = Config.distance;
            }
        }

        distanceScrolled = Math.max(distanceScrolled, 0);

        if (animation == null || perspective == 0) {
            animation = new EaseInOutQuad(50, 0, 0, false);
        } else {
            animation = new EaseInOutQuad(50, animation.get(), distanceScrolled, false);
        }

        return animation.get();
    }

    @Subscribe
    private void tick(TickEvent e) {
        if (e.stage == Stage.END) {
            finallevel = level();
        }
    }

}

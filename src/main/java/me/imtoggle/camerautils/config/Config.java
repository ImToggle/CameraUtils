package me.imtoggle.camerautils.config;

import cc.polyfrost.oneconfig.config.annotations.KeyBind;
import cc.polyfrost.oneconfig.config.annotations.Slider;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import me.imtoggle.camerautils.CameraUtils;

public class Config extends cc.polyfrost.oneconfig.config.Config {

    @Slider(
            name = "Camera Distance",
            min = 0f, max = 20f,
            step = 1
    )
    public static float distance = 5f;

    @Switch(
            name = "Cam Scrolling"
    )
    public static boolean scroll = false;

    @KeyBind(
            name = "Hold To Scroll"
    )
    public static OneKeyBind keyBind = new OneKeyBind(UKeyboard.KEY_NONE);

    @Switch(
            name = "Back To Previous Distance"
    )
    public static boolean back = false;


    public Config() {
        super(new Mod(CameraUtils.NAME, ModType.UTIL_QOL, "/camera.png"), CameraUtils.MODID + ".json");
        initialize();
    }
}


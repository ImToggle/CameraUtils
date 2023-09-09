package me.imtoggle.camerautils.command;

import me.imtoggle.camerautils.CameraUtils;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

@cc.polyfrost.oneconfig.utils.commands.annotations.Command(value = "camera", description = "Access the " + CameraUtils.NAME + " GUI.")
public class Command {
    @Main
    private void handle() {
        CameraUtils.INSTANCE.config.openGui();
    }
}
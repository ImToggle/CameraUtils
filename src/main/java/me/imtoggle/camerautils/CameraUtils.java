package me.imtoggle.camerautils;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import me.imtoggle.camerautils.command.Command;
import me.imtoggle.camerautils.config.Config;
import me.imtoggle.camerautils.utils.Level;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(modid = CameraUtils.MODID, name = CameraUtils.NAME, version = CameraUtils.VERSION)
public class CameraUtils {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static CameraUtils INSTANCE;
    public static Config config;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new Config();
        CommandManager.INSTANCE.registerCommand(new Command());
        EventManager.INSTANCE.register(new Level());
    }
}

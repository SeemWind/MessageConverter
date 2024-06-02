package com.likewind.me.papiminimessage;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Papi_MiniMessage extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().warning("未安装papi，此插件将无法运作");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        String joinText = "%player_name% joined the server! They are rank %vault_rank%";

        /*
         * We parse the placeholders using "setPlaceholders"
         * This would turn %vault_rank% into the name of the Group, that the
         * joining player has, assuming Vault and the Vault expansion are
         * on the server.
         */
        joinText = PlaceholderAPI.setPlaceholders(event.getPlayer(), joinText);

        event.setJoinMessage(joinText);
    }
}
package me.volcifire.listeners.join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import me.volcifire.listeners.Main;
import me.volcifire.listeners.join.utils.Utils;

public class JoinListener implements Listener {
  
  private Main plugin;
  
  public JoinListener(Main plugin) {
    this.plugin = plugin;
    
    Bukkit.getPluginManager().registerEvents(this, plugin);
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    
    if (!(p.hasPlayedBefore())) {
      // hasn't played before
      Bukkit.broadcastMessage(
          Utils.chat(plugin.getConfig().getString("firstJoin_message").replace("<player>", p.getName()))
      );
    } else {
      // has played before
      Bukkit.broadcastMessage(
          Utils.chat(plugin.getConfig().getString("join_message").replace("<player>", p.getName()))
      );
    }
    
  }
  
  @EventHandler
  public void onJoin(PlayerQuitEvent e) {
    Player p = e.getPlayer();
    
    // leaving server
    Bukkit.broadcastMessage(
        Utils.chat(plugin.getConfig().getString("exit_message").replace("<player>", p.getName()))
    );
    
  }
  
}

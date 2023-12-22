package it.impo.iprinter;

import it.impo.iprinter.command.IPrinterCommand;
import it.impo.iprinter.listener.OnClickBlock;
import it.impo.iprinter.utils.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public class IPrinter extends JavaPlugin {
    public static IPrinter plugin;
    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        this.getCommand("printer").setExecutor(new IPrinterCommand());
        this.getCommand("printer").setTabCompleter(new TabCompleter());
        getServer().getPluginManager().registerEvents(new OnClickBlock(), this);

        this.getLogger().info("[IPrinter] plugin enabled");

    }

    @Override
    public void onDisable() {
        this.getLogger().info("[IPrinter] plugin disabled");
    }
}

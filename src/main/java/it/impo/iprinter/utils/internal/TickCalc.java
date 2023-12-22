package it.impo.iprinter.utils.internal;

import it.impo.iprinter.IPrinter;
public class TickCalc {
    public static int onTick(){
        int seconds = IPrinter.plugin.getConfig().getInt("Settings.time");
        return 20 * seconds;
    }
}

package it.impo.iprinter.utils.internal;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {
    public static String translateHexColorCodes(String message) {
        String hexPattern = "(&#([0-9a-fA-F]{6}))";
        Pattern compiledPattern = Pattern.compile(hexPattern);
        Matcher matcher = compiledPattern.matcher(message);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String hexCode = matcher.group(2);
            String replacement = ChatColor.COLOR_CHAR + "x";
            for (char c : hexCode.toCharArray()) {
                replacement += ChatColor.COLOR_CHAR + "" + c;
            }
            matcher.appendReplacement(buffer, replacement);
        }
        matcher.appendTail(buffer);
        return ChatColor.translateAlternateColorCodes('&', buffer.toString());
    }
}

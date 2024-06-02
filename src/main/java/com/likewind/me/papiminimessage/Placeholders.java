package com.likewind.me.papiminimessage;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Placeholders extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "mmsg";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Like_Wind";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    public static boolean matches(@NotNull String regex,String string) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        return m.matches();
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        // 获取参数，检查用法
        if (matches("md2mini_.*", params)) {

            // 先解析papi占位符
            String var = "%" + params.replaceFirst("md2mini_","") + "%";
            var = PlaceholderAPI.setPlaceholders(player, var);

            // 转换 minedown为 minimessage
            var = new Transformer(var).getGradient();
            return var;
        }
        return null;
    }
}

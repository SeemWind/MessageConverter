package com.likewind.me.MessageConverter;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class Placeholders extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "cmsg";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Like_Wind";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        // 获取参数，检查用法
        if (params.startsWith("md2mini_")) {

            // 先解析 papi 占位符
            String var = "%" + params.replaceFirst("md2mini_","") + "%";
            var = PlaceholderAPI.setPlaceholders(player, var);

            // 转换 minedown为 minimessage
            var = new MdTransformer(var).toMiniGradient();
            return var;
        }
        return null;
    }
}

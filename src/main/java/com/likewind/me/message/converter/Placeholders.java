package com.likewind.me.message.converter;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * @author LikeWind
 */
public class Placeholders extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "minimsgc";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Like_Wind";
    }

    @Override
    public @NotNull String getVersion() {
        return "2.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {

        String p1 = "md2mini_";
        String p2 = "mini2md_";
        // 获取参数，检查用法
        if (params.startsWith(p1)) {

            // 先解析 papi 占位符
            String var = "%" + params.replaceFirst(p1, "") + "%";
            var = PlaceholderAPI.setPlaceholders(player, var);
            // 转换 minedown为 minimessage
            var = new MdTransformer(var).toMini();
            return var;

        } else if (params.startsWith(p2)) {
            String var = "%" + params.replaceFirst(p2, "") + "%";
            var = PlaceholderAPI.setPlaceholders(player, var);

            var = new MiniTransformer(var).toMineDown();
            return var;
        }
        return null;
    }
}

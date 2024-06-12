package com.likewind.me.message.converter;

import de.themoep.minedown.adventure.MineDown;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * @author LikeWind
 */
public class MiniConverter {
    final String input;

    public MiniConverter(String input) {
        this.input = input;
    }

    public String toMineDown() {
        String gradient = this.gradient();
        Component component = MiniMessage.miniMessage().deserialize(gradient);
        // return component.toString();
        return MineDown.stringify(component);
    }

    public String gradient() {

        String returnText = input;
        // minedown 渐变匹配
        Matcher miniMatcher = Util.getMiniMatcher(returnText);
        // hex颜色代码匹配
        // test
        // System.out.println(returnText);

        // 循环替换所有渐变标签
        while (miniMatcher.find()) {
            // 捕获 minedown 渐变文本

            Matcher colorMatcher = Util.getColorMatcher(miniMatcher.group(1));

            // test
            // System.out.println(mineDownMatcher.group(1));

            // 将 hex 颜色代码 存储
            ArrayList<String> colorCode = new ArrayList<>();
            while (colorMatcher.find()) {
                // test
                // System.out.println(colorMatcher.group(1));
                colorCode.add(colorMatcher.group(1));
            }

            // 构建 minedown 字符串
            StringBuilder mdGradient = new StringBuilder("&");

            // 循环添加所有渐变
            for (String code : colorCode) {
                mdGradient.append("-").append(code);
            }
            mdGradient.append("&");
            mdGradient.delete(1, 2);
            returnText = returnText.replaceFirst(Util.getMiniMatcher("").pattern().pattern(), String.valueOf(mdGradient));
        }
        return returnText;

    }
}

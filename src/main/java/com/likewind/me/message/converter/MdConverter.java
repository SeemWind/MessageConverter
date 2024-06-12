package com.likewind.me.message.converter;

import de.themoep.minedown.adventure.MineDown;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.regex.Matcher;


/**
 * @author LikeWind
 */
public class MdConverter {
    final String input;
    final Component component;


    public MdConverter(String input) {
        this.input = input;
        component = new MineDown(input).toComponent();
    }

    // keep
    public String getComponentString() {
        return Util.MINI_MESSAGE.serialize(component);
    }

    // 转换 minedown 渐变颜色
    public String toMini() {
        String string = this.gradientMark();
        MineDown mineDown = new MineDown(string);
        Component component = mineDown.toComponent();
        String s = Util.MINI_MESSAGE.serialize(component);
        return s.replaceAll("(\\$\\\\<gradient:)", "<gradient:");

    }

    // 转换 minedown 渐变颜色
    public String gradientMark() {

        String returnText = input;
        // minedown 渐变匹配
        Matcher mineDownMatcher = Util.getMineDownMatcher(returnText);
        // hex颜色代码匹配
        // test
        // System.out.println(returnText);

        // 循环替换所有渐变标签
        while (mineDownMatcher.find()) {
            // 捕获 minedown 渐变文本

            Matcher colorMatcher = Util.getColorMatcher(mineDownMatcher.group(1));

            // test
            // System.out.println(mineDownMatcher.group(1));

            // 将 hex 颜色代码 存储
            ArrayList<String> colorCode = new ArrayList<>();
            while (colorMatcher.find()) {
                // test
                // System.out.println(colorMatcher.group(1));
                colorCode.add(colorMatcher.group(1));
            }

            // 构建 minimessage 字符串
            StringBuilder miniGradient = new StringBuilder("\\$\\<gradient");

            // 循环添加所有渐变
            for (String code : colorCode) {
                miniGradient.append(":").append(code);
            }
            miniGradient.append(">");

            returnText = returnText.replaceFirst(Util.getMineDownMatcher("").pattern().pattern(), String.valueOf(miniGradient));
        }
        return returnText;

    }

    // todo
    public String toTrGradient() {
        return null;
    }
}

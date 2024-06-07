package com.likewind.me.MessageConverter;

import de.themoep.minedown.adventure.MineDown;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author like_wind
 */
public class MdTransformer {

    // 预编译正则表达式
    private final Pattern md = Pattern.compile("(&#[A-Fa-f0-9]{6}(-#[A-Fa-f0-9]{6})+&)");
    private final Pattern color = Pattern.compile("(#[A-Fa-f0-9]{6})");
    String input;
    MineDown mineDown;
    MiniMessage mm = MiniMessage.miniMessage();
    String miniMessageString;
    Component component;


    public MdTransformer(String string) {
        input = string;
        mineDown = new MineDown(input);
        component = mineDown.toComponent();
    }

    public String getComponentString() {
        return mm.serialize(component);
    }

    // 转换 minedown 渐变颜色
    public String toMini() {
        String string = this.gradientMark();
        MineDown mineDown = new MineDown(string);
        Component component = mineDown.toComponent();
        String s = mm.serialize(component);
        return s .replaceAll("(\\$\\\\<gradient:)", "<gradient:");

    }

    public String transGradient() {
        return null;
    }

    // 转换 minedown 渐变颜色
    public String gradientMark() {

        String returnText = input;
        // minedown 渐变匹配
        Matcher mineDownMatcher = md.matcher(returnText);
        // hex颜色代码匹配
        // test
        // System.out.println(returnText);

        // 循环替换所有渐变标签
        while (mineDownMatcher.find()) {
            // 捕获 minedown 渐变文本

            Matcher colorMatcher = color.matcher(mineDownMatcher.group(1));

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

            // test
            // System.out.println(miniMessage);

            returnText = returnText.replaceFirst(md.pattern(), String.valueOf(miniGradient));
        }
        return returnText;

    }

    // todo
    public String toTrGradient() {
        return null;
    }
}

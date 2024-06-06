package com.likewind.me.MessageConverter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author like_wind
 */
public class MdTransformer {
    // 预编译正则表达式
    private final Pattern mineDown = Pattern.compile("(&#[A-Fa-f0-9]{6}(-#[A-Fa-f0-9]{6})+&)");
    private final Pattern color = Pattern.compile("(#[A-Fa-f0-9]{6})");
    String input;

    public MdTransformer(String string) {
        this.input = string;
    }

    // 转换 minedown 渐变颜色
    public String toMiniGradient() {

        String returnText = input;
        // minedown 渐变匹配
        Matcher mineDownMatcher = mineDown.matcher(returnText);
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
            StringBuilder miniMessage = new StringBuilder("<gradient");
            // 循环添加所有渐变
            for (String code : colorCode) {
                miniMessage.append(":").append(code);
            }
            miniMessage.append(">");

            // test
            // System.out.println(miniMessage);

            returnText = returnText.replaceFirst(mineDown.pattern(), String.valueOf(miniMessage));
        }
        // 替换重置字符
        returnText = returnText.replaceAll("(&r)", "<reset>");
        return returnText;

    }

    // todo
    public String toTrGradient() {
        return null;
    }
}

package com.likewind.me.MessageConverter;

import de.themoep.minedown.adventure.MineDownStringifier;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    private static final Pattern md = Pattern.compile("(&#[A-Fa-f0-9]{6}(-#[A-Fa-f0-9]{6})+&)");
    private static final Pattern color = Pattern.compile("(#[A-Fa-f0-9]{6})");
    private static final Pattern mini = Pattern.compile("(<gradient:#[A-Fa-f0-9]{6}(:#[A-Fa-f0-9]{6})+>)");
    public static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
    public static final MineDownStringifier MINE_DOWN_STRINGIFIER = new MineDownStringifier();

    public static Matcher getMineDownMatcher(String args) {
        return md.matcher(args);
    }

    public static Matcher getColorMatcher(String args) {
        return color.matcher(args);
    }

    public static Matcher getMiniMatcher(String args) {
        return mini.matcher(args);
    }
}

package com.likewind.me.papiminimessage;

public class test {
    public static void main(String args[]) {

        // 按指定模式在字符串查找
        String line = "测试&#233323-#231223-#233335&[测试 测试]&#233323-#231223-#233335&哈哈哈&r";
        Transformer t = new Transformer(line);
        System.out.println(t.getGradient());
    }
}


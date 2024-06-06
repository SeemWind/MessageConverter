package com.likewind.me.MessageConverter.test;

import com.likewind.me.MessageConverter.MdTransformer;

/**
 * @author 14307
 */
public class test {
    public static void main(String[] args) {

        // 按指定模式在字符串查找
        String line = "测试&#111111-#222222-#333333&[测试 测试]&#444444-#555555-#666666&哈哈哈&r";
        MdTransformer t = new MdTransformer(line);
        System.out.println(t.toMiniGradient());
    }
}


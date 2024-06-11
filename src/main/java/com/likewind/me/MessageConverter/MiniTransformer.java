package com.likewind.me.MessageConverter;

import de.themoep.minedown.adventure.MineDown;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class MiniTransformer {
    String input;

    public MiniTransformer(String input) {
        this.input = input;
    }

    public String toMineDown() {
        Component component = MiniMessage.miniMessage().deserialize(input);
        // return component.toString();
        return MineDown.stringify(component);
    }
}

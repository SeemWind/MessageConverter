# Info

a placeholderapi expansion plugin for color code converter to another format

# Plan

* MiniMessage
* TrMenu format (TODO)
* MineDown

# Usage

1. install this plugin in papi expansion
2. /papi reload
3. you can use placeholders now

# Placeholders

For placeholders, the argument must be included at the end of the placeholder separated by an underscore (_).

| Placeholder      | Argument          | Description                                                                                                       |
|------------------|:------------------|-------------------------------------------------------------------------------------------------------------------|
| `%msgc_md2mini%` | other placeholder | convert [MineDown](https://github.com/Phoenix616/MineDown) to [MiniMessage](https://docs.advntr.dev/minimessage/) |
| `%msgc_mini2md%` | other placeholder | convert [MiniMessage](https://docs.advntr.dev/minimessage/) to [MineDown](https://github.com/Phoenix616/MineDown) |

# Examples

if `%luckperms_prefix%` is `&#111111-#222222-#333333&[master]&r`

and `%msgc_md2mini_luckperms_prefix%` will return `<gradient:#111111:#222222:#333333>[master]<reset>`

remember the plugin will not end gradient tag automatically
`<gradient></gradient>`

you need to turn off the strict minimessage mode, and use reset tag `&r` which will be convert to `<reset>`

> [!IMPORTANT] 
> **only support color code fully**, no other functions supported such as keybind

> [!NOTE] 
> $&lt;gradient:xxx:xxx&gt; 
> will be converted to 
> &lt;gradient:xxx:xxx&gt;

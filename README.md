# Info
a placeholderapi expansion plugin for color code converter to other format

# Plan
* minemessage (gradient ok)
* trmenu format 
* minedown (gradient ok)

# Usage
1. install this plugin in papi expansion
2. /papi reload
3. temporarily you can use placeholders

`%cmsg_md2mini_<other placeholder>%`

this could convert [minedown](https://github.com/Phoenix616/MineDown) format gradient to [minimessage](https://docs.advntr.dev/minimessage/) format.

for example:

if `%luckperms_prefix%` is `&#111111-#222222-#333333&[master]&r`

and `%cmsg_md2mini_luckperms_prefix%` will return this `<gradient:#111111:#222222:#333333>[master]<reset>`

remember the plugin will not end the tag automatically 
`<gradient></gradient>`

you need to close the strict minimessage mode, and use &r to set reset tag <reset> 

only this one for now


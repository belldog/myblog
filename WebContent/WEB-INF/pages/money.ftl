<#--<#assign/>定义的变量是有顺序的，页面上只有在定义该变量之后的地方才能用该变量
而<#macro>定义的宏是无顺序的，页面上的任何地方都能使用-->
<#assign L1Menu='money' />
<#include "../templates/base.ftl" />
<#macro PAGE_CONTENT>
<div><img src="<@resources.url />/admin/image/money.jpg"></div>
</#macro>

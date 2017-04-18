<#--<#assign/>定义的变量是有顺序的，页面上只有在定义该变量之后的地方才能用该变量
而<#macro>定义的宏是无顺序的，页面上的任何地方都能使用-->
<#assign L1Menu='belldog' />
<#--这里导入基本的ftl-->
<#include "../templates/base.ftl" />
<#-- 也可以这样写<#include "/templates/base.ftl" ，虽然可以这样写，但是根目录是WebContent,他们中间还有一个WEB-INF目录啊，
难道是因为在FreeMarkerConfigurer配置了templateLoaderPath路径的原因/>  -->

<#macro PAGE_CONTENT>
<div><p>${static.haha}${x}</p></div>
</#macro>
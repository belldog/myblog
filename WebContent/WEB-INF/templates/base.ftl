<#macro L1_MENU_ACTIVE localMenuName paramMenuName>
    <#if localMenuName=paramMenuName> active </#if>
</#macro>
<#macro L1_MENU_HREF localMenuName paramMenuName href>
    <#if localMenuName=paramMenuName>
    #
    <#else>
    ${href}
    </#if>
</#macro>
<!DOCTYPE html>
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>扯蛋</title>
    <link rel="shortcut icon" href="<@resources.url />/admin/favicon.ico">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <meta content="blog" name="description"/>
    <meta content="belldog" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="<@resources.url />/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
<#if PAGE_STYLES?exists><@PAGE_STYLES /></#if>
    <!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
<!-- BEGIN HEADER -->
<div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top" style="opacity: .9" role="navigation">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="<@L1_MENU_ACTIVE 'belldog' L1Menu />"><a
                            href="<@L1_MENU_HREF 'belldog' L1Menu '/belldog.shtml'/>">Blog</a></li>
                    <li class="<@L1_MENU_ACTIVE 'github' L1Menu />"><a
                            href="<@L1_MENU_HREF 'github' L1Menu 'https://github.com/belldog'/>">GitHub</a></li>
                    <li class="<@L1_MENU_ACTIVE 'money' L1Menu />"><a
                            href="<@L1_MENU_HREF 'money' L1Menu '/money.shtml'/>">Money</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- END HEADER -->
<!-- BEGIN CONTENT -->
<#if PAGE_CONTENT?exists><@PAGE_CONTENT /></#if>
<!-- END CONTENT -->
<!-- BEGIN FOOTER -->
<!-- END FOOTER -->
<!-- BEGIN CORE PLUGINS -->
<script src="<@resources.url />/assets/js/jquery.min.js"></script>
<script src="<@resources.url />/assets/js/bootstrap.min.js"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<#if PAGE_PLUGINS?exists><@PAGE_PLUGINS /></#if>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<#if PAGE_SCRIPTS?exists><@PAGE_SCRIPTS /></#if>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN JAVASCRIPTS -->
<script type="text/javascript">
    jQuery(document).ready(function () {
    <#if PAGE_JAVASCRIPTS?exists><@PAGE_JAVASCRIPTS /></#if>
    });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
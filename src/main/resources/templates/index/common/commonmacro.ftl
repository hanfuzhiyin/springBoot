<#macro header tabStr="index">
<!-- header -->
<header>
    <div class="container">
        <div class="header d-lg-flex justify-content-between align-items-center">
            <div class="header-agile">
                <h1>
                    <a class="navbar-brand logo" href="index.html">
                        <span class="fa"></span>${platFormName!"华夏衣裳"}
                    </a>
                </h1>
            </div>
            <div class="nav_w3ls">
                <nav>
                    <label for="drop" class="toggle mt-lg-0 mt-2"><span class="fa fa-bars" aria-hidden="true"></span></label>
                    <input type="checkbox" id="drop" />
                        <ul class="menu">
                            <li class="mr-lg-3 mr-2 <#if tabStr=="index">active</#if>"><a href="index.html">主页</a></li>
                            <li class="mr-lg-3 mr-2 <#if tabStr=="shop">active</#if>"><a href="about.html">店铺推荐</a></li>
                            <li class="mr-lg-3 mr-2 <#if tabStr=="lore">active</#if>"><a href="services.html">汉服知识</a></li>
                            <li class="mr-lg-3 mr-2 <#if tabStr=="friend">active</#if>"><a href="services.html">同袍交友</a></li>
                            <li class="mr-lg-3 mr-2 <#if tabStr=="forum">active</#if>"><a href="services.html">论坛</a></li>
                            <li class="mr-lg-3 mr-2 <#if tabStr=="active">active</#if>"><a href="services.html">活动</a></li>
                            <li class="mr-lg-3 mr-2 p-0">
                            <!-- First Tier Drop Down -->
                            <label for="drop-2" class="toggle">Dropdown <span class="fa fa-angle-down" aria-hidden="true"></span> </label>
                            <a href="#">个人中心 <span class="fa fa-angle-down" aria-hidden="true"></span></a>
                            <input type="checkbox" id="drop-2"/>
                            <ul class="inner-dropdown">
                                <li><a href="#how">我的收藏</a></li>
                                <li><a href="#team">我的好友</a></li>
                                <li><a href="#blog">个人主页</a></li>
                                <li><a href="#stats">个人设置</a></li>
                            </ul>
                            </li>
                        </ul>
                </nav>
            </div>
            <div class="buttons mt-lg-0 mt-2">
                <a href="${domain!}/home/showLoginPage">登录</a>
            </div>

        </div>
    </div>
</header>
<!-- //header -->
</#macro>
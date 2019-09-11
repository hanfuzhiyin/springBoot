<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>同袍激活-${platFormName!"华夏衣裳"}</title>
<meta name="author">
  <link rel="stylesheet" href="/index/css/err/style.css"/>
<link rel="stylesheet" href="/index/css/base.css"/>
 </head>

 <body>
  <div id="errorpage">
    <div class="tfans_error">
        <div class="logo"></div>
        <div class="errortans clearfix">
             <div class="e404"></div>
            <p><b>${userName!}激活成功！</b></p>
            <p>页面将在<span id="sec">5</span>秒后,跳转登录页面</p>
            <div class="bt" ><a href="${domain!}/home/showLoginPage">点击登录</a></div>
        </div>
    </div>
</div>
</body>
<script language="javascript">
    var num = 5; //倒计时的秒数
    var URL = "${domain!}/home/showLoginPage";
    var id = window.setInterval('doUpdate()', 1000);
    function doUpdate() {
        document.getElementById('sec').innerHTML =num;
        if(num == 0) {
            window.clearInterval(id);
            window.location = URL;
        }
        num --;
    }
</script>
</html>

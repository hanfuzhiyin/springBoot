<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>FreeMarker</title>
</head>
<body>
已经登录的用户${userName!}
<form action="/home/registerUser" method="get">
    用户名:<input type="text" name="userName"><span id="error"></span><br>
    密码:<input type="text" name="passWord">
  <input type="submit" value="提交" />
</form>

<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("form input[name='userName']").blur(checkUserName);
        
        function checkUserName(){
           $("#error").text("");
           var name=$(this).val();
           $.ajax({
            type : "POST",
            url : "/home/checkUserName",
            data : {"userName":name},
            success : function(result) {
               if(result.code!=200){
                $("#error").text(result.message);
               }
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                console.log(e.status);
                console.log(e.responseText);
            }
        });
      }   
    });
</script>
</body>
</html>

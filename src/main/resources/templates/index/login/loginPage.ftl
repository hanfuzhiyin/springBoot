<!doctype html>
<html  lang="en">

    <head>
        <!-- meta data -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!--font-family-->
        <link href="/index/css/font.css" rel="stylesheet">
        
        <!-- title of site -->
        <title>同袍登录-${platFormName!"华夏衣裳"}</title>

        <!--font-awesome.min.css-->
        <link rel="stylesheet" href="/index/css/login/font-awesome.min.css">
        
        <!--animate.css-->
        <link rel="stylesheet" href="/index/css/login/animate.css">
        
        <!--bootstrap.min.css-->
        <link rel="stylesheet" href="/index/css/login/bootstrap.min.css">
        
        <!-- bootsnav -->
        <link rel="stylesheet" href="/index/css/login/bootsnav.css" > 
        
        <!--style.css-->
        <link rel="stylesheet" href="/index/css/login/style.css">
        
        <!--responsive.css-->
        <link rel="stylesheet" href="/index/css/login/responsive.css">
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    
    <body>
        <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->
        
        <!-- signin end -->
        <section class="signin">
            <div class="container-fluid">
                <div class="row">

                    <div class="col-sm-4">
                        <div class="single-sign">
                            <div class="sign-bg">
                                
                            </div><!--/.sign-bg -->
                        </div><!--/.single-sign -->
                    </div><!--/.col -->

                    <div class="col-sm-8">
                        <div class="single-sign">
                            <div class="sign-content">
                                <h2>同袍登录</h2>

                                <div class="signin-form">
                                    <div class=" ">
                                        <div class=" ">
                                            <form action="/home/registerUser" method="get">
                                                <div class="form-group">
                                                    <label for="signin_form">用户名</label>
                                                    <input type="email" class="form-control" name="userName" id="signin_form_username" placeholder="请输入你的用户名"><span id="error"></span>
                                                </div><!--/.form-group -->
                                                <div class="form-group">
                                                    <label for="signin_form">密码</label>
                                                    <input type="password" class="form-control" name="passWord" id="signin_form_password" placeholder="请输入你的密码">
                                                </div><!--/.form-group -->
                                            </form><!--/form -->
                                        </div><!--/.col -->
                                    </div><!--/.row -->

                                </div><!--/.signin-form -->
                                <div class="signin-password">
                                    <div class="awesome-checkbox-list">
                                        <ul class="unstyled centered">

                                            <li>
                                                <input class="styled-checkbox" id="styled-checkbox-2" type="checkbox" value="value2">
                                                <label for="styled-checkbox-2">记住我</label>
                                            </li>

                                            <li>
                                                <a href="#">忘记密码</a>
                                            </li>

                                        </ul>
                                    </div><!--/.awesome-checkbox-list -->
                                </div><!--/.signin-password -->

                                <div class="signin-footer">
                                    <button type="button" id="login-user" class="btn signin_btn" data-toggle="modal" data-target=".signin_modal">登录
                                    </button>
                                    <p>还没有账号 ?
                                         <a href="${domain!}/home/showRegisterPage">注册</a>
                                    </p>
                                </div><!--/.signin-footer -->

                            </div><!--/.sign-content -->
                        </div><!--/.single-sign -->
                    </div><!--/.col -->
                </div><!--/.row-->
            </div><!--/.container -->
        </section><!--/.signin -->
        
        <!-- signin end -->

        <!--footer copyright start -->
        <footer class="footer-copyright">
            <div id="scroll-Top">
                <i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
            </div><!--/.scroll-Top-->

        </footer><!--/.hm-footer-copyright-->
        <!--footer copyright  end -->


         <!-- Include all js compiled plugins (below), or include individual files as needed -->

        <script src="/index/js/jquery.js"></script>
        
        <!--modernizr.min.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
        
        <!--bootstrap.min.js-->
        <script src="/index/js/bootstrap.min.js"></script>
        
        <!-- bootsnav js -->
        <script src="/index/js/bootsnav.js"></script>
        
        <!-- jquery.sticky.js -->
        <script src="/index/js/jquery.sticky.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        
        
        <!--Custom JS-->
        <script src="/index/js/custom.js"></script>
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
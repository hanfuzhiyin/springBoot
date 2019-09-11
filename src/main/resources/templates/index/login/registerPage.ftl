
<!doctype html>
<html  lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>同袍注册-${platFormName!"华夏衣裳"}</title>
        <#include "/index/common/common.ftl"> 
    </head>
    <body>
        <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->
        
        <!-- signin end -->
        <section class="signin signup">
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
                                <h2>同袍注册</h2>

                                <div class="signin-form">
                                    <form action="" method="post">
                                        <div class="form-group">
                                            <label for="signin_form">用户名</label>
                                            <input type="email" class="form-control" id="signin_form_username" placeholder="请输入用户名">
                                        </div><!--/.form-group -->
                                        <div class="form-group">
                                            <label for="signin_form">密码</label>
                                            <input type="password" class="form-control" id="signin_form_password" placeholder="请输入密码">
                                        </div><!--/.form-group -->
                                        <div class="form-group">
                                            <label for="signin_form">确认密码</label>
                                            <input type="password" class="form-control" id="signin_form_pwd" placeholder="请确认密码">
                                        </div><!--/.form-group -->
                                        <div class="form-group">
                                            <label for="signin_form">邮箱</label>
                                            <input type="email" class="form-control" id="signin_form_em" placeholder="请输入邮箱，请输入正确的邮箱，用于激活您的账号">
                                        </div>
                                    </form><!--/form -->
                                </div><!--/.signin-form -->
                                <div class="signin-footer">
                                    <button type="button" class="btn signin_btn" data-toggle="modal" data-target=".signin_modal">注册</button>
                                    <p>已有账号 ? <a href="${domain!}/home/showLoginPage">登录</a>
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


        <#include "/index/common/commonjs.ftl"> 
        <!--Custom JS-->
        <script src="/index/js/custom.js"></script>
        <script src="/index/js/login/login.js"></script>
        <script type="text/javascript">
            $(function(){
                register.init();
            });
        </script>
    </body>
    
</html>
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
                                            <form action="signin.html">
                                                <div class="form-group">
                                                    <label for="signin_form">用户名</label>
                                                    <input type="email" class="form-control" id="signin_form_username" placeholder="请输入你的用户名">
                                                </div><!--/.form-group -->
                                                <div class="form-group">
                                                    <label for="signin_form">密码</label>
                                                    <input type="password" class="form-control" id="signin_form_password" placeholder="请输入你的密码">
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
                                                <label for="styled-checkbox-2">Keep me Signed in</label>
                                            </li>

                                            <li>
                                                <a href="#">Forgot email or password ?</a>
                                            </li>

                                        </ul>
                                    </div><!--/.awesome-checkbox-list -->
                                </div><!--/.signin-password -->



                                <div class="signin-footer">
                                    <button type="button" class="btn signin_btn" data-toggle="modal" data-target=".signin_modal">
                                    sign in
                                    </button>
                                    <p>
                                        Don’t have an Account ?
                                         <a href="signup.html">register</a>
                                    </p>
                                </div><!--/.signin-footer -->

                            </div><!--/.sign-content -->

                            <!-- modal part start -->
                            <div class="modal fade signin_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="sign-content">

                                            <div class="modal-header">
                                                <h2>sign in</h2>
                                            </div><!--/.modal-header -->
                                            
                                            <div class="modal-body">
                                                <div class="signin-form">
                                                    <div class=" ">
                                                        <div class=" ">
                                                            <form action="signin.html">
                                                                <div class="form-group">
                                                                    <label for="signin_form">Email</label>
                                                                    <input type="email" class="form-control" id="signin_form" placeholder="info@abc.com">
                                                                </div><!--/.form-group -->
                                                                <div class="form-group">
                                                                    <label for="signin_form">password</label>
                                                                    <input type="password" class="form-control" id="signin_form" placeholder="Password">
                                                                </div><!--/.form-group -->
                                                            </form><!--/form -->
                                                        </div><!--/.col -->
                                                    </div><!--/.row -->

                                                </div><!--/.signin-form -->

                                                <div class="signin-modal-password">
                                                    <div class="awesome-checkbox-list">
                                                        <ul class="unstyled centered">

                                                            <li>
                                                                <input class="styled-checkbox" id="styled-checkbox-3" type="checkbox" value="value3">
                                                                <label for="styled-checkbox-3">Keep me Signed in</label>
                                                            </li>

                                                            <li>
                                                                <a href="#">Forgot email or password ?</a>
                                                            </li>

                                                        </ul>
                                                    </div><!--/.awesome-checkbox-list -->
                                                </div><!--/.signin-modal-password -->


                                                <div class="signin-footer">
                                                    <button type="button" class="btn signin_btn" data-toggle="modal" data-target=".signin_modal">
                                                    sign in
                                                    </button>
                                                    <p>
                                                        Don’t have an Account ? 
                                                        <a href="#">register</a>
                                                    </p>
                                                </div><!--/.signin-footer -->
                                            </div><!--/.modal-body -->

                                        </div><!--/.sign-content -->
                                    </div><!--/.modal-content -->
                                </div><!--/.modal-dialog -->

                            </div><!--/.modal -->
                            <!-- modal part end -->

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

    </body>
    
</html>
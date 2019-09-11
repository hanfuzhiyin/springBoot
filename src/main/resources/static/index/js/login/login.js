(function($, window, document, undefined) {
	var pub = {};
	window.register = pub;
	pub.init = function() {
		bindEvent();
	}

	function bindEvent(){
		 $("form input[name='userName']").blur(checkUserName);
	}
	
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
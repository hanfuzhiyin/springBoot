(function(window, undefined){

	/**
	 * =============================== Sender类：向服务端提交请求或保存数据，包括ajax和iframe两种方式 ===============================
	 */
	window.Sender = {
		submitForm: function(url,params, requestType){
			if (requestType == null){
				requestType = 'get';
			}
		    var form = $("<form method='"+requestType+"'></form>");
		    var input;
		    form.attr({"action":url});
		    $.each(params,function (key,value) {
		        input = $("<input type='hidden'>");
		        input.attr({"name":key});
		        input.val(value);
		        form.append(input);
		    });
		    $(document.body).append(form);
		    form.submit();
		},
		/**
		 * 以post方法进行ajax提交数据，ajax的通用方法，参数params组成如下：
		 * 
		 * @param url  		提交数据的地址，必须·
		 * @param data		提交的数据(json格式或&分隔的key=value串，如：unitId=1&userId)，必须
		 * @param fn 		提交数据成功时返回页面后的回调函数，可以为空
		 * @param dataType 	表示返回数据类型（text,json,jsonp，默认text），可以为空
		 * @param async		是否异步提交，默认同步，可以为空
		 * @param fne		提交数据失败时返回页面后的回调函数，可以为空
		 */
		ajax: function(params) {
			var url = params["url"];
			var data = params["data"];
			var fn = params["fn"];
			var async = params["async"];
			var dataType = params["dataType"];
			var fne = params["fne"];
			
			if (async != undefined && !async){
				async = false;
			}
			$.ajax({
				type: 'post',
				url: url, 
				data: data,
				async: async,
				dataType: dataType || 'text',
				success: function(result){
					Sender.dealResult(result, fn, fne);
				},
				error: function(obj, status){
					Sender.dealResult(obj.responseText, null, fne);
				}
			});
		},
		
		
		/**
		 * 通过ajax异步提交表单，参数params组成如下：
		 * 
		 * @param frm  		提交数据的form表单在jQuery的selector名字（如id=formId的，则传入#formId ）
		 * @param fn 		提交数据返回页面后的回调函数
		 * @param dataType 	表示返回数据类型（text,json,jsonp，默认text）
		 */
		submitAjax: function(params){
			var frm = params["frm"];
			var fn = params["fn"];
			var dataType = params["dataType"];
			
			var url = $(frm).attr("action");
			var serializedata = $(frm).serialize();
			var _dataType;
			if(Validator.isNotEmpty(dataType)){
				_dataType = dataType;
			}else{
				_dataType = "text";
			}
			
			$.post(url, serializedata, function(result){
			  if(!Sender.security(result)){
			    return;
			  }
				fn(result);
			}, dataType);
		},
		
		
		/**
		 * 通过iframe异步提交表单，类似于ajax，即使用iframe实现ajax，params参数如下：
		 * 
		 * @param frm  		提交数据的form表单在jQuery的selector名字（如id=formId的，则传入#formId ）
		 * @param fn 		提交数据返回页面后的回调函数
		 * @param dataType 	表示返回数据类型（text,json,jsonp）
		 */
		submitIframe: function(params){
			var frm = params["frm"];
			var fn = params["fn"];
			var dataType = params["dataType"];
			
			var target = "submit_iframe_" + new Date().getTime();
			$(".submit_iframe").remove();
			var iframe = $('<iframe src="about:blank" id="'+target+'" name="'+target+'" style="display:none" class="submit_iframe"></iframe>');
			$(frm).after(iframe);
			iframe.bind("load", function(){
				var doc = window.frames[target].document;
				var title = doc.getElementsByTagName('title')[0];
				if (title && title.innerHTML) {
					Tips.showErrorMsg("\u7cfb\u7edf\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01");
					return;
				}
				var pre = doc.getElementsByTagName('pre')[0];
				var data = pre ? pre.innerHTML : doc.body.innerHTML;
				if (dataType == 'json') {
					data = $.toJSON(data);
				}
				fn(data);
			});
			$(frm).attr("target", target);
			$(frm).submit();
		},
		
		
		/**
		 * 提交一个form表单，post方式，用返回的结果刷新指定div，适用于多个组合条件查找数据显示列表功能，params参数如下：
		 * 
		 * @param frm		提交数据的form表单在jQuery的selector名字（如id=formId的，则传入#formId ）
		 * @param div		返回数据刷新的div，selector名字
		 * @param url		提交到哪个地址，可以为空，如果为空则取form表单中的action属性
		 */
		submitLoad: function(params){
			var frm = params["frm"];
			var div = params["div"];
			var url = params["url"];
			
			var obj = $(div);
			if(Validator.isEmpty(url)){
				url = $(frm).attr("action");
			}
			var serializedata = $(frm).serialize();
			obj.empty().addClass("loader");
			obj.empty().append("<div style='vertical-align:middle;text-align:center;'><img src='" + 
					Domain.static_path + "/ccstudy/static/assets/images/loading.gif' /></div>");
			$.ajax({
				type:"post",
				url: url,
				data: serializedata,
				error:function(){
					obj.empty().remove("loader");
					var msg = "<div style='vertical-align:middle;text-align:center;'>加载失败，请<a href='javascript:void();' " +
							  "onclick=\"javascript:Sender.submitLoad({'frm':'"+frm+"','div':'"+div+"','url':'"+url+"'})\">" +
							  "重新刷新</a></div>";
					obj.empty().append(msg);
				},
				success:function(data){
					obj.empty().remove("loader");
					obj.empty().append(data);
				}
			});
		},
		
		/**
		 * 在div中显示url请求返回的页面，以get方式提交请求（多用于页面中某一div），params参数如下：
		 * 
		 * @param id  载入数据的div在jQuery的selector名字（如id=divId的，则传入#divId ），必须
		 * @param url 载入数据地址，必须
		 * @param fn  载入数据之后的回调函数  非必须
		 */
		load: function(params){
			var div = params["div"];
			var url = params["url"];
			var fn  = params["fn"];
			var obj = $(div);
			obj.empty().addClass("loader").attr("url", url);
			obj.empty().append("<div style='vertical-align:middle;text-align:center;'><img src='" + 
					Domain.static_path + "/ccstudy/static/assets/images/loading.gif' /></div>");
			
			$.ajax({
				type:"GET",
				contentType:"application/x-www-form-urlencoded;charset=UTF-8",  
				url:url,
				
				error:function(){
					obj.empty().remove("loader");
					var msg = "<div style='vertical-align:middle;text-align:center;'>加载失败，" +
							  "请<a href='javascript:void();' onclick=\"javascript:Sender.load({'div':'"+div+"','url':'"+url+"'})\">" +
							  "重新刷新</a></div>";
					obj.empty().append(msg);
				},
				success:function(data){
					obj.empty().remove("loader");
					if (obj.attr("url") == url){
						obj.empty().append(data);	
					}
					if(fn!=undefined&&fn!=null){
						fn();
					}
				}
			});
		},
		
		
		/**
		 * 打开div弹出窗口，并显示url请求的页面（用于在当前页面打开一个弹出层，在弹出层中加载url请求页面），会调用Sender.toLoad，params参数如下：
		 * 
		 * @param div			显示的DIV在jQuery的selector名字，如id=divId的，则传入#divId，不能空
		 * @param closeObject	关闭的控件在jQuery的selector名字，如id=closeBut的，则传入#closeBut，可以空
		 * @param url			加载的url 可以空
		 * @param scroll		是否需要滚动
		 * @param className		内部的className 如果需要设置滚动 则必须填写
		 * @param height		内部的高度超过此高度则需要 否则不需要
		 * @param urlLoadedHandler	url加载完毕后的回调函数
		 * @param closeHandler		弹出窗口关闭后的回调函数
		 */
		openDiv: function(params) {
			var div = params["div"];
			var closeObject = params["closeObject"];
			var url = params["url"];
			var scroll = params["scroll"];
			var className = params["className"];
			var height = params["height"];
			var urlLoadedHandler = params["urlLoadedHandler"];
			var closeHandler = params["closeHandler"];
			
			if(url){
				var params1 ={
						"loadObject":div,
						"url":url,
						"endHandler":function() {
							var params2 ={
									"div":div,
									"closeObject":closeObject,
									"scroll":scroll,
									"className":className,
									"height":height,
									"closeHandler":closeHandler
							};
							Box.showDiv(params2);
							
							if (urlLoadedHandler) {
								if (urlLoadedHandler instanceof Function) {
									eval(urlLoadedHandler)();
								} else {
									eval(urlLoadedHandler);
								}
							}
						}
				};
				
				Sender.toLoad(params1);
			}else{
				var params2 ={
						"div":div,
						"closeObject":closeObject,
						"scroll":scroll,
						"className":className,
						"height":height,
						"closeHandler":closeHandler
				};
				Box.showDiv(params2);
			}
		},
		
		
		/**
		 * 在div中显示url请求返回的页面（多用于弹出层div，被openDiv调用），params参数如下：
		 * 
		 * @param loadObject	显示的DIV在jQuery的selector名字，如id=openDiv的，则传入 #openDiv 不能空
		 * @param url 			加载的url 可以空
		 * @param endHandler	加载后回调函数
		 * @param beforeHandle	加载前回调函数
		 * @param noLoadTip		是否显示加载数据中 否则显示
		 * @param data			提交的数据
		 * @return
		 */
		toLoad: function(params) {
			var loadObject = params["loadObject"];
			var url = params["url"];
			var endHandler = params["endHandler"];
			var beforeHandle = params["beforeHandle"];
			var noLoadTip = params["noLoadTip"];
			var data = params["data"];
			
			var length = url.length;
			var u = "";
			for (i = 0; i < length; i++) {
				var v = url.substring(i, i + 1);
				if (url.charCodeAt(i) > 255) {
					u += encodeURI(v);
				} else {
					u += v;
				}
			}
			url = u;
			if (beforeHandle && beforeHandle != "") {
				if (beforeHandle instanceof Function) {
					eval(beforeHandle)();
				} else {
					eval(beforeHandle);
				}
			} else {
				if (!noLoadTip) {
					noLoadTip = false;
				}
				if (!noLoadTip) {
					var padding = $(loadObject).height();
					$(loadObject)
							.html("<table height='" 
									+ padding
									+ "' width='100%'><tr><td width='50%' align='right'><img src='"
									+ Domain.static_path
									+ "/ccstudy/static/assets/images/loading.gif' />" 
									+ "</td><td width='50%' align='left'><span>&nbsp;正在加载数据……</span></td></tr></table>");
				}
			}
			
			// 调用jquery中div的load扩展方法
			$(loadObject).load(url, data, function(response, status, xhr) {
				var sessionstatus = xhr.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
				if (sessionstatus == "timeout") { // 如果超时就处理 ，指定要跳转的页面
					top.location.href = Domain.domain_path
							+ "/login.action";
				}
				if (endHandler && endHandler != "") {
					if (endHandler instanceof Function) {
						eval(endHandler)();
					} else {
						eval(endHandler);
					}
				}
			});

		},
		
		/**
		 * 获取url返回的json数据，data表示get方式提交的数据，params参数如下：
		 * 
		 * @param url		请求的url
		 * @param data		提交的数据
		 * @param handler	请求后回调函数
		 */
		getJsonByUrl: function(params) {
			var url = params["url"];
			var data = params["data"];
			var handler = params["handler"];
			
			$.getJSON(url, data, function(data, textStatus, xhr) {
				var sessionstatus = xhr.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
				if (sessionstatus == "timeout") { // 如果超时就处理 ，指定要跳转的页面
					top.location.href = Domain.domain_path
							+ "/login.action";
				}
				if (handler && handler != "") {
					if (handler instanceof Function) {
						eval(handler)(data);
					} else {
						eval(handler);
					}
				}
			});
		},
		
		/**
		 * 将form表单中的内容封装成json（不包含file input）
		 * 
		 * @param obj
		 */
		getJsonByForm: function(obj) {
			var data = obj.serializeArray();
	        return JSON.stringify(data);
		},
		
		/**
		 * 处理ajax提交返回的结果，被obj.onAjax、Sender.ajax等方法调用
		 * 
		 * result：返回的结果数据
		 * fn：成功时执行的函数
		 * fne：失败时执行的函数
		 */
		dealResult: function(result, fn, fne) {
			switch (result) {
				case "TIME_OUT":
					if (fne) {
						fne();
					}
					break;
				case "PES_ERROR":
					if (fne) {
						fne();
					}
					Tips.showErrorMsg("\u7cfb\u7edf\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01");
					break;
				case "SYS_ERROR":
					if (fne) {
						fne();
					}
					Tips.showErrorMsg("\u7cfb\u7edf\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01");
					break;
				default:
					if(!Sender.security(result)){
						return;
					}
					if (fn) {
						fn(result);
					} 
				break;
			}
		},
		
		// 安全性验证不通过后，前端信息提示方式，被Sender.dealResult、Sender.submitAjax等方法调用
		security: function(result){
			if(typeof result === "string" && result.indexOf("NO_SECURITY") != -1){
				var temp = result.substring(11);
				var cont = StringUtil.encodeForHTML(temp);
				Tips.showAlertWin("你提交的内容中可能包含不安全内容：【" + cont + "】");
				return false;
			}
			return true;
		},
		
		// 对提交的内容在前端做安全验证
		isNotSecurity: function(val){
			var result = /[&;%\'\"<>]|[\s\S]*javascript\:[\s\S]*|[\s\S]*(window\.)?document\.[\s\S]*|[\s\S]*eval\([\s\S]*\)[\s\S]*/.test(val);
			if (result){
				Tips.showAlertWin("你提交的内容中可能包含不安全内容：【" + StringUtil.encodeForHTML(val) + "】！");
			}
			return result;
		}
		
	};
	
	
	
	
})
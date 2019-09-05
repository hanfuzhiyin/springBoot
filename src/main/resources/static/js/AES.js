(function(window, undefined){
	window.AES = {
		encrypt : function(params){
			var encrypt = CryptoJS.AES.encrypt(params, CryptoJS.enc.Utf8.parse(aseKey), {
			  mode: CryptoJS.mode.ECB,
			  padding: CryptoJS.pad.Pkcs7
			}).toString();
			return encrypt;
		},
		decrypt : function (params){
			var decrypt = CryptoJS.AES.decrypt(params, CryptoJS.enc.Utf8.parse(aseKey), {
			  mode: CryptoJS.mode.ECB,
			  padding: CryptoJS.pad.Pkcs7
			}).toString(CryptoJS.enc.Utf8);
			return decrypt;
		}
	};
})(window);
function login() {
	$("#errorInfo").html("");
	var userName = $("#userName").val();
	if (userName == null || userName.trim().length == 0) {
		$("#errorInfo").html("请输入用户名");
		return;
	}
	var userPwd = $("#userPwd").val();
	if (userPwd == null || userPwd.trim().length == 0) {
		$("#errorInfo").html("请输入密码");
		return;
	}
	var verifyCode = $("#verifyCode").val();
	var remember = $("input[name='remember']").val();
	$.ajax({
		url : 'login',
		data : {
			'userName' : userName,
			'userPwd' : userPwd,
			'verifyCode' : verifyCode,
			'remember' : remember
		},
		dataType : 'json',
		success : function(resp) {
			if (resp.code == 200) { // 成功
				window.location.href = "main.jsp";
			} else {
				alert(resp.msg);
			}
		},
		error : function() {
			console.error("请求错误");
		}

	});
}

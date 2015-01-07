<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>基于SSH的在线考试系统首页</title>
<link href="style/scojs.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="style/login_style.css" /><link type="text/css" rel="stylesheet" href="style/login_reset.css" /><script src="js/jquery-1.9.1.js"></script><script src="js/jquery.form.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body class="bg">
<!----------login部分----------------------------------->
 <form id="loginform" name="loginform" action="login" method="post">
<div class="log">
<div class="wrapper">
<div class="login_bg_oes">
    <div class="login corner">
       <div class="login_title">
            <h3 class="login_title_1">登&nbsp;录</h3>
       </div>
       <div class="loginbox">    
          <div class="conbox">
              <span class="boxname">账号:</span>
              <div class="l_username corner">
                   <input name="username" id="username" type="text" placeholder="请输入账号">
              </div> 
          </div>
          <div class="conbox">
              <span class="boxname">密码:</span> 
              <div class="l_password corner">
                   <input name="password" id="password" type="password" placeholder="请输入密码">
              </div>
          </div>
          <div></div><!--虽然我是空的div 但是删除了我，在ie6下，你就不好用 呵呵呵---->
          <div id="captchaDl" class="conbox" style="display:none;">
              <span class="boxname">验证码</span>
              <div class="captchaDl">
              </div>
          </div>
          <div class="conbox_autoLogin">
              <div class="l_autoLogin">教师：<input type="radio" name="identity" value="2" checked="checked">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生：<input type="radio" name="identity" value="1"></div>
                        </div>
                 
          <div class="conbox">
              <div class="boxname"></div>
              <a href="javascript:LoginAjax();" id="login" class="l_enter corner" alt="登录按钮">登&nbsp;&nbsp;录</a>
              <a href="javascript:document.loginform.reset();" id="reset" class="l_enter corner" alt="重置按钮" style="margin-left:90px;margin-top:10px;">重&nbsp;&nbsp;置</a>
          </div>
          <div></div><!--虽然我是空的div 但是删除了我，在ie6下，你就不好用 呵呵呵---->
          <div class="l_hint" >
             <div id="error" class="l_wrong" style="display:;"></div>
          </div>
       </div>
    </div>
</div>
</div>
</div>
       </form>
<script type="text/javascript" language="javascript">
  function LoginAjax(){
  var username = $("#username").val();
  var password = $("#password").val();
  var type = $('input[name=identity]:checked').val();
  var errortip;
  if(username==""||password==""){
    errortip="账号、密码不能为空!";
    $.scojs_message(errortip, $.scojs_message.TYPE_ERROR);
     return false;
  }else{
  //$.post("excuteAjaxloginAction",
  $.post("login",
    {
      username: $("#username").val(),
      password: $("#password").val(),
      identity: $('input[name=identity]:checked').val()
    },
    function(data,status){
      //alert("Data: " + data + "\nStatus: " + status);
      if(data=="iderror"){
         errortip="该账号不存在！";
         $.scojs_message(errortip, $.scojs_message.TYPE_ERROR);
     return false;
     }else if(data=="pwderror"){
         errortip="密码错误！";
         $.scojs_message(errortip, $.scojs_message.TYPE_ERROR);
     return false;
     }
     $.scojs_message('登陆成功！跳转中……', $.scojs_message.TYPE_OK);
     setTimeout("$('#loginform').submit()", 5000);
    });
  }
  }
</script>
<script src="js/sco.message.js"></script>
	 <script src="js/sco.tooltip.js"></script>
       </body></html>
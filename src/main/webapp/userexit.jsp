
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>滴答办公系统-修改个人密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/media/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/media/js/jquery.min.js"></script>
    <script type="text/javascript" src="/media/js/jquery.validate.js"></script>
    <script src="/media/layui/layui.js"></script>

</head>
<body>
<div class="layui-container" style="margin-top: 5px">
    <form class="layui-form"  onsubmit="return false;">
        <div class="layui-form-item">
            <label class="layui-form-label">原始密码</label>
            <div class="layui-input-block">
                <input type="text" name="password" id="password" lay-verify="name" autocomplete="off"
                       placeholder="请输入密码" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input type="text" name="newpass"id="newpass" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认新密码</label>
            <div class="layui-input-block">
                <input type="text"name="renewpass"id="renewpass"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <input class="layui-btn"  style="margin-left: 10%" type="submit" value="确认修改">
        </div>
    </form>
</div>

</body>

<script>
    $(function () {
        $("form").validate({
            submitHandler:function () {
                $.ajax({
                    type:"post",
                    url:"user/editpass.do" + window.location.search,
                    dataType:"json",
                    data:$("form").serialize(),
                    success:function (data) {
                        if (data.code==1){
                            alert(data.info)
                            top.location.href="login.html"
                        }else{
                            alert(data.info)
                        }
                    }
                })
            },
            rules:{
                password:{
                    required:true,
                    minlength:6,
                    maxlength:12

                },
                newpass:{
                    required:true,
                    minlength:6,
                    maxlength:12
                },
                renewpass:{
                    required:true,
                    minlength:6,
                    maxlength:12,
                    equalTo:"#newpass"
                }
            },
            messages:{
                password:{
                    required:"请将表单填写完整",
                    minlength:"密码最少6位数字",
                    maxlength:"密码最多12位数字",

                },
                newpass:{
                    required:"请将表单填写完整",
                    minlength:"密码最少6位数字",
                    maxlength:"密码最多12位数字",
                },
                renewpass:{
                    required:"请将表单填写完整",
                    minlength:"密码最少6位数字",
                    maxlength:"密码最多12位数字",
                    equalTo:"两次输入的新密码不一致"
                }
            }
        })
    })
</script>
</html>
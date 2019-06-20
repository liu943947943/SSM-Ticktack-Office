
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>滴答办公系统-我的信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/media/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/media/js/jquery.min.js"></script>
    <script src="/media/layui/layui.js"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
    <script>
        var form;
        layui.use(
                [ 'form','upload', 'layedit', 'laydate' ],
                function() {
                    form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
                    var upload = layui.upload;
                    //日期
                    laydate.render({
                        elem : '#date1'
                    });
                    laydate.render({
                        elem : '#date2'
                    });
                    initData();
                });
    </script>
</head>
<body>
<div class="layui-container" style="margin-top: 5px">
    <form class="layui-form" action="studentadd.do" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <div class="layui-form-mid layui-word-aux">${user.name}</div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">头像</label>
            <div class="layui-input-block">
                <div class="layui-form-mid layui-word-aux">
                    <img src="${user.userPic.path}" style="width: 60px;height: 60px" />
                </div>
            </div>
        </div>
      <!--  <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px;">上次登录时间</label>
            <div class="layui-input-inline">
                <div class="layui-form-mid layui-word-aux">2019-06-17 15:42:58</div>
            </div>
        </div>-->
        <div class="layui-form-item">
            <label class="layui-form-label">权限</label>
            <div class="layui-input-inline">
                <div class="layui-form-mid layui-word-aux">${user. userRole.info}</div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
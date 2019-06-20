
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    /*获取工程路径*/
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
        function edit(id) {
            $.ajax({
                url:"<%=basePath%>pos/selectPosById",
                type:"post",
                dataType:"json",
                data:{id:id},
                success:function (data) {
                    $("#editModal").modal("show");
                    $("#posName").val(data.posName);
                    $("#myid").val(data.id);
                    $("#imgs").attr("src",(data['shopPic'])['path']);
                },
                error:function () {
                    alert("获取用户数据失败！");
                }
            });
        }
    </script>
</head>
<body>
<div class="layui-container" style="margin-top: 5px">
    <form class="layui-form"id="myid" name="myid"  enctype="multipart/form-data" action="<%=basePath%>user/exitUser.do/${user.id}" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <div class="layui-form-mid layui-word-aux">${user.name}</div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">照片</label>
            <label for="inputfile">头像上传</label>
            <input type="file" name="file" id="inputfile">
        </div>
        <div class="layui-form-item">
            <input class="layui-btn"  style="margin-left: 10%" type="submit"  value="确认修改">
        </div>
    </form>
</div>
</body>
</html>
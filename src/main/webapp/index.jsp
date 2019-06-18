<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>滴答办公系统-主页</title>
    <link rel="stylesheet" href="media/layui/css/layui.css" media="all">
    <!-- <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css"> -->
    <link rel="stylesheet" href="media/css/app.css" media="all">
    <link rel="stylesheet" href="media/css/font-awesome.min.css">
    <style type="text/css">
        iframe{
            width: 98%;
            height: 98%;
        }
        .layui-tab-item{
            height: 98%;
        }
    </style>
</head>

<body>
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <img src="media/images/qf_logo.png" style="margin-right: 10px" /><span
                style="font-size: 22px">滴答办公系统</span>
        </div>

        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item kit-side-fold" lay-unselect >
                <a href="javascript:flexible();" title="侧边伸缩">
                    <i class="layui-icon layui-icon-shrink-right" id="LAY_flexible"></i>
                </a>

            </li>
            <li class="layui-nav-item" lay-unselect>
                <a href="index.jsp" layadmin-event="refresh" title="刷新">
                    <i class="layui-icon layui-icon-refresh-3"></i>
                </a>
            </li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item" style="margin-right: 20px">
                <a href="javascript:showTab(1001,'processlist.html','待办事项');">待办事项<span class="layui-badge">99+</span></a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                  <img src="media/images/22.jpg" class="layui-nav-img">
                    ${user.name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:showTab(1001,'userinfo.jsp','我的信息');">我的信息</a></dd><%--
                    <dd><a href="javascript:showTab(1001,'staffupdate.html','更改头像');">更改头像</a></dd>--%>
                    <dd><a href="javascript:showTab(1002,'userexit.jsp?id=${user.id}','修改密码');">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="javascript:logout()">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black ">
        <div class="layui-side-scroll">

            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-shrink="all" id="lm">
                <li class="layui-nav-item">

                    <a href="javascript:;" id="1"><i class="fa fa-shield"></i>&nbsp;权限管理</a>

                    <dl class="layui-nav-child">

                        <dd><a href="javascript:;" id="2" onclick="showTab(1,'/role/list/1','角色管理')">&nbsp;&nbsp;&nbsp;&nbsp;角色管理</a></dd>

                        <dd><a href="javascript:;" id="2\" onclick="showTab(1,'/menu/list/1','菜单管理')">&nbsp;&nbsp;&nbsp;&nbsp;菜单管理</a></dd>

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/user/list/1','用户管理')">&nbsp;&nbsp;&nbsp;&nbsp;用户管理</a></dd>

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/user/list/1','用户管理')">&nbsp;&nbsp;&nbsp;&nbsp;用户管理</a></dd>

                    </dl>
                </li>

                <li class="layui-nav-item">

                    <a href="javascript:;" id=""><i class="fa fa-shield"></i>&nbsp;权限管理</a>

                    <dl class="layui-nav-child">

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/role/list/1','角色管理')">&nbsp;&nbsp;&nbsp;&nbsp;角色管理</a></dd>

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/menu/list/1','菜单管理')">&nbsp;&nbsp;&nbsp;&nbsp;菜单管理</a></dd>

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/user/list/1','用户管理')">&nbsp;&nbsp;&nbsp;&nbsp;用户管理</a></dd>

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/user/list/1','用户管理')">&nbsp;&nbsp;&nbsp;&nbsp;用户管理</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item">

                    <a href="javascript:;" id=""><i class="fa fa-sitemap"></i>&nbsp;部门管理</a>
                    <dl class="layui-nav-child">

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/depart/list/1','部门列表')">&nbsp;&nbsp;&nbsp;&nbsp;部门列表</a></dd>

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/departadd.jsp','部门新增')">&nbsp;&nbsp;&nbsp;&nbsp;部门新增</a></dd>

                    </dl>
                </li>
                <li class="layui-nav-item">

                    <a href="javascript:;" id=""><i class="layui-icon layui-icon-user"></i>&nbsp;员工管理</a>

                    <dl class="layui-nav-child">

                        <dd><a href="javascript:;" id="" onclick="showTab(1,'/emp/list/1','员工列表')">&nbsp;&nbsp;&nbsp;&nbsp;员工列表</a></dd>

                        <dd><a href="javascript:;" id= onclick="showTab(1,'/empadd.jsp','员工新增')">&nbsp;&nbsp;&nbsp;&nbsp;员工新增</a></dd>

                    </dl>
                </li>

                <li class="layui-nav-item">

                    <a href="javascript:;" id=><i class="fa fa-graduation-cap"></i>&nbsp;专业管理</a>

                    <dl class="layui-nav-child">

                        <dd><a href="javascript:;" id= onclick="showTab(1,'/courseadd.jsp','专业新增')">&nbsp;&nbsp;&nbsp;&nbsp;专业新增</a></dd>

                        <dd><a href="javascript:;" id= onclick="showTab(1,'/course/list/1','专业列表')">&nbsp;&nbsp;&nbsp;&nbsp;专业列表</a></dd>

                    </dl>
                </li>

                <li class="layui-nav-item">

                    <a href="javascript:;" id=><i class="fa fa-cube"></i>&nbsp;班级管理</a>

                    <dl class="layui-nav-child">

                        <dd><a href="javascript:;"  onclick="showTab(1,'/gradeadd.html','班级新增')">&nbsp;&nbsp;&nbsp;&nbsp;班级新增</a></dd>

                        <dd><a href="javascript:;" onclick="showTab(1,'/gradepage.jsp','班级列表')">&nbsp;&nbsp;&nbsp;&nbsp;班级列表</a></dd>

                    </dl>
                </li>

                <li class="layui-nav-item">

                    <a href="javascript:;"><i class="fa fa-user-secret"></i>&nbsp;学员管理</a>

                    <dl class="layui-nav-child">

                        <dd><a href="javascript:;" onclick="showTab(1,'/student/goinsert','学员新增')">&nbsp;&nbsp;&nbsp;&nbsp;学员新增</a></dd>

                        <dd><a href="javascript:;" onclick="showTab(1,'/student/goImport','学员导入')">&nbsp;&nbsp;&nbsp;&nbsp;学员导入</a></dd>

                        <dd><a href="javascript:;"  onclick="showTab(1,'/student/list/1','学员列表')">&nbsp;&nbsp;&nbsp;&nbsp;学员列表</a></dd>

                    </dl>
                </li>

            </ul>
        </div>
    </div>
    <div class="layui-body" id="container" >
        <!-- 内容主体区域 -->
        <div class="layui-tab" lay-filter="demo" style="width: 100%;height: 90%">
            <ul class="layui-tab-title"></ul>
            <div class="layui-tab-content" style="width: 99%;height: 98%"></div>
        </div>
    </div>

    <div class="layui-footer">
        <p>
            Copyright 2011-2018 <a href="http://www.1000phone.com/"
                                   rel="nofollow" target="_blank" title="千锋互联">北京滴答科技有限公司 Feri
            版权所有</a> 京ICP备12003911号-3 京公网安备11010802011455号
        </p>
    </div>
</div>

<script src="media/js/jquery.min.js"></script>
<script src="media/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    var element;
    layui.config({
        base: 'media/layui/lay/modules/'
    }).use(['element','app'], function(){
        element = layui.element;
        $.get("/usermenu.do",null,function (arr) {
            var s;
            for(i=0;i<arr.length;i++){
                var parent=arr[i];
                s+="<li class='layui-nav-item '> <a href='javascript:;' id='"+parent.id+"'><i class=\"fa "+parent.icon+"\"></i>&nbsp;"+parent.title+"</a>";
                if(parent.childs.length>0){
                    s+="<dl class='layui-nav-child'>";
                    for(j=0;j<parent.childs.length;j++){
                        var child=parent.childs[j];
                        s+="<dd><a href='javascript:;' id='"+child.id+"' onclick='showTab("+child.id+",\""+child.aurl+"\",\""+child.title+"\")'>&nbsp;&nbsp;&nbsp;&nbsp;"+child.title+"</a></dd>";
                    }
                    s+="</dl>";
                }
                s+="</li>";
            }
            $("#lm").append(s);
            element.render();
        });
        showTab(20000,"main.html","首页");
    });
    var tid=-1;
    function showTab(id,u,n) {
        if(tid>0){
            element.tabDelete('demo',tid);
        }
        element.tabAdd('demo', {
            title:n
            ,content: '<iframe data-frameid="'+id+'" scrolling="auto" frameborder="0" src="'+u+'"></iframe>' //支持传入html
            ,id:id
        });
        element.tabChange('demo', id);
        element.render();
        tid=id;
    }

    function logout(){
        $.ajax({
            type:"get",
            url:"user/logout.do",
            success:function(data){
                if(data.code == 1){
                    window.location.href = "login.html";
                }else{
                    alert(data.info);
                }
            }
        })
    }

</script>
<script type="text/javascript">


</script>
</body>

</html>
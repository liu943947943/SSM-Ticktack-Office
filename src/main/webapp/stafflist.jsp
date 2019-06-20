<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>滴答办公系统-员工列表</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="media/layui/css/layui.css" media="all">
	<script src="media/js/jquery.min.js"></script>
</head>
<body>
<div class="layui-col-md16">
	<table id="tbdata" lay-filter="tbop"></table>
	<script type="text/html" id="barop">
		<a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
	</script>
</div>
<script src="media/js/jquery.form.min.js"></script>
<script src="media/layui/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
	layui.use('table', function(){
		var table = layui.table;

		//第一个实例
		table.render({
			elem: '#tbdata'
			,url: '/staff/stafflist.do' //数据接口
			,page: true //开启分页
			,cols: [[ //表头
				{field: 'no', title: '工号', sort: true, fixed: 'left'}
				,{field: 'name', title: '员工名称'}
				,{field: 'depart', title: '所属部门'}
				,{field: 'sex', title: '性别'}
				,{field: 'phone', title: '手机号'}
				,{field: 'qq', title: 'qq号'}
				,{field: 'email', title: '邮箱'}
				,{field: 'createdate', title: '入职日期'}
				,{field:'right', title: '操作',toolbar:"#barop"}
			]]
			,page: true   //开启分页
			,limit:10   //默认十条数据一页
			,limits:[10,20,30,50]  //数据分页条
			,id: 'testReload'
		});
		//监听工具条
		table.on('tool(tbop)', function(obj){
			var data = obj.data;
			if(obj.event === 'del'){
				layer.confirm('是否确认删除员工?', function(index){
					$.ajax({
						url: "/staff/staffdelete.do",
						type: "POST",
						data:{"no":data.no,"depart":data.depart},
						success: function(data){
							if(data.code==1){
								layer.close(index);
								layer.msg("删除成功", {icon: 6});
								window.location.href="stafflist.jsp"
							}else{
								layer.msg("删除失败", {icon: 5});
							}
						}
					});
				});
			} else if(obj.event === 'edit'){//编辑 修改
				//location.href="staffupdate.html?d="+ encodeURI(JSON.stringify(data));
				//点击编辑 》》》弹出框的设置 及ajax
				layer.open({
					area: ['500px', '400px'],
					title: '员工修改',
					type: 2,
					fixed:false,
					maxmin:true,
					content: "staffupdate.html?id="+data.no,//这里content是一个普通的String
					btn: ['确认', '取消'],
					yes: function(index, layero){
						var body = layer.getChildFrame('body', index);
						// var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
						$.ajax({
							url: "/staff/staffedit.do",
							data: body.find("form").serialize(),
							success: function (obj) {
								if (obj.code == 1) {
									layer.msg("编辑成功");
									table.reload("tbdata");
									window.location.href="stafflist.jsp"
								} else {
									layer.msg("编辑失败");
								}
							}
						})

						/*  body.find("form").submit(function(){
						 //图片的异步上传
						 //jquery.form中提供的操作
						 body.find("form").ajaxSubmit({
						 type:"post",
						 url:"/tick/staffedit.do",
						 dataType:"json",
						 success:function(data){
						 if(data.code == 1){
						 layer.msg("编辑成功");
						 table.reload("tbdata");
						 }else{
						 layer.msg("编辑失败");
						 }
						 }
						 })
						 }) */
						layer.close(index);
					},cancel: function(){
					}
				});
			}
		});
	});

</script>
</body>
</html>
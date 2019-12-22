
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/boostrap/favicon.ico">
    <link href="${pageContext.request.contextPath}/boostrap/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap-table/1.9.1/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/bootstrap-editable/css/bootstrap-editable.css" rel="stylesheet" type="text/css" /><!--bootstrap3-editable 插件样式-->
</head>
<body>
</div>
<div id="searHead">
    <div style="float: right;width: 550px;height: 100%;">
        <span>渠道类型</span> <input placeholder="请输入" style="margin-left: 20px" name="i_type" id="serach_input">
        <button onmouseover="this.style.backgroundColor='rgba(64,144,114,1)'; " onmouseout="this.style.backgroundColor='rgba(72,160,127,1)'" style="background-color: rgba(72,160,127,1); width: 100px;height: 30px;color: white;border-style: none;margin-left: 15px;border-radius: 4px;outline: none" onclick="search()">搜索</button>
        <button onmouseover="this.style.backgroundColor='orange';"  onmouseout="this.style.backgroundColor='rgba(226,137,29,1)'"  style="background-color: orange; width: 100px;height: 30px;color: white;border-style: none;margin-left: 15px;border-radius: 4px;outline: none"  onclick="addVersion()">+ 新增</button>
    </div>
</div>
<div  style="width: 100%;margin-top: 0px; height: 400px;">
    <table id="table">

    </table>
</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form id="Formdata">
        <div class="modal-dialog" id="modal_dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        新增版本
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="div_line">
                        <span style="color: red">*</span>
                        <span style="font-size: 15px">是否强制更新</span>
                         <select class="form-control m-b" name="i_isforceupdate" id="i_isforceupdate"  style="width: 120px;height: 30px;display: inline-block;margin-left: 20px">
                            <option value="">--请选择--</option>
                            <option value="001">是</option>
                            <option value="002">否</option>
                        </select>
                        <span style="color: red;margin-left: 20px">*</span>
                        <span style="font-size: 15px;">渠道类型</span>
                        <select class="form-control m-b" id="i_type" name="i_type"  style="width: 120px;height: 30px;display: inline-block;margin-left: 20px" >
                            <option value="">--请选择--</option>
                            <option value="IOS">IOS</option>
                            <option value="ANDROID">ANDROID</option>
                        </select>
                    </div>

                    <p style="width: 100%;height: 1px;background-color: rgba(199,199,199,0.8);margin-top: 25px;"></p>

                    <div class="div_line">
                        <span style="color: red">*</span>
                        <span style="font-size: 15px">版本号</span>
                        <input placeholder="例如：1.0.1" class="add_input" id="i_version" name="i_version">
                        <span style="color: red;margin-left: 35px">*</span>
                        <span style="font-size: 15px">版本名称</span>
                        <input placeholder="" class="add_input" name="i_versionname" id="i_versionname">
                    </div>

                    <p style="width: 100%;height: 1px;background-color: rgba(199,199,199,0.8);margin-top: 20px"></p>

                    <div class="div_line">
                        <span style="color: red">*</span>
                        <span style="font-size: 15px;">下载地址</span>
                        <input placeholder="" class="add_input" style="width: 250px" name="i_url" id="i_url">
                       <br>
                        <br>
                        <span style="color: red">*</span>
                        <span style="font-size: 15px">更新描述：</span>
                        <textarea style="width: 500px;height: 100px;margin-top: 20px" name="i_description" id="i_description"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        关闭

                    </button>
                    <button type="button" class="btn btn-primary"  id="submit_bt" onclick="submitData(this)"  >
                        提交更改
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/boostrap/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/boostrap/js/content.js?v=1.0.0"></script>


<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- Peity -->
<script src="${pageContext.request.contextPath}/boostrap/js/demo/bootstrap-table-demo.js"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/layer/laydate/laydate.js"></script>

</body>
<style>
    .table th, .table td {
        text-align: center;
        vertical-align: middle!important;
        font-size: 12px;
    }
    #searHead{
        width: 100%;
        height: 30px;
        margin-top: 40px;
    }


</style>
<script>
    $(function () {
        $('#myModal').modal('hide');
        var $table=$('#table').bootstrapTable({
            //height: getHeight(),
            url: 'versionInfofj',
            classes:'table table-hover table-theme',
            striped:false,//设置为 true 会有隔行变色效果
            undefinedText:'****',//当数据为 undefined 时显示的字符
            sidePagination: 'server', //服务的分页
            pagination: true,
            pageSize: 10,
            pageNumber : 1,
            pageList: [15,30,50],
            queryParamsType : "undefined",
            editable:true,//开启编辑模式
            clickToSelect: true,
            queryParams:queryParams,
            showHeader:true,//是否显示列头
            //showColumns:false,//是否在表格右上角 显示 内容列下拉框
            //minimumCountColumns:8,//当列数小于此值时，将无法触发 格右上角的内容列下拉框事件
            //showRefresh:false,//是否在表格右上角 显示 刷新按钮
            //showToggle:false,//是否在表格右上角 显示 切换试图（table/card）按钮
            //showPaginationSwitch:false,//是否在表格右上角 显示  数据条数选择框
            //clickToSelect:false,//设置true 将在点击行时，自动选择rediobox 和 checkbox
            //singleSelect:false,//设置True 将禁止多选 并将表头的checkall标签去掉
            //maintainSelected:false,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
            sortable:false,//设置为false 将禁止所有列的排序
            //checkboxHeader:false,
            refresh : true,
            silent : true,
            toolbar:'#myop',
            classes : 'table table-hover table-condensed table-responsive table-orange',
            columns: [
                {
                    field: 'version',
                    title: '版本号',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'150px'
                },
                {
                    field: 'versionname',
                    title: '版本名称',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px'
                },
                {
                    field: 'type',
                    title: '渠道类型',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px'
                },
                {
                    field: 'isforceupdate',
                    title: '是否强制更新',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'60px',
                },
                {
                    field: 'url',
                    title: '下载地址',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px'
                },
                {
                    field: 'description',
                    title: '更新描述',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'120px'
                },
                {
                    field: 'createtime',
                    title: '创建时间',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'80px'

                },
                {
                    field: 'updatetime',
                    title: '更新时间',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'60px',},

               {title: '操作',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px',
                    events:operateEvents,
                    formatter:'<a id="deleted" style="color:red"> 删除 </a>&nbsp&nbsp<a id="edit" style="color:red"> 编辑 </a>'
                }],

            responseHandler : function(res) {
                return {
                    "total" : res.resultBody.totalCounts,//总记录数
                    "rows" : res.resultBody.list//返回数据
                };
            }

        });
        function queryParams(params){
            params.i_type = $("#serach_input").val()
            return params;
        }
    })

    window.operateEvents = {
        'click #edit': function (e, value, row, index) {
            $("#i_isforceupdate").val(row.isforceupdate);
            $("#i_type").val(row.type);
            $("#i_version").val(row.version);
            $("#i_versionname").val(row.versionname);
            $("#i_description").val(row.description);
            $("#i_url").val(row.url)
            $("#myModal").modal('show');
            document.getElementById("submit_bt").innerText = "提交修改"
            document.getElementById("myModalLabel").innerText = "版本修改"
            var input_i_version = $("#i_version");
            input_i_version.attr("readonly","readonly");
        },

        'click #deleted': function (e, value, row, index) {
            parent.layer.confirm('您确定要删除该条版本信息？', {
                btn: ['删除','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                $.ajax({
                    url:"delectVersionfj1233",
                    type:"post",//请求方式
                    dataType : "json",
                    data:{"i_version":row.version},
                    success:function(data){//成功后执行方法；处理返回值
                        if(data.resultCode=="1"){
                            parent.layer.msg('删除成功', {icon: 1});
                            $('#table').bootstrapTable('refresh',{url:'versionInfofj'});
                        }else{
                            alert(data.resultMsg)
                        }
                    },
                    error:function(){//成功后执行方法
                        alert("请求错误！")
                    }
                });

            }, function(){
                // parent.layer.msg('', {shift: 6});
            });
        }
    };


    $("#myModal input").focus(function(){

        $(this).css({
            'border-color': 'rgba(72,160,127,1)'
        });

    });
    $("#myModal input").blur(function(){
        $(this).css({
            "border-color": "rgba(140,140,140,0.8)"
        });
    });
    $("#myModal textarea").focus(function(){

        $(this).css({
            'border-color': 'rgba(72,160,127,1)'
        });

    });
    $("#myModal textarea").blur(function(){
        $(this).css({
            "border-color": "rgba(140,140,140,0.8)"
        });
    });


    laydate({
        elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
</script>
<script>
    function submitData(button) {
        if(button.innerText=="提交修改"||button.innerText=="提交") {
            var  type = $("#i_type").val();
            var  i_url = $("#i_url").val();
            var  i_versionname = $("#i_versionname").val();
            var i_isforceupdate = $("#i_isforceupdate").val();
            var i_description = $("#i_description").val();
            if(type.length==0||i_url.length==0||i_versionname.length==0||i_isforceupdate.length==0||i_description.length==0){
                parent.layer.msg('还有未填项！');
                return
            }
            var url = null;
            var message = null;
            if(button.innerText=="提交修改"){
              url = "updataVersionfj1233";
                message = "修改成功！"
            }else {
                url = "addVersionfj1233";
                message = "新增版本成功！"
            }
            $.ajax({
                url:url,
                type:"post",//请求方式
                dataType:"json",
                data:$("#Formdata").serialize(),
                success:function(data){//成功后执行方法；处理返回值
                    if(data.resultCode=="1"){
                        $('#table').bootstrapTable('refresh',{url:'versionInfofj'});
                        $("#myModal").modal('hide');
                        document.getElementById("Formdata").reset();
                        parent.layer.msg(message);
                    }else{
                        alert(data.resultMsg)
                    }
                },
                error:function(){//成功后执行方法
                    alert("请求错误！")
                }
            });

        }
    }
    function search() {
        $('#table').bootstrapTable('refresh',{url:'versionInfofj'});
    }
    function addVersion() {
        document.getElementById("Formdata").reset();
        document.getElementById("submit_bt").innerText = "提交"
        document.getElementById("myModalLabel").innerText = "新增版本"
        $("#myModal").modal('show');
    }

</script>
<style>
    .add_input{
        margin-left: 20px;width: 150px;height: 30px;
        outline: none;
        border-style: solid;
        border-width: 1px;
        border-color: rgba(140,140,140,0.8);
        padding-left: 10px;

    }
    .div_line{
        margin-top: 30px;
    }


</style>
</html>

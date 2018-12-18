function userAdd() {
	addDataDialog({
		pageUrl:'/user/userAdd',
		title:"用户添加",
		handleAddDialog:function(dialogRef){
			var validateNode = dialogRef.getModalBody().find('#userDataForm');
            var validFlag = validateNode.valid();
            if(validFlag){
                dialogRef.enableButtons(false);
                $.ajaxSettings.async = false;
                var userData = validateNode.serialize();
                $.post("./userAdd", userData, function(data){
                    if(data.success){
                        toastr["success"]("添加成功");
                        queryUserData();
                        dialogRef.close();
                    }else{
                        toastr["error"](data.errorMsg);
                        dialogRef.enableButtons(true);
                    }
                });
            }else{
                dialogRef.enableButtons(true);
            }
		}
	});
}

function editUser(userId) {
	updateDataDialog({
		title:"用户编辑",
		pageUrl:'/user/userEdit?userId='+userId,
		handleUpdateDialog:function(dialogRef){
			dialogRef.enableButtons(false);
            var validateNode = dialogRef.getModalBody().find('#userDataFormEdit');
            var validFlag = validateNode.valid();
            if(validFlag){
                $.ajaxSettings.async = false;
                var userData = validateNode.serialize();
                $.post("./userEdit", userData, function(data){
                    if(data.success){
                        toastr["success"]("修改成功");
                        queryUserData();
                        dialogRef.close();
                    }else{
                        toastr["error"](data.errorMsg);
                        dialogRef.enableButtons(true);
                    }
                });
                 $.ajaxSettings.async = true;
            }
		}
	});
}

function deleteUser(trNode) {
    var userId = $(trNode).parents("tr").find("td[aria-describedby='dataTables_id']").text();
    var userName = $(trNode).parents("tr").find("td[aria-describedby='dataTables_userName']").text();
    var tipsMsg = '你确认删除 <b>'+userName+'</b> 用户?'
    deleteDataDialog({
    	tipsMsg:tipsMsg,
		handleDeletedDialog:function(){
			var params = {userId:userId};
			$.post("./userDelete", params, function(data){
                if(data.success){
                    toastr["success"]("删除成功");
                    queryUserData();
                }else{
                    toastr["error"](data.errorMsg);
                }
            });
		}    	
    });
}
$(function () {
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: './queryUserList',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: 'id', name: 'id', key: true, hidden: true},
            {label: '用户名', name: 'userName',width: 110, align:'left'},
            {label: '手机号', name: 'phoneNo',width: 130, align:'center'},
            {label: '邮箱', name: 'email',width: 160, align:'center'},
            {label: '登录名', name: 'loginName', align:'center',width: 130},
            {label: '最后登录时间', name: 'lastLoginTime', align:'center',width: 160},
            {label: '管理员', name: 'manager',width: 80, align:'center', formatter: function (value, options, row) {
            	if(value==1) return "<span>是</span>";
                if(value==0) return "<span>否</span>";
            }},
            {label: '状态', name: 'status',width: 80, align:'center', formatter: function (value, options, row) {
            	if(value==1) return "<span>有效</span>";
            	if(value==0) return "<span>无效</span>";
            }},
            {label: '操作',  width: 120,align:'center', formatter: function (value, options, row) {
            	var operationHtml = "<span class='center'><a href='javascript:void(0)' onclick='editUser("+row.id+")'>编辑</a>";
                operationHtml += " <a href='javascript:void(0)' onclick='deleteUser(this)'>删除</a></span>";
                return operationHtml;
            }}
        ],
        styleUI: 'Bootstrap',
        autowidth: true,
        viewrecords: true,
        height: 400,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        pager: "#pagenation",
        jsonReader: {
            root: "dataList",
            page: "page.pageId",
            total: "page.pageCount",
            records: "page.rowCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        loadComplete:function(xhr){
        	if(xhr.success==false){
        		toastr["error"](xhr.errorMsg);
        	}	
        }
    });
    $("#queryUserBtn").click(function () {
        $(".overlay").show();
        setTimeout(function(){
            queryUserData();
            $(".overlay").hide();
        }, 100);
    });

    $("#addUserBtn").click(function(){
        userAdd();
    });    
   // $("#queryUserBtn").click();
 });
function queryUserData(param){
	if(param==null || param==undefined){
		var userName = $("#userName").val();
        var userStatus = $("#userStatus").val();
        param = {
    		 userName: userName,
             status: userStatus
        };
 	}
	$("#dataTables").jqGrid('setGridParam', {
        datatype: 'json',
        postData: param, //发送数据
        page: 1
    }).trigger("reloadGrid"); //重新载入
}

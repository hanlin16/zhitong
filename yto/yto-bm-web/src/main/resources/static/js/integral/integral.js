
$(function () {
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: '../integral/queryIntegralAll',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: '规则编码', name: 'ruleCode',width: 110, align:'center'},
            {label: '起期', name: 'startDate',width: 110, align:'center'},
            {label: '止期', name: 'endDate',width: 130, align:'center'},
            {label: '版本号', name: 'versionNo',width: 100, align:'center'},
            {label: '状态', name: 'versionStatus', align:'center',width: 130,formatter: function (value, options, row) {
            	if(value==1) return "<span>当前</span>";
                if(value==0) return "<span>历史</span>";
            }},
            {label: '创建时间', name: 'createTime', align:'center',width: 200},
            {label: '创建人', name: 'createUser',width: 80, align:'center'},
            {label: '修改时间', name: 'updateTime',width: 200, align:'center'},
            {label: '修改人', name: 'updateUser', align:'center',width: 80},
            {label: '操作',  width: 120,align:'center', formatter: function (value, options, row) {
//            	alert(row.ruleCode);
            	var operationHtml = "<a href='../integral/integralDetailPage?code="+row.ruleCode+"&start="+row.startDate+"&end="+row.endDate+"&no="+row.versionNo+"'>查看</a></span>";
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
function detailIntegral(ruleCode) {
//	alert("666");
	updateDataDialog({
		title:"规则内容",
		pageUrl:'/integral/queryIntegralRuleDef?ruleCode='+ruleCode,
		handleUpdateDialog:function(dialogRef){
			dialogRef.enableButtons(false);
            var validateNode = dialogRef.getModalBody().find('#integralDataFormEdit');
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
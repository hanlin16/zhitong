var baseUrl = window.localStorage.getItem("baseUrl");
function saleActionAdd() {
	addDataDialog({
		pageUrl:'/saleAction/saleActionAdd',
		title:"活动添加",
		handleAddDialog:function(dialogRef){
			var validateNode = dialogRef.getModalBody().find('#saleActionDataForm');
            var validFlag = validateNode.valid();
            if(validFlag){
                dialogRef.enableButtons(false);
                $.ajaxSettings.async = false;
                var saleActionData = validateNode.serialize();
                $.post("./saleActionAdd", saleActionData, function(data){
                    if(data.success){
                        toastr["success"]("添加成功");
                        querySaleActionData();
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

function editSaleAction(saleActionId) {
	updateDataDialog({
		title:"活动编辑",
		pageUrl:'/saleAction/saleActionEdit?saleActionId='+saleActionId,
		handleUpdateDialog:function(dialogRef){
			dialogRef.enableButtons(false);
            var validateNode = dialogRef.getModalBody().find('#saleActionDataForm');
            var validFlag = validateNode.valid();
            if(validFlag){
                $.ajaxSettings.async = false;
                var saleActionData = validateNode.serialize();
                $.post("./saleActionEdit", saleActionData, function(data){
                    if(data.success){
                        toastr["success"]("修改成功");
                        querySaleActionData();
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

function viewApplyUrl(actionCode) {
	$.post(baseUrl+"/loginUserInfo", function(res){
		if(res && res.success){
			var urlHtml = baseUrl+'/saleAction/deviceApplyUrlPage?actionCode='+actionCode;
		    BootstrapDialog.show({
		    title:"设备申领URL",
		    closable: true,
		    closeByBackdrop: false,
		    closeByKeyboard: false,
		    size:BootstrapDialog.SIZE_WIDE,
		    type:BootstrapDialog.TYPE_PRIMARY,
		    message: function(dialogRef) {
		        var $message = $('<div></div>');
		        var pageToLoad = dialogRef.getData('pageToLoad');
		        $message.load(pageToLoad, function(){
		        });
		        return $message;
		    },
		    data: {
		        'pageToLoad': urlHtml
		    },
		    onshow:function(dialogRef){
		    	var $modalDialog = dialogRef.getModalDialog();
			    $modalDialog.css({
			        "position": "absolute",
			        "top": "50%",
			        "left": "50%",
			        "transform":"translate(-50%, -50%)",
			        "min-width":"80%",
			        "over-flow":"inherit",
			        "right":"inherit"
			    });
			    }
		    });
		}else{
			 toastr["error"](res.errorMsg);
		}
	});
}

$(function () {
	initDateTimePicker("#startEffectTime", "#endEffectTime");
	initInvalidTimePicker("#startInvalidTime", "#endInvalidTime");
	
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: './querySaleActionList',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: 'id', name: 'id', key: true, hidden: true},
            {label: '活动码', name: 'code',width: 110, align:'center'},
            {label: '渠道名称', name: 'channelName',width: 80, align:'center'},
            {label: '合作伙伴', name: 'partnerName',width: 100, align:'center'},
            {label: '生效时间', name: 'startTime', align:'center',width: 80, formatter: function (value, options, row) {
            	if(value!=null && value!=undefined && value.indexOf('00:00:00')){
            		value = value.slice(0,value.indexOf('00:00:00'));
            	}
            	return value;
            }},
            {label: '失效时间', name: 'endTime', align:'center',width: 100, formatter: function (value, options, row) {
            	return value;
            }},
            {label: '设备申领URL', name: 'linkmanEmail',width: 120, align:'center', formatter: function (value, options, row) {
            	return "<a href='javascript:void(0)' onclick='viewApplyUrl(\""+row.code+"\")'>查看</a>";
            }},
            {label: '备注', name: 'remark',width: 80, align:'center'},
            {label: '操作',  width: 120,align:'center', formatter: function (value, options, row) {
            	var operationHtml = "<span class='center'><a href='javascript:void(0)' onclick='editSaleAction("+row.id+")'>编辑</a>";
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
    $("#querySaleActionBtn").click(function () {
        $(".overlay").show();
        setTimeout(function(){
            querySaleActionData();
            $(".overlay").hide();
        }, 100);
    });

    $("#addSaleActionBtn").click(function(){
        saleActionAdd();
    });    
 });
function querySaleActionData(param){
	if(param==null || param==undefined){
		var code = $("#code").val();
        var partnerCode = $("#partnerCode").val();
        var channelCode = $("#channelCode").val();
        var startEffectTime = $("#startEffectTime").val();
        var endEffectTime = $("#endEffectTime").val();
        var startInvalidTime = $("#startInvalidTime").val();
        var endInvalidTime = $("#endInvalidTime").val();
        
        param = {
        	partnerCode: partnerCode,
        	channelCode: channelCode,
        	endEffectTime: endEffectTime,
        	startEffectTime: startEffectTime,
        	startInvalidTime: startInvalidTime,
        	endInvalidTime: endInvalidTime,
    		code:code
        };
 	}
	$("#dataTables").jqGrid('setGridParam', {
        datatype: 'json',
        postData: param, //发送数据
        page: 1
    }).trigger("reloadGrid"); //重新载入
}

function initDateTimePicker(startTime, endTime) {
    $(startTime).datetimepicker("remove");
    $(startTime).datetimepicker({
    	format: 'yyyy-mm-dd',
        language:'zh-CN',
        autoclose: true,
        clearBtn:true,
        startView: 2,
        minView: 2
    }).on("changeDate", function() {
        var value = $(startTime).val();
        $(endTime).datetimepicker("remove");
        $(endTime).datetimepicker({
        	format: 'yyyy-mm-dd',
            language:'zh-CN',
            autoclose: true,
            clearBtn:true,
            startDate: value,
            startView: 2,
            minView: 2
        })
    });
    $(endTime).datetimepicker("remove");
    $(endTime).datetimepicker({
    	format: 'yyyy-mm-dd',
        language:'zh-CN',
        autoclose: true,
        clearBtn:true,
        startView: 2,
        minView: 2
    }).on("changeDate", function() {
        var value = $(endTime).val();
        $(startTime).datetimepicker("remove");
        $(startTime).datetimepicker({
        	format: 'yyyy-mm-dd',
            language:'zh-CN',
            autoclose: true,
            clearBtn:true,
            endDate: value,
            startView: 2,
            minView: 2
        })
    });
}

function initInvalidTimePicker(startTime, endTime) {
    $(startTime).datetimepicker("remove");
    $(startTime).datetimepicker({
    	format: 'yyyy-mm-dd',
        language:'zh-CN',
        autoclose: true,
        startView: 2,
        clearBtn:true,
        minView: 2
    }).on("changeDate", function() {
        var value = $(startTime).val();
        $(endTime).datetimepicker("remove");
        $(endTime).datetimepicker({
        	format: 'yyyy-mm-dd',
            language:'zh-CN',
            autoclose: true,
            clearBtn:true,
            startDate: value,
            startView: 2,
            minView: 2
        })
    });
    $(endTime).datetimepicker("remove");
    $(endTime).datetimepicker({
    	format: 'yyyy-mm-dd',
        language:'zh-CN',
        autoclose: true,
        clearBtn:true,
        startView: 2,
        minView: 2
    }).on("changeDate", function() {
        var value = $(endTime).val();
        $(startTime).datetimepicker("remove");
        $(startTime).datetimepicker({
        	format: 'yyyy-mm-dd',
            language:'zh-CN',
            autoclose: true,
            endDate: value,
            clearBtn:true,
            startView: 2,
            minView: 2
        })
    });
}

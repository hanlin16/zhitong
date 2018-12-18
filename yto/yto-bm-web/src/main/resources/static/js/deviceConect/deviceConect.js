/**
 * 关联
 */
function relationBtnFunc(dialogRef) {
	var applyId = dialogRef.getModalBody().find('#applyId').text();
	var deviceCode = dialogRef.getModalBody().find('#deviceCode').val();
	if(deviceCode==null || deviceCode=="" ||  deviceCode.length!=12){
		dialogRef.getModalBody().find('#deviceCodeErrorMsg').text("长度12位!");
		return;
	}else{
		dialogRef.getModalBody().find('#deviceCodeErrorMsg').html("&nbsp;");
	}
	var logisticsCompany = dialogRef.getModalBody().find("#logisticsCompany").val();
	if(logisticsCompany==null || logisticsCompany==""){
		dialogRef.getModalBody().find('#logisticsCompanyErrorMsg').text("必填项");
		return;
	}else{
		dialogRef.getModalBody().find('#logisticsCompanyErrorMsg').html("&nbsp;");
	}
	var logisticsNo = dialogRef.getModalBody().find("#logisticsNo").val();
	if(logisticsNo==null || logisticsNo==""){
		dialogRef.getModalBody().find('#logisticsNoErrorMsg').text("必填项");
		return;
	}else{
		dialogRef.getModalBody().find('#logisticsNoErrorMsg').html("&nbsp;");
	}
	var relationData ={
		applyId: applyId,
		deviceCode: deviceCode,
		logisticsCompany: logisticsCompany,
		logisticsNo: logisticsNo
	};
    $.post("./relationDevice", relationData, function(data){
        if(data.success){
            toastr["success"]("关联成功");
            dialogRef.close();
            queryDeviceData();
        }else{
            toastr["error"](data.errorMsg);
            dialogRef.enableButtons(true);
        }
    });
}

function relationingBtnFunc(dialogRef) {
	var applyId = $("#applyId").text();
	var relationData ={applyId: applyId};
    $.post("./relatingDeviceData", relationData, function(data){
        if(data.success){
            toastr["success"]("关联成功");
            dialogRef.close();
            queryDeviceData();
        }else{
            toastr["error"](data.errorMsg);
            dialogRef.enableButtons(true);
        }
    });
}
/**
 * 拒关联
 */
function unrelationBtnFunc(dialogRef){
	var applyId = $("#applyId").text();
	var relationData ={
			applyId: applyId
	};
    $.post("./unrelationDevice", relationData, function(data){
        if(data.success){
            toastr["success"]("操作成功");
            dialogRef.close();
            queryDeviceData();
        }else{
            toastr["error"](data.errorMsg);
            dialogRef.enableButtons(true);
        }
    });
}
/**
 * 关联界面
 * @param bizNo
 */
function showRalationDevice(applyId) {
	$.post("../loginUserInfo", function(res){
		if(res && res.success){
			var urlHtml = './relationDeviceInfo?applyId='+applyId;
		    BootstrapDialog.show({
		    title:"设备关联",
		    closable: true,
		    closeByBackdrop: false,
		    closeByKeyboard: false,
		    cssClass:'modal-center',
		    size:BootstrapDialog.SIZE_WIDE,
		    type:BootstrapDialog.TYPE_PRIMARY,
		    message: function(dialogRef) {
		        var $message = $('<div></div>');
		        var pageToLoad = dialogRef.getData('pageToLoad');
		        $message.load(pageToLoad, function(){
		        	$message.find("#relationingBtn").click({dialogRef: dialogRef}, function(event) {
		        		relationingBtnFunc(dialogRef);
		             });
		        	$message.find("#relationBtn").click({dialogRef: dialogRef}, function(event) {
		        		relationBtnFunc(dialogRef);
		             });
		        	$message.find("#unrelationBtn").click({dialogRef: dialogRef}, function(event) {
		        		unrelationBtnFunc(dialogRef);
		        	});
		        	$message.find("#closeDialogBtn").click({dialogRef: dialogRef}, function(event) {
		        		dialogRef.close();
		        	});
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
	initDateTimePicker("#startDate", "#endDate");
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: './queryDevicesList',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: 'ID', name: 'applyId', key: true, hidden: true},
            {label: '业务号', name: 'bizNo',width: 150, align:'center'},
            {label: '设备ID', name: 'deviceCode', hidden: true},
            {label: '收件人', name: 'receiver',width: 130, align:'left'},
            {label: '手机号码', name: 'receiverPhoneNo',width: 100, align:'center'},
            {label: '申领时间', name: 'applyTime', align:'center',width: 150},
            {label: '配送地址', name: 'address', align:'left',width: '250'},
            {label: '申领类型', name: 'applyType', align:'center',width: 130,formatter: function (value, options, row) {
            	if(value=="A") return "<span>先出单后申领</span>";
                if(value=="B") return "<span>先申领后出单</span>";
            }},
            {label: '渠道', name: 'channelName', align:'center',width: 120},
            {label: '活动码', name: 'actionCode', align:'center',width: 100},
            {label: '绑定', name: 'bindStatus',align:'center', width: 90, formatter: function (value, options, row) {
            	if(value==1) return "<span>待绑定</span>";
                if(value==2) return "<span>已绑定</span>";
                if(value==3) return "<span>已解绑</span>";
                return "待绑定";
            }},
            {label: '关联', name: 'linkStatus',align:'center', width: 90, formatter: function (value, options, row) {
            	if(value==1) return "<span>待关联</span>";
                if(value==2) return "<span>关联中</span>";
                if(value==3) return "<span>已关联</span>";
                if(value==4) return "<span>拒关联</span>";
            }},
            {label: '操作',  width: 100, formatter: function (value, options, row) {
            	if(row.linkStatus!=null && (row.linkStatus==1 || row.linkStatus==2 )){
            		return ' <span><a href="javascript:void(0)" onclick="showRalationDevice(\''+row.applyId+'\')">关联</a></span>';
            	}else{
            		if(row.linkStatus!=4){
            			return ' <span><a href="/deviceManage/deviceDetailInfo?id='+row.deviceId+'">查看</a></span>';
            		}else{
            			return ' <span></span>';
            		}            		
            	}
            }}
        ],
        styleUI: 'Bootstrap',
        viewrecords: true,
        height: 380,
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
        }
    });
	
    $("#queryDeviceBtn").click(function () {
        $(".overlay").show();
        setTimeout(function(){
            queryDeviceData();
            $(".overlay").hide();
        }, 100);
    });
    
 });
 
function queryDeviceData(param){
	if(param==null || param==undefined){
 		var receiver = $("#receiver").val();
        var applyType = $("#applyType").val();
        var channelCode = $("#channelCode").val();
        var bizNo = $("#bizNo").val();
        var linkStatus = $("#linkStatus").val();
        
        var startDate = $("#startDate").val();
        var endDate = $("#endDate").val();
        var actionCode = $("#actionCode").val();
        param = {
        		receiver:receiver,
        		applyType:applyType,
        		channelCode:channelCode,
        		bizNo:bizNo,
        		startDate:startDate,
        		endDate:endDate,
        		linkStatus:linkStatus,
        		actionCode:actionCode
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



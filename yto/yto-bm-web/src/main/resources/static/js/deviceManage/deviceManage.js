$(function () {
	initDateTimePicker("#bindBeginTime", "#bindEndTime");
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: './queryDeviceManageList',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: 'id', name: 'id', key: true, hidden: true},
            {label: '设备标识', name: 'deviceCode',width: 120, align:'center'},
            {label: '供应商', name: 'providerName',width: 80, align:'center'},
            {label: '状态', name: 'status',width: 70, align:'center',formatter: function (value, options, row) {
            	if(value==0) return "<span>无效</span>";
                if(value==1) return "<span>有效</span>";
            }},
            {label: '物流公司', name: 'loCompany',width: 100, align:'center'},
            {label: '物流单号', name: 'loOrderNo', align:'center',width: 150},
            {label: '当事人手机号', name: 'partyPhoneNo', align:'center',width: 110},
            {label: '绑定车牌号', name: 'licenseNo',width: 120, align:'center'},
            {label: '绑定时间', name: 'bindTime',width: 170, align:'center'},
            {label: '查看',  width: 120,align:'center', formatter: function (value, options, row) {
            	var operationHtml = "<span class='center'><a href='./deviceDetailInfo?id="+row.id+"'>查看</a></span>";
                return operationHtml;
            }}
        ],
        styleUI: 'Bootstrap',
        autowidth: true,
        responsive: true,
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
        },
        gridComplete: function () {
            $("#dataTables").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
            var width = $('.content').width();
            jqGrid.setGridWidth(width-13);
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

function viewDeviceDetail(){
	
}
function queryDeviceData(param){
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

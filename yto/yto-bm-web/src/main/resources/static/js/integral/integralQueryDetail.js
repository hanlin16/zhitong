function getQueryString(name) {  
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
        var r = window.location.search.substr(1).match(reg);  
        if (r != null) return decodeURI(r[2]);  
        return null;  
    } 
$(function () {
	initDateTimePicker("#startDate", "#endDate");
	
	var id = getQueryString("id");
	var partyPhoneNo = getQueryString("partyPhoneNo");
	var name = getQueryString("name");
	var partyCode = getQueryString("partyCode");
	var integralIncome = getQueryString("integralIncome");
	var integralUsable = getQueryString("integralUsable");
	var integralLock = getQueryString("integralLock");
	var integralPayout = getQueryString("integralPayout");
	
	$('#partyPhoneNo').val(partyPhoneNo);
	$('#name').val(name);
	$('#partyCode').val(partyCode);
	$('#integralIncome').val(integralIncome);
	$('#integralUsable').val(integralUsable);
	$('#integralLock').val(integralLock);
	$('#integralPayout').val(integralPayout);
    $(".overlay").hide();
    
    var param = {
    		ruleCode: id,
       };
    $("#dataTables-detail").jqGrid('setGridParam', {
        datatype: 'json',
        postData: param, //发送数据
        page: 1
    }).trigger("loadGrid"); //重新载入
    
    var jqGrid = $("#dataTables-detail");
	$("#dataTables-detail").jqGrid({
		
        url: '../integral/queryIntegralDetail',
        datatype: "json",
        postData: param,
        mtype: "POST",
        colModel: [
            {label: '交易时间', name: 'transactionTime',width: 110, align:'center'},
            {label: '交易科目', name: 'transactionItem',width: 110, align:'center', formatter: function (value, options, row) {
            	if(value==1) return "<span>按周奖励</span>";
                if(value==2) return "<span>按年奖励</span>";
                if(value==3) return "<span>提取冻结</span>";
                if(value==4) return "<span>支付执行</span>";
            }},
            {label: '科目类别', name: 'itemType',width: 110, align:'center', formatter: function (value, options, row) {
            	if(value==1) return "<span>增加</span>";
                if(value==2) return "<span>冻结</span>";
                if(value==3) return "<span>支付</span>";
            }},
            {label: '订单编号', name: 'orderNo',width: 110, align:'center'},
            {label: '备注', name: 'remark',width: 110, align:'center'},
            {label: '可用积分', name: 'balance',width: 110, align:'center'},
            {label: '积分变化', name: 'amount',width: 110, align:'center'}
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
	$("#queryIntegralDetailBtn").click(function () {
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
function queryUserData(params){
	if(params==null || params==undefined){
		var startTime = $("#startDate").val();
        var endTime = $("#endDate").val();
        var transactionItem = $("#transactionItem").val();
        params = {
        		startTime: startTime,
        		endTime: endTime,
        		transactionItem: transactionItem
        };
 	}
	$("#dataTables-detail").jqGrid('setGridParam', {
        datatype: 'json',
        postData: params, //发送数据
        page: 1
    }).trigger("reloadGrid"); //重新载入
}
function initDateTimePicker(startTime, endTime) {
    $(startTime).datetimepicker("remove");
    $(startTime).datetimepicker({
    	format: 'yyyy-mm-dd',
        language:'zh-CN',
        autoclose: true,
        endDate: new Date(),
        startView: 2,
        minView: 2
    }).on("changeDate", function() {
        var value = $(startTime).val();
        $(endTime).datetimepicker("remove");
        $(endTime).datetimepicker({
        	format: 'yyyy-mm-dd',
            language:'zh-CN',
            autoclose: true,
            endDate: new Date(),
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
        endDate: new Date(),
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
            startView: 2,
            minView: 2
        })
    });
}
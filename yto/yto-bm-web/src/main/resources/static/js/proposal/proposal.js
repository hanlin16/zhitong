$(function () {
	
	initDateTimePicker("#startTime", "#endTime");
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: '../proposal/queryProposalLit',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: '商保单号', name: 'biPolicyNo',width: 250, align:'center'},
            {label: '车牌号', name: 'licenseNo',width: 130, align:'center', formatter: function (value, options, row) {
            	return row.vehicleInfo.licenseNo;
            }},
            {label: '投保人', name: 'applicantName',width: 160, align:'left', formatter: function (value, options, row) {
            	return row.personInfo.applicantName;
            }},
            {label: '保险起期', name: 'biStartDate', align:'center',width: 180},
            {label: '保险止期', name: 'biEndDate', align:'center',width: 180},
            {label: '商保保费', name: 'biPremium', align:'right',width: 180},
            {label: '同步时间', name: 'acceptTime', align:'center',width: 230},
            {label: '操作',  width: 120,align:'center', formatter: function (value, options, row) {
            	var operationHtml = "<a href='../deviceConect/proposalInfo?bizId="+row.bizId+"' target='_blank'>详情</a> ";
//            	var operationHtml = "<a href='../proposalDetailPage?bizId="+row.bizId+"'>详情</a></span>";
            	return operationHtml;
            }}
        ],
        styleUI: 'Bootstrap',
        autowidth: true,
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
        },
        loadComplete:function(xhr){
        	if(xhr.success==false){
        		toastr["error"](xhr.errorMsg);
        	}	
        }
    });
	
    $("#queryProposalBtn").click(function () {
        $(".overlay").show();
        setTimeout(function(){
            queryDeviceData();
            $(".overlay").hide();
        }, 100);
    });
   // queryDeviceStatistics();
 });
 
function queryDeviceData(){
      var  param = {
        		biPolicyNo : $("#biPolicyNo").val(),
                licenseNo : $("#licenseNo").val(),
                applicantName : $("#applicantName").val(),
                startTime : $("#startTime").val(),
                endTime : $("#endTime").val()
        };
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
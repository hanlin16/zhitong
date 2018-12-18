$(function () {
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: '../integral/queryIntegralInfo',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: '当事人手机号', name: 'partyPhoneNo',width: 110, align:'left'},
            {label: '当事人姓名', name: 'name',width: 110, align:'left'},
            {label: '当事人编码', name: 'partyCode',width: 130, align:'center'},
            {label: '收入积分', name: 'integralIncome',width: 160, align:'center'},
            {label: '可用积分', name: 'integralUsable', align:'center',width: 160},
            {label: '冻结积分', name: 'integralLock',width: 80, align:'center'},
            {label: '已提积分', name: 'integralPayout',width: 160, align:'center'},
            {label: '查看',  width: 120,align:'center', formatter: function (value, options, row) {
//            	var operationHtml = "<a href='../integral/integralQueryDetailPage?json="+json+"'>明细</a></span>";
            	var operationHtml = "<a href='../integral/integralQueryDetailPage?partyPhoneNo="+row.partyPhoneNo+"&name="+row.name+"&partyCode="+row.partyCode+"&integralIncome="+row.integralIncome
            	+"&integralUsable="+row.integralUsable+"&integralLock="+row.integralLock+"&integralPayout="+row.integralPayout+"&id="+row.id+"'>查看</a></span>";
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
	$("#queryIntegralBtn").click(function () {
//		alert("666");
        $(".overlay").show();
        setTimeout(function(){
        	queryIntegralData();
            $(".overlay").hide();
        }, 100);
    });

 });
function queryIntegralData(){
      var  param = {
        		partyCode: $("#partyCode").val(),
        		partyPhoneNo: $("#partyPhoneNo").val()
        };
	$("#dataTables").jqGrid('setGridParam', {
        datatype: 'json',
        postData: param, //发送数据
        page: 1
    }).trigger("reloadGrid"); //重新载入
	
//	$('#dataTables').datagrid('reloadGrid', {    
//		partyCode: $("#partyCode").val(),
//		partyPhoneNo: $("#partyPhoneNo").val()   
//	});
	
}
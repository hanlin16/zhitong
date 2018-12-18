function getQueryString(name) {  
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
        var r = window.location.search.substr(1).match(reg);  
        if (r != null) return unescape(r[2]);  
        return null;  
    } 
$(function () {
	var ruleCode = getQueryString("code");
	var startDate = getQueryString("start");
	var endDate = getQueryString("end");
	var versionNo = getQueryString("no");
//	alert(startDate);
	$('#ruleCode').val(ruleCode);
	$('#startDate').val(startDate);
	$('#endDate').val(endDate);
	$('#versionNo').val(versionNo);
    $(".overlay").hide();
    
    var param = {
    		ruleCode: ruleCode,
       };
    var jqGrid = $("#dataTables-detail");
	$("#dataTables-detail").jqGrid({
        url: '../integral/queryIntegralRuleDef',
        datatype: "json",
        postData: param,
        mtype: "POST",
        colModel: [
            {label: '区间序号', name: 'serialNo',width: 110, align:'center'},
            {label: '区间', name: 'gradeEnd',width: 110, align:'center',formatter: function (value, options, row) {
            	return row.gradeFrom+" TO "+ row.gradeEnd;
            }},
            {label: '积分', name: 'integral',width: 130, align:'center'}
        ],
        styleUI: 'Bootstrap',
        autowidth: true,
        viewrecords: true,
        height: 200,
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

 });

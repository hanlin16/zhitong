function saleChannelAdd() {
	addDataDialog({
		pageUrl:'/saleChannel/saleChannelAdd',
		title:"渠道添加",
		handleAddDialog:function(dialogRef){
			var validateNode = dialogRef.getModalBody().find('#saleChannelDataForm');
            var validFlag = validateNode.valid();
            if(validFlag){
                dialogRef.enableButtons(false);
                $.ajaxSettings.async = false;
                var saleChannelData = validateNode.serialize();
                $.post("./saleChannelAdd", saleChannelData, function(data){
                    if(data.success){
                        toastr["success"]("添加成功");
                        querySaleChannelData();
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

function editSaleChannel(saleChannelId) {
	updateDataDialog({
		title:"渠道编辑",
		pageUrl:'/saleChannel/saleChannelEdit?saleChannelId='+saleChannelId,
		handleUpdateDialog:function(dialogRef){
			dialogRef.enableButtons(false);
            var validateNode = dialogRef.getModalBody().find('#saleChannelDataForm');
            var validFlag = validateNode.valid();
            if(validFlag){
                $.ajaxSettings.async = false;
                var saleChannelData = validateNode.serialize();
                $.post("./saleChannelEdit", saleChannelData, function(data){
                    if(data.success){
                        toastr["success"]("修改成功");
                        querySaleChannelData();
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

function deleteSaleChannel(trNode) {
    var saleChannelId = $(trNode).parents("tr").find("td[aria-describedby='dataTables_id']").text();
    var saleChannelName = $(trNode).parents("tr").find("td[aria-describedby='dataTables_name']").text();
    var tipsMsg = '你确认删除 <b>'+saleChannelName+'</b> 渠道?'
    deleteDataDialog({
    	tipsMsg:tipsMsg,
		handleDeletedDialog:function(){
			var params = {saleChannelId:saleChannelId};
			$.post("./saleChannelDelete", params, function(data){
                if(data.success){
                    toastr["success"]("删除成功");
                    querySaleChannelData();
                }else{
                    toastr["error"](data.errorMsg);
                }
            });
		} 
    });
}
$(function () {
	var baseUrl = window.localStorage.getItem("baseUrl");
	$.post(baseUrl+"/companyPartner/queryCompanyPartnerList", {limit:65536,page:1}, function(data){
        if(data.state){
        	console.log(data);
        	$.each(data.dataList, function(index, item){
        		$("#partnerCode").append('<option value='+item.code+'>'+item.shortName+'</option>');
        	});
        	
        }else{
            toastr["error"](data.errorMsg);
        }
    });
    $(".overlay").hide();
    var jqGrid = $("#dataTables");
	$("#dataTables").jqGrid({
        url: './querySaleChannelList',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: 'id', name: 'id', key: true, hidden: true},
            {label: '渠道名称', name: 'name',width: 110, align:'left'},
            {label: '渠道编码', name: 'code',width: 130, align:'center'},
            {label: '合作伙伴', name: 'partnerName',width: 160, align:'left'},
            {label: '状态', name: 'status',width: 80, align:'center', formatter: function (value, options, row) {
            	if(value==1) return "<span>有效</span>";
            	if(value==0) return "<span>无效</span>";
            }},
            {label: '备注', name: 'remark', align:'left',width: 160},
            {label: '操作',  width: 120,align:'center', formatter: function (value, options, row) {
            	var operationHtml = "<span class='center'><a href='javascript:void(0)' onclick='editSaleChannel("+row.id+")'>编辑</a>";
                operationHtml += " <a href='javascript:void(0)' onclick='deleteSaleChannel(this)'>删除</a></span>";
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
    $("#querySaleChannelBtn").click(function () {
        $(".overlay").show();
        setTimeout(function(){
            querySaleChannelData();
            $(".overlay").hide();
        }, 100);
    });

    $("#addSaleChannelBtn").click(function(){
        saleChannelAdd();
    });    
   
 });
function querySaleChannelData(param){
	if(param==null || param==undefined){
		var code = $("#code").val();
		var partnerCode = $("#partnerCode").val();
        var status = $("#status").val();
        param = {
        	code: code,
        	partnerCode: partnerCode,
            status: status
        };
 	}
	$("#dataTables").jqGrid('setGridParam', {
        datatype: 'json',
        postData: param, //发送数据
        page: 1
    }).trigger("reloadGrid"); //重新载入
}

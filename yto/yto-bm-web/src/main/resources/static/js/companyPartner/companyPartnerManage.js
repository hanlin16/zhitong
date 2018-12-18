function companyPartnerAdd() {
	var baseUrl = window.localStorage.getItem("baseUrl");
	$.post(baseUrl+"/loginUserInfo", function(res) {
		if(res && res.success) {
			var urlHtml = '/companyPartner/companyPartnerAdd';
			BootstrapDialog.show({
				title: "合作伙伴添加",
				closable: true,
				closeByBackdrop: false,
				closeByKeyboard: false,
				size: BootstrapDialog.SIZE_NORMAL,
				type: BootstrapDialog.TYPE_PRIMARY,
				message: function(dialogRef) {
					return $('<div></div>').load(baseUrl+urlHtml);
				},
				buttons: [{
			        label: '取消',
			        cssClass: 'btn-default',
			        action: function(dialogRef){
			            dialogRef.close();
			        }
			    }, {
			        label: '添加',
			        cssClass: 'btn-primary',
			        action: function(dialogRef){
			        	var validateNode = dialogRef.getModalBody().find('#companyPartnerDataForm');
			            var validFlag = validateNode.valid();
			            var areaCode = dialogRef.getModalBody().find('#inputAreaCode').val();
		            	if(areaCode=="" || areaCode==null){
		            		var errMsg = '<em id="areaCodeErrorMsg" class="error help-block" style="color:#a94442;">这是必填字段</em>';
		            		dialogRef.getModalBody().find('.select2-container').after(errMsg);
		            	}else{
		            		dialogRef.getModalBody().find('#areaCodeErrorMsg').empty();
		            	}
			            if(validFlag){
		            		dialogRef.enableButtons(false);
			                $.ajaxSettings.async = false;
			                var companyPartnerData = validateNode.serialize();
			                $.post("./companyPartnerAdd", companyPartnerData, function(data){
			                    if(data.success){
			                        toastr["success"]("添加成功");
			                        queryPartnerData();
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
			    }],
				onshow: function(dialogRef) {
					var $modalDialog = dialogRef.getModalDialog();
					$modalDialog.css({
						"position": "absolute",
						"top": "50%",
						"left": "50%",
						"transform": "translate(-50%, -50%)",
						"min-width": "50%",
						"over-flow": "inherit",
						"right": "inherit"
					});
				},
				onshown:function(dialogRef) {
					$(".modal").removeAttr("tabindex");
					$.fn.modal.Constructor.prototype.enforceFocus = function () { };
				}
			});
		} else {
			toastr["error"](res.errorMsg);
		}
	});
}


function editPartner(companyPartnerId) {
	var baseUrl = window.localStorage.getItem("baseUrl");
	$.post(baseUrl+"/loginUserInfo", function(res) {
		if(res && res.success) {
			var urlHtml = '/companyPartner/companyPartnerEdit?companyPartnerId='+companyPartnerId;
			BootstrapDialog.show({
				title: "合作伙伴添加",
				closable: true,
				closeByBackdrop: false,
				closeByKeyboard: false,
				size: BootstrapDialog.SIZE_NORMAL,
				type: BootstrapDialog.TYPE_PRIMARY,
				message: function(dialogRef) {
					return $('<div></div>').load(baseUrl+urlHtml);
				},
				buttons: [{
			        label: '取消',
			        cssClass: 'btn-default',
			        action: function(dialogRef){
			            dialogRef.close();
			        }
			    }, {
			        label: '更改',
			        cssClass: 'btn-primary',
			        action: function(dialogRef){
			        	dialogRef.enableButtons(false);
			            var validateNode = dialogRef.getModalBody().find('#companyPartnerDataForm');
			            var validFlag = validateNode.valid();
			            var areaCode = dialogRef.getModalBody().find('#inputAreaCode').val();
		            	if(areaCode=="" || areaCode==null){
		            		var errMsg = '<em class="error help-block" style="color:#a94442;">这是必填字段</em>';
		            		dialogRef.getModalBody().find('.select2-container').after(errMsg);
		            	}
			            if(validFlag){
			                $.ajaxSettings.async = false;
			                var companyPartnerData = validateNode.serialize();
			                $.post("./companyPartnerEdit", companyPartnerData, function(data){
			                    if(data.success){
			                        toastr["success"]("修改成功");
			                        queryPartnerData();
			                        dialogRef.close();
			                    }else{
			                        toastr["error"](data.errorMsg);
			                        dialogRef.enableButtons(true);
			                    }
			                });
			                 $.ajaxSettings.async = true;
			            }else{
			                dialogRef.enableButtons(true);
			            }
			        }
			    }],
				onshow: function(dialogRef) {
					var $modalDialog = dialogRef.getModalDialog();
					$modalDialog.css({
						"position": "absolute",
						"top": "50%",
						"left": "50%",
						"transform": "translate(-50%, -50%)",
						"min-width": "50%",
						"over-flow": "inherit",
						"right": "inherit"
					});
				},
				onshown:function(dialogRef) {
					console.log($(".modal").attr("tabindex"));
					$(".modal").removeAttr("tabindex");
					$.fn.modal.Constructor.prototype.enforceFocus = function () { };
				}
			});
		} else {
			toastr["error"](res.errorMsg);
		}
	});
}
function deletePartner(trNode) {
    var companyPartnerId = $(trNode).parents("tr").find("td[aria-describedby='dataTables_id']").text();
    var companyPartnerName = $(trNode).parents("tr").find("td[aria-describedby='dataTables_fullName']").text();
    var tipsMsg = '你确认删除 <b>'+companyPartnerName+'</b> 合作伙伴?'
    deleteDataDialog({
    	tipsMsg:tipsMsg,
		handleDeletedDialog:function(){
			var params = {companyPartnerId:companyPartnerId};
			$.post("./companyPartnerDelete", params, function(data){
                if(data.success){
                    toastr["success"]("删除成功");
                    queryPartnerData();
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
        url: './queryCompanyPartnerList',
        datatype: "json",
        mtype: "POST",
        colModel: [
            {label: 'id', name: 'id', key: true, hidden: true},
            {label: '全称', name: 'fullName',width: 160, align:'left'},
            {label: '简称', name: 'shortName',width: 80, align:'left'},
            {label: '编码', name: 'code',width: 100, align:'center'},
            {label: '联系人', name: 'linkman', align:'center',width: 80},
            {label: '联系电话', name: 'linkmanPhoneNo', align:'center',width: 100},
            {label: '联系人邮箱', name: 'linkmanEmail',width: 120, align:'left'},
            {label: '所在地', name: 'areaName',width: 80, align:'left'},
            {label: '操作',  width: 120,align:'center', formatter: function (value, options, row) {
            	var operationHtml = "<span class='center'><a href='javascript:void(0)' onclick='editPartner("+row.id+")'>编辑</a>";
                operationHtml += " <a href='javascript:void(0)' onclick='deletePartner(this)'>删除</a></span>";
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
    $("#queryPartnerBtn").click(function () {
        $(".overlay").show();
        setTimeout(function(){
            queryPartnerData();
            $(".overlay").hide();
        }, 100);
    });

    $("#addPartnerBtn").click(function(){
        companyPartnerAdd();
    });    
 });
function queryPartnerData(param){
	if(param==null || param==undefined){
		var fullName = $("#fullName").val();
        var shortName = $("#shortName").val();
        var code = $("#code").val();
        
        param = {
        	fullName: fullName,
    		shortName: shortName,
    		code:code
        };
 	}
	$("#dataTables").jqGrid('setGridParam', {
        datatype: 'json',
        postData: param, //发送数据
        page: 1
    }).trigger("reloadGrid"); //重新载入
}

/**
 * common js
 */
$(function () {
  'use strict'

	toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "toast-top-center",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "500",
        "timeOut": "1500",
        "extendedTimeOut": "500",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
        }
});

/**
 * setting为json对象
 * {
 * 	pageUrl://加载的页面路径(必须)
 * 	title：对话框标题(不是必须)
 * 	handleUpdateDialog：function(dialogRef) (必须)点击修改按钮执行方法,dialogRef为对话框对象
 * }
 */
function updateDataDialog(setting){
	var baseUrl = window.localStorage.getItem("baseUrl");
	var title = setting.title;
    if(title=="" || title==undefined){
    	title = "编辑";
    }
	$.post(baseUrl+"/loginUserInfo", function(res){
		if(res && res.success){
			BootstrapDialog.show({
			    title:title,
			    closable: true,
			    closeByBackdrop: false,
			    closeByKeyboard: false,
			    size:BootstrapDialog.SIZE_NORMAL,
			    type:BootstrapDialog.TYPE_PRIMARY,
			    message: function(){
			    	return $('<div></div>').load(baseUrl+setting.pageUrl);
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
			        	setting.handleUpdateDialog(dialogRef);
			        }
			    }],
			    onshow:function(dialogRef){
			    	var $modalDialog = dialogRef.getModalDialog();
				    $modalDialog.css({
				        "position": "absolute",
				        "top": "50%",
				        "left": "50%",
				        "transform":"translate(-50%, -50%)",
				        "min-width":"50%",
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

/**
 * setting为json对象
 * {
 * 	pageUrl://加载的页面路径(必须)
 * 	title：对话框标题(不是必须)
 * 	handleAddDialog：function(dialogRef) (必须)点击修改按钮执行方法,dialogRef为对话框对象
 * }
 */
function addDataDialog(setting){
	var baseUrl = window.localStorage.getItem("baseUrl");
	var title = setting.title;
    if(title=="" || title==undefined){
    	title = "添加";
    }
	$.post(baseUrl+"/loginUserInfo", function(res){
		if(res && res.success){
			BootstrapDialog.show({
			    title:title,
			    closable: true,
			    closeByBackdrop: false,
			    closeByKeyboard: false,
			    size:BootstrapDialog.SIZE_NORMAL,
			    type:BootstrapDialog.TYPE_PRIMARY,
			    message: function(){
			    	return $('<div></div>').load(baseUrl+setting.pageUrl);
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
			        	setting.handleAddDialog(dialogRef);
			        }
			    }],
			    onshow:function(dialogRef){
			    	var $modalDialog = dialogRef.getModalDialog();
				    $modalDialog.css({
				        "position": "absolute",
				        "top": "50%",
				        "left": "50%",
				        "transform":"translate(-50%, -50%)",
				        "min-width":"50%",
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

/**
 * setting为json对象
 * {
 * 	tipsMsg：删除提示语 (不是必须)
 * 	handleDeletedDialog：function(dialogRef) (必须)点击修改按钮执行方法,dialogRef为对话框对象
 * }
 */
function deleteDataDialog(setting) {
	var baseUrl = window.localStorage.getItem("baseUrl");
    var tipsMsg = setting.tipsMsg;
    if(tipsMsg=="" || tipsMsg==undefined){
    	tipsMsg = "你确认删除 这条数据？";
    }
    $.post(baseUrl+"/loginUserInfo", function(res){ 
		if(res && res.success){
			BootstrapDialog.confirm({
		        title: '系统提示',
		        message: tipsMsg,
		        type: BootstrapDialog.TYPE_DANGER , // <-- Default value is BootstrapDialog.TYPE_PRIMARY
		        closable: true, // <-- Default value is false
		        closeByBackdrop: false,
		        closeByKeyboard: false,
		        draggable: true, // <-- Default value is false
		        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
		        btnOKLabel: '删除', // <-- Default value is 'OK',
		        btnOKClass: 'btn-danger', // <-- If you didn't specify it, dialog type will be used,
		        callback: function(result) {
		            // result will be true if button was click, while it will be false if users close the dialog directly.
		            $.ajaxSettings.async = false;
		            if(result) {
		            	setting.handleDeletedDialog();
		            }
		            $.ajaxSettings.async = true;
		        },
		        onshow:function(dialogRef){
			    	var $modalDialog = dialogRef.getModalDialog();
				    $modalDialog.css({
				        "position": "absolute",
				        "top": "50%",
				        "left": "50%",
				        "transform":"translate(-50%, -50%)",
				        "min-width":"50%",
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


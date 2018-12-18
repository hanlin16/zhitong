function logout(url){
    BootstrapDialog.show({
        title: '系统提示',
        size: BootstrapDialog.SIZE_SMALL,
        message: '你正在退出系统，请确认',
        buttons:[{
            label: '取消',
            action: function(dialogRef){
                dialogRef.close();
            }
        }, {
            label: '退出',
            cssClass: 'btn btn-danger btn-sm',
            action: function(dialogRef){
                $.post(url+"/logout", function(data){
                    window.location.href=url +"/viewLogin";
                });
            }
        }],
        onshow:function(dialogRef){
	    	var $modalDialog = dialogRef.getModalDialog();
		    $modalDialog.css({
		        "position": "absolute",
		        "top": "50%",
		        "left": "40%",
		        "transform":"translate(-50%, -50%)",
		        "min-width":"30%",
		        "over-flow":"inherit",
		        "right":"inherit"
		    });
		  }
    });
}

function updatePassword(url){
	$.post(url+"/loginUserInfo", function(res){
		if(res && res.success){
			BootstrapDialog.show({
			    title:"修改密码",
			    closable: true,
			    closeByBackdrop: false,
			    closeByKeyboard: false,
			    size:BootstrapDialog.SIZE_NORMAL,
			    type:BootstrapDialog.TYPE_PRIMARY,
			    message: function(){
			    	return $('<div></div>').load(url+'/userUpPwd');
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
			            var validateNode = dialogRef.getModalBody().find('#passWdForm');
			            var validFlag = validateNode.valid();
			            if(validFlag){
			                dialogRef.enableButtons(false);
			                $.ajaxSettings.async = false;
			                var userData = validateNode.serialize();
			                $.post(url+"/user/userUpdatePwd", userData, function(data){
			                    if(data.success){
			                        toastr["success"]("更改密码成功");
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
			 toastr["error"](data.errorMsg);
		}
	});
}
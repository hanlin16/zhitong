<script type="text/javascript">
$.validator.setDefaults( {
    submitHandler: function () {
        
    }
} );

function compareDate(s1){
  return ((new Date(s1.replace(/-/g,"\/")))>new Date());
}
		$(function(){
			validate();
			$("#startTime").datetimepicker("remove");
		    $("#startTime").datetimepicker({
		    	format: 'yyyy-mm-dd',
		        language:'zh-CN',
		        autoclose: true,
		        startView: 2,
		        minView: 2
		    }).on("changeDate", function() {
		        var value = $("#startTime").val();
		        $("#endTime").datetimepicker("remove");
		        $("#endTime").datetimepicker({
		        	format: 'yyyy-mm-dd',
		            language:'zh-CN',
		            autoclose: true,
		            startDate: compareDate(value)?new Date(value.replace(/-/g,"\/")):new Date(),
		            startView: 2,
		            minView: 2
		        })
		    });
		    $("#endTime").datetimepicker("remove");
		    $("#endTime").datetimepicker({
		    	format: 'yyyy-mm-dd',
		        language:'zh-CN',
		        autoclose: true,
		        startDate: new Date(),
		        startView: 2,
		        minView: 2
		    }).on("changeDate", function() {
		    	var value = $("#endTime").val();
		        $("#startTime").datetimepicker("remove");
		        $("#startTime").datetimepicker({
		        	format: 'yyyy-mm-dd',
		            language:'zh-CN',
		            autoclose: true,
		            endDate: value,
		            startView: 2,
		            minView: 2
		        })
		    });
			var baseUrl = window.localStorage.getItem("baseUrl");
		    $.post(baseUrl+"/deviceType/queryDeviceTypeList", function(data){
		        if(data.success){
		        	console.log(data);
		        	$.each(data.data, function(index, item){
		        		$("#inputDeviceType").append('<option value='+item.code+'>'+item.name+'</option>');
		        	});
		        }else{
		            toastr["error"](data.errorMsg);
		        }
		    });
		});
		function validate() {
			$( "#saleActionDataForm" ).validate( {
				rules: {
					startTime: {
						required: true						
					},
					endTime: {
						required: true						
					},
					channelCode: {
						required: true						
					},
					deviceType: {
						required: true
					}
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.parents( ".col-sm-5" ).addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
			} );
		} 
</script>
<form id="saleActionDataForm" method="post" class="form-horizontal" action="">
	<div class="form-group">
		<label class="col-sm-4 control-label" autocomplete="off" for="inputCode">活动码：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" readonly="readonly" id="inputCode" name="code" placeholder="请输入活动码" value="${fourCode.code}" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="startTime">生效时间：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" readonly="readonly" id="startTime" readonly name="startTime" placeholder="请输入生效时间" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="endTime">失效时间：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" readonly="readonly" id="endTime" name="endTime" placeholder="请输入失效时间" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputChannelCode">渠道名称：</label>
		<div class="col-sm-5">
			<select class="form-control" id="inputChannelCode" name="channelCode" >
				<option disabled="disabled" selected="selected">请选择</option>
				<#list channelList as saleChannel>
					<option value="${saleChannel.code}">${saleChannel.name}</option>
				</#list>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputDeviceType">设备类型：</label>
		<div class="col-sm-5">
			<select class="form-control" id="inputDeviceType" name="deviceType" >
				<option disabled="disabled" selected="selected">请选择</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputRemark">备注：</label>
		<div class="col-sm-5">
			<textarea class="form-control" id="inputRemark" name="remark" placeholder="请输入备注" />
		</div>
	</div>
</form>


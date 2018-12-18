<script type="text/javascript">
$.validator.setDefaults( {
    submitHandler: function () {
        
    }
} );
		$(function(){
			validate();
			
		});
		function validate() {
			$( "#saleChannelDataForm" ).validate( {
				rules: {
					name: {
						required: true,
						minlength: 2
					},
					partnerCode: {
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
<form id="saleChannelDataForm" method="post" class="form-horizontal" action="">
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputName">渠道名称：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputName" name="name" placeholder="请输入渠道名称" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputPartnerCode">合作伙伴：</label>
		<div class="col-sm-5">
			<select class="form-control" id="inputPartnerCode" name="partnerCode" >
				<option disabled="disabled" selected="selected">请选择</option>
				<#list partnerList as companyPartner>
					<option value="${companyPartner.code}">${companyPartner.shortName}</option>
				</#list>
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


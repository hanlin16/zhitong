<script type="text/javascript">
$.validator.setDefaults( {
    submitHandler: function () {
        
    }
} );
		$(function(){
			validate();
		});
		function validate() {
			$( "#passWdForm" ).validate( {
				rules: {
					oldPassword: {
						required: true,
						minlength: 6
					},
					newPassword: {
						required: true,
						minlength: 6
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
<form id="passWdForm" method="post" class="form-horizontal" action="">
	<input type="hidden"   name="userId" value="${currentUser.id }"/>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputOldPassword">原密码：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputOldPassword" name="oldPassword" placeholder="请输入密码" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputNewPassword">新密码：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputNewPassword" name="newPassword" placeholder="请输入密码" />
		</div>
	</div>
</form>


<script type="text/javascript">
$.validator.setDefaults( {
    submitHandler: function () {
        
    }
} );
		$(function(){
			validate();
		});
		function validate() {
			$( "#userDataForm" ).validate( {
				rules: {
					userName: {
						required: true,
						minlength: 2
					},
					phoneNo: {
						required: true,
						digits:true,
						minlength: 11,
						maxlength:11
					},
					loginName: {
						required: true,
						minlength: 4
					},
					password: {
						required: true,
						minlength: 6
					},
					email: {
						required: true,
						email: true
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
<form id="userDataForm" method="post" class="form-horizontal" action="">
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputUserName">用户名：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputUserName" name="userName" placeholder="请输入用户名" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputPhoneNo">手机号：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" maxlength="11" id="inputPhoneNo" name="phoneNo" placeholder="请输入手机号" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputEmail">邮箱：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputEmail" name="email" placeholder="请输入邮箱" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputLoginName">登录名：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputLoginName" name="loginName" placeholder="请输入登录名" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputPassword">登录密码：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputPassword" name="password" placeholder="请输入密码" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputManager">管理员：</label>
		<div class="col-sm-2">
			<select name="manager" id="inputManager" class="form-control">
				<option value="1">是</option>
				<option value="0">否</option>
			</select>
		</div>
	</div>
</form>


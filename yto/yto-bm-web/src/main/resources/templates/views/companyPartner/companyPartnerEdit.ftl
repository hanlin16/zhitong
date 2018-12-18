<script type="text/javascript">
$.validator.setDefaults( {
    submitHandler: function () {
        
    }
} );
$(function() {
	validate();
	var baseUrl = window.localStorage.getItem("baseUrl");
	var provinceSelect = $('.select2').select2({
			language: "zh-CN",
			ajax: {
				url: baseUrl+'/province/queryProvinceList',
				type:'POST',
				minimumInputLength: 1,
				data: function(params) {
					var queryWorld = params.term;
					if((/[\u4e00-\u9fa5]+/).test(queryWorld)){
						var query = {
							province: params.term,
							page: params.page || 1
						}
						return query;
					} else {
						var query = {
							spelling: params.term,
							page: params.page || 1
						}
						return query;
					}
				},
				processResults: function (data, params) {
			      var dataList = $.map(data.dataList, function (obj) {
					  obj.id = obj.proIdGb ; 
					  obj.text = obj.province; 
					  return obj;
					});
					params.page = params.page || 1;
			      return {
			        results: dataList,
			        pagination: {
			            more: (params.page * 10) < data.page.rowCount
			        }
			      };
			    },
			    cache: true
			}
	});
	provinceSelect.append(new Option('${companyPartner.areaName }', '${companyPartner.areaCode }', false, true));
	 $.validator.addMethod("checkPhone",function(value,element,params){ 
	  var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
	  return this.optional(element)||(myreg.test(value)); 
	},"请输入正确的手机号！"); 
});
function validate() {
	$( "#companyPartnerDataForm" ).validate( {
		rules: {
			fullName: {
				required: true,
				minlength: 2,
				maxlength:64
			},
			shortName: {
				required: true,
				minlength: 1,
				maxlength:32
			},			
			linkman: {
				required: true,
				minlength: 1,
				maxlength:32
			},
			linkmanPhoneNo: {
				required: true,
				checkPhone: true
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
<form id="companyPartnerDataForm" method="post" class="form-horizontal" action="">
	<input type="hidden" class="form-control"  name="id" value="${companyPartner.id }"/>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputFullName">全称：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputFullName" name="fullName" placeholder="请输入全称" value="${companyPartner.fullName }"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputShortName">简称：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputShortName" name="shortName" placeholder="请输入简称" value="${companyPartner.shortName }"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputAreaCode">区域：</label>
		<div class="col-sm-5">
			<select class="form-control select2" style="width: 100%;" id="inputAreaCode" name="areaCode"></select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputLinkman">联系人：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputLinkman" name="linkman" placeholder="请输入联系人" value="${companyPartner.linkman }"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputLinkmanPhoneNo">联系电话：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputLinkmanPhoneNo" name="linkmanPhoneNo" placeholder="请输入联系电话" maxlength="11" value="${companyPartner.linkmanPhoneNo }"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4 control-label" for="inputLinkmanEmail">联系人邮箱：</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="inputLinkmanEmail" name="linkmanEmail" placeholder="请输入邮箱" value="${companyPartner.linkmanEmail }"/>
		</div>
	</div>
</form>


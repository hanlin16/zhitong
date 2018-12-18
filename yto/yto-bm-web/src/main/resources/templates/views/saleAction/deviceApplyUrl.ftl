<script>
$(function () {
	$("[data-toggle='tooltip']").tooltip({'trigger':'click'});
	var btn = $("#copyUrlBtn")[0];
	var clipboard = new ClipboardJS(btn);
	$("#copyUrlBtn").on('click', function(){
		$('#copyUrlBtn').tooltip('show');
		window.setTimeout(function(){
			$('#copyUrlBtn').tooltip('hide');
		},500);
	});
});
</script>
<style type="text/css">
	td{
		
	}
</style>
<table class="table table-bordered" style="margin-bottom:0px;">
	<tr>
		<td style="vertical-align: middle; width:100px;">URL</td>
		<td >
			<p id="applyUrlNode">
				${deviceApplyUrlView}
			</p>
		</td >
		<td style="vertical-align: middle;">
			<button id="copyUrlBtn" data-clipboard-action="copy" data-clipboard-target="#applyUrlNode" type="button" data-toggle="tooltip" data-placement="bottom" title="复制成功" class="form-control btn btn-default pull-right">复制</button>
		</td>
	</tr>
	<tr>
		<td style="vertical-align: middle;">二维码</td>
		<td>
			<img class="center-block" style="width:200px; height:200px;"
				src="/saleAction/generateQrCode?deviceApplyUrl=${deviceApplyUrl}"></img>
		</td>
		<td style="vertical-align: middle;">
			<a id="downloadQrCodeBtn" href="/saleAction/generateQrCode?deviceApplyUrl=${deviceApplyUrl}" download="二维码图片.png" type="button" class="form-control btn btn-default pull-right">保存</a>
		</td>
	</tr>
</table>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>show name</title>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<body>
	<center>
		<form action="api/shop" method="post" name="upload" enctype="multipart/form-data" onsubmit="formSubmit()">
			<table>
				<tr>
					<td colspan="2">添加商品</td>
				</tr>
				<tr>
					<td>店铺名字：</td>
					<td><input type="text" name="shopName"></td>
				</tr>
				<tr>
					<td>店铺ID：</td>
					<td><input type="text" name="shopId"></td>
				</tr>
				<tr>
					<td>商品&nbsp;ID(9位):</td>
					<td><input type="text" name="goodId"></td>
				</tr>
				<tr>
					<td>商品&nbsp;种类1:</td>
					<td><input type="text" name="catg1"></td>
				</tr>
				<tr>
					<td>商品&nbsp;种类2:</td>
					<td><input type="text" name="catg2"></td>
				</tr>
				<tr>
					<td>商品&nbsp;名:</td>
					<td><input type="text" name="goodName"></td>
				</tr>
				<tr>
					<td>商品&nbsp;描述:</td>
					<td><input type="text" name="goodDesc"></td>
				</tr>
				<tr>
					<td>商品&nbsp;默认选择:</td>
					<td><input type="text" name="goodSelect"></td>
				</tr>
				<tr>
					<td>商品&nbsp;价格:</td>
					<td><input type="text" name="goodPrice"></td>
				</tr>
				<tr>
					<td>商品&nbsp;图片:</td>
					<td><input type="file" name="goodImg" value="选择"></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" name="提交" value="提交">
					<input type="reset" name="重置" value="重置">
				</tr>
			</table>
		</form>
	</center>
</body>
<script type="text/javascript">
function formSubmit(){
    var action="api/shop";       
    action+="?shopName="+document.upload.shopName.value + "&goodId="+document.upload.goodId.value + 
    	"&goodName="+document.upload.goodName.value + "&goodDesc="+document.upload.goodDesc.value + 
    	"&goodPrice="+document.upload.goodPrice.value + 
    	"&catg1="+document.upload.catg1.value + "&catg2="+document.upload.catg2.value +
    	"&shopId="+document.upload.shopId.value + "&goodSelect="+document.upload.goodSelect.value;
    alert(action);
    document.upload.action=action;      
    document.upload.submit();
}
</script>
</html>

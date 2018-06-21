<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
<head>
<title>show name</title>
</head>
<body>
	<center>
		<form action="/api/doPostGood" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td colspan="2">添加商品</td>
				</tr>
				<tr>
					<td>店铺名字：</td>
					<td><input type="text" name="shopName"></td>
				</tr>
				<tr>
					<td>商品&nbsp;ID(9位):</td>
					<td><input type="text" name="goodId"></td>
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
</html>

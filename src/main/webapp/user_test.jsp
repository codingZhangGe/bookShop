<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table cellspacing="1" cellpadding="4" border="1" valign="bottom" id="id_table" >
		
		<tr id="id_tr">
			<td colspan="15" align="right">
				<input type="button" name="na_button" id="id_button" value="提交" onclick="tsetButton()" />
			</td>
		</tr>
	</table>
</body>
	<script type="text/javascript">
		function tsetButton(){
			var msg = {"status":0,"message":"成功","data":
			{"totalSize":3,"pageData":
				[
					{"bookId":"e74a3ad8efa14d45b32c4c8f4ee0f302",
						"bookName":"恰到好处的幸福","bookState":"有货","currentPrice":50,
						"discount":100,"browseCount":0,"buyCount":0,"categoryName":"作品集",
					"urlList":"http://7xti7f.com2.z0.glb.clouddn.com/f5c4dff07ff34dceb2c5959bc8b336e8.jpg",
					"price":50
					},
					{"bookId":"347442f63422436bb6dbe5790f4fa37a","bookName":"买不到的味道","bookState":"有货",
						"currentPrice":40,"discount":100,"browseCount":1,"buyCount":1,"categoryName":"文艺",
						"urlList":"http://7xti7f.com2.z0.glb.clouddn.com/3b9c993f1fd04df4939fc106e68553f6.jpg",
						"price":40
					},
					{"bookId":"f728131a2b004c6b8fa0b19e474e2d11","bookName":"白说","bookState":"有货","currentPrice":45,
						"discount":90,"browseCount":0,"buyCount":1,"categoryName":"励志",
						"urlList":"http://7xti7f.com2.z0.glb.clouddn.com/1580f827f81145a1910eed87b8822784.jpg",
						"price":50
					}
				]
			}
			};
			//开始赋值
			/* var tr=document.createElement("tr");
			var table=document.getElementById("id_table");
			var	lastTr=document.getElementById("id_tr");
			table.insertBefore(tr, lastTr);
			
			for(var i=0; i<15; i++){
				var td=document.createElement("td");
				
			} */
			//alert(msg.message);status
			alert(msg.data);
			var data = msg.data;
			alert(data.totalSize);
			/* for ( var attr in msg.data) {
				totalSize
			} */
			
			
		}

	</script>
</html>
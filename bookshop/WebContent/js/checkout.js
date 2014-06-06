$(document).ready(function(){ 
	var price =  $("#price").text().substr(6);
	$('#equalSelect').change(function(){ 
		$("#discountSelect").get(0).selectedIndex = 0;
			var equalValue = $(this).children('option:selected').text();//这就是selected的值 
			if (equalValue == 'Not Use Now') {
				$("#price").text("Total:" + price);
				$("#totalPrice").val(price);
			} else {
				var newPrice = price - equalValue;
				var result = Math.round(newPrice*100)/100;
				$("#price").text("Total:" + result);
				$("#totalPrice").val(result);
			}
	});
	
	$('#discountSelect').change(function(){
		$("#equalSelect").get(0).selectedIndex = 0;
		var discount = $(this).children('option:selected').text();//这就是selected的值 
		if (discount == 'Not Use Now') {
			$("#price").text("Total:" + price);
			$("#totalPrice").val(price);
		} else {
			var newPrice = price * discount;
			var result = Math.round(newPrice*100)/100;
			$("#price").text("Total:" + result);
			$("#totalPrice").val(result);
		}
	});
});
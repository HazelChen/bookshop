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
				$("#price").text("Total:" + newPrice);
				$("#totalPrice").val(newPrice);
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
			$("#price").text("Total:" + newPrice);
			$("#totalPrice").val(newPrice);
		}
	});
});
$(function () {
	var equalData=eval(document.getElementById("equalData").innerHTML);
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'equal',
            type: 'pie'
		    },
        title :{
            text:'Equal Coupons Usage'
        },
        plotOptions: {
            pie: {
                startAngle: -90,
                endAngle:90,  
                center: ['50%', '70%']
            }
        },
        series: [{
            data: equalData
        }]
    });
});

$(function () {
	var discountData=eval(document.getElementById("discountData").innerHTML);
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'discount',
            type: 'pie'
		    },
        title :{
            text:'Discount Coupons Usage'
        },
        plotOptions: {
            pie: {
                startAngle: -90,
                endAngle:90,  
                center: ['50%', '70%']
            }
        },
        series: [{
            data: discountData
        }]
    });
});
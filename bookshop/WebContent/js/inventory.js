$(function () {
	var data=eval(document.getElementById("data").innerHTML);
	
	 $('#chart').highcharts({
	        title: {
	            text: 'ABC Analyse Chart',
	            x: -20 //center
	        },
	        subtitle: {
	            text: '',
	            x: -20
	        },
	        xAxis: {
	        },
	        yAxis: {
	            title: {
	                text: 'Funds Used Cumulative Average Percentage'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        tooltip: {
	            valueSuffix: ''
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	        series: [{
	            name: 'Newest',
	            data: data
	        }]
	    });
	
});
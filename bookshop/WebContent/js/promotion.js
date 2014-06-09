$(function () {
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'equal',
            type: 'pie'
		    },
        title :{
            text:'startAngle=-90 and endAngle=90'
        },
        plotOptions: {
            pie: {
                startAngle: -90,
                endAngle:90,  
                center: ['50%', '70%']
            }
        },
        series: [{
            data: [
                ['Firefox',   44.2],
                ['IE7',       26.6],
                ['IE6',       20],
                ['Chrome',    3.1],
                ['Other',    5.4]
			]
        }]
    });
});

$(function () {
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'discount',
            type: 'pie'
		    },
        title :{
            text:'startAngle=-90 and endAngle=90'
        },
        plotOptions: {
            pie: {
                startAngle: -90,
                endAngle:90,  
                center: ['50%', '70%']
            }
        },
        series: [{
            data: [
                ['Firefox',   44.2],
                ['IE7',       26.6],
                ['IE6',       20],
                ['Chrome',    3.1],
                ['Other',    5.4]
			]
        }]
    });
});
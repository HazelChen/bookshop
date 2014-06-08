$(function () {
	var userAddData=eval(document.getElementById("userAddData").innerHTML);
	 $('#userAdd').highcharts({
	        chart: {
	            type: 'area'
	        },
	        title: {
	            text: 'The Number of New Users'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            labels: {
	                formatter: function() {
	                    return this.value; // clean, unformatted number for year
	                }
	            }
	        },
	        yAxis: {
	            title: {
	                text: 'Number'
	            },
	            labels: {
	                formatter: function() {
	                    return this.value;
	                }
	            }
	        },
	        tooltip: {
	            pointFormat: '{point.y}'
	        },
	        plotOptions: {
	            area: {
	                pointStart: 1,
	                marker: {
	                    enabled: false,
	                    symbol: 'circle',
	                    radius: 1,
	                    states: {
	                        hover: {
	                            enabled: true
	                        }
	                    }
	                }
	            }
	        },
	        series: [{
	            name: '',
	            data: userAddData
	        }]
	    });
});

$(function () {
	var userAddressCategory=eval(document.getElementById("userAddressCategory").innerHTML);
	var userAddressData=eval(document.getElementById("userAddressData").innerHTML);
	$('#userAddress').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'The Provinces of Users'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: userAddressCategory
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span>',
            pointFormat: '{point.y}',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '',
            data: userAddressData
        }]
    });
});

$(function () {
	var data=eval(document.getElementById("userAgeData").innerHTML);
    $('#userAge').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'User Age Analyse'
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: data,
        }]
    });
});

$(function () {
	var data=eval(document.getElementById("userGenderData").innerHTML);
    $('#userGender').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'User Gender Analyse'
        },
        xAxis: {
            categories: ['Male', 'Female'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ''
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -40,
            y: 100,
            floating: true,
            borderWidth: 1,
            backgroundColor: '#FFFFFF',
            shadow: true
        },
        credits: {
            enabled: false
        },
        series: [{
            name: '',
            data: data
        }]
    });
});
const width_threshold = 480;

function drawLineChart() {
	if ($("#lineChart").length) {
		ctxLine = document.getElementById("lineChart").getContext("2d");
		optionsLine = {
			scales: {
				yAxes: [
					{
						scaleLabel: {
							display: true,
							labelString: "Hits"
						}
					}
				]
			}
		};

		// Set aspect ratio based on window width
		optionsLine.maintainAspectRatio =
			$(window).width() < width_threshold ? false : true;

		configLine = {
			type: "line",
			data: {
				labels: [
					"January",
					"February",
					"March",
					"April",
					"May",
					"June",
					"July"
				],
				datasets: [
					{
						label: "Latest Hits",
						data: [88, 68, 79, 57, 50, 55, 70],
						fill: false,
						borderColor: "rgb(75, 192, 192)",
						cubicInterpolationMode: "monotone",
						pointRadius: 0
					},
					{
						label: "Popular Hits",
						data: [33, 45, 37, 21, 55, 74, 69],
						fill: false,
						borderColor: "rgba(255,99,132,1)",
						cubicInterpolationMode: "monotone",
						pointRadius: 0
					},
					{
						label: "Featured",
						data: [44, 19, 38, 46, 85, 66, 79],
						fill: false,
						borderColor: "rgba(153, 102, 255, 1)",
						cubicInterpolationMode: "monotone",
						pointRadius: 0
					}
				]
			},
			options: optionsLine
		};

		lineChart = new Chart(ctxLine, configLine);
	}
}
function drawBarChart(labels, values, colors, xAxe, yAxe) {
	ctxBar = document.getElementById("barChart").getContext("2d");
	var myChart = new Chart(ctxBar, {
		type: 'horizontalBar',
		data: {
			labels: labels,
			datasets: [{
				label: xAxe,
				data: values,
				backgroundColor: colors,
				// borderColor: none,
				borderWidth: 1
			}]
		},
		options: {
			scales: {
				y: {
					beginAtZero: true
				}
			}
		}
	});
}


function drawBarChart2(labels, values, colors, xAxe, yAxe) {
	if ($("#barChart").length) {
		ctxBar = document.getElementById("barChart").getContext("2d");

		optionsBar = {
			responsive: false,
			scales: {
				yAxes: [
					{
						barPercentage: 0.1,
						categoryPercentage: 1.0,

						ticks: {
							beginAtZero: true
						},
						scaleLabel: {
							display: true,
							labelString: xAxe
						}
					}
				]
			}
		};

		// optionsBar.maintainAspectRatio =
		// 	$(window).width() < width_threshold ? false : true;

		configBar = {
			type: "bar",
			data: {
				labels: values,
				datasets: [
					{
						label: yAxe,
						data: labels,
						backgroundColor: blue,
						borderWidth: 0
					}
				]
			},
			options: optionsBar
		};

		barChart = new Chart(ctxBar, configBar);
	}
}

function drawPieChart(labels, values, colors, chartID) {
	if ($("#" + chartID).length) {
		var chartHeight = 300;

		$("#" + chartID + "Container").css("height", chartHeight + "px");

		ctxPie = document.getElementById(chartID).getContext("2d");

		optionsPie = {
			responsive: true,
			maintainAspectRatio: false,
			layout: {
				padding: {
					left: 10,
					right: 10,
					top: 10,
					bottom: 10
				}
			},
			legend: {
				position: "top"
			}
		};

		configPie = {
			type: "pie",
			data: {
				datasets: [
					{
						data: values,
						backgroundColor: colors,
						label: "Storage"
					}
				],
				labels: labels
			},
			options: optionsPie
		};

		pieChart = new Chart(ctxPie, configPie);
	}
}

function updateLineChart() {
	if (lineChart) {
		lineChart.options = optionsLine;
		lineChart.update();
	}
}

function updateBarChart() {
	if (barChart) {
		barChart.options = optionsBar;
		barChart.update();
	}
}

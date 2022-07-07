const width_threshold = 480;

function RoomChart1() {
    if ($("#RoomChart").length) {
        ctxLine = document.getElementById("RoomChart").getContext("2d");
        const data = {
            labels: [
                'Red',
                'Blue',
                'Yellow'
            ],
            datasets: [{
                    label: 'My First Dataset',
                    data: [300, 50, 100],
                    backgroundColor: [
                        'rgb(255, 99, 132)',
                        'rgb(54, 162, 235)',
                        'rgb(255, 205, 86)'
                    ],
                    hoverOffset: 4
                }]
        };
        const config = {
            type: 'pie',
            data: data,
        };
//        optionsLine = {
//            scales: {
//                yAxes: [
//                    {
//                        scaleLabel: {
//                            display: true,
//                            labelString: "Hits"
//                        }
//                    }
//                ]
//            }
//        };
//
//        // Set aspect ratio based on window width
//        optionsLine.maintainAspectRatio =
//                $(window).width() < width_threshold ? false : true;
//
//        configLine = {
//            type: "line",
//            data: {
//
//                datasets: [
//                    {
//                        label: "Latest Hits",
//                        data: [880, 680, 790, 570, 500, 550, 700],
//                        fill: false,
//                        borderColor: "rgb(75, 192, 192)",
//                        cubicInterpolationMode: "monotone",
//                        pointRadius: 0
//                    },
//                    {
//                        label: "Popular Hits",
//                        data: [33, 45, 37, 21, 55, 74, 69],
//                        fill: false,
//                        borderColor: "rgba(255,99,132,1)",
//                        cubicInterpolationMode: "monotone",
//                        pointRadius: 0
//                    },
//                    {
//                        label: "Featured",
//                        data: [44, 19, 38, 46, 85, 66, 79],
//                        fill: false,
//                        borderColor: "rgba(153, 102, 255, 1)",
//                        cubicInterpolationMode: "monotone",
//                        pointRadius: 0
//                    }
//                ]
//            },
//            options: optionsLine
//        };

        RoomChart = new Chart(ctxLine, config);
    }
}
//
//function drawBarChart() {
//    if ($("#barChart").length) {
//        ctxBar = document.getElementById("barChart").getContext("2d");
//
//        optionsBar = {
//            responsive: true,
//            scales: {
//                yAxes: [
//                    {
//                        barPercentage: 0.2,
//                        ticks: {
//                            beginAtZero: true
//                        },
//                        scaleLabel: {
//                            display: true,
//                            labelString: "Hits"
//                        }
//                    }
//                ]
//            }
//        };
//
//        optionsBar.maintainAspectRatio =
//                $(window).width() < width_threshold ? false : true;
//
//        /**
//         * COLOR CODES
//         * Red: #F7604D
//         * Aqua: #4ED6B8
//         * Green: #A8D582
//         * Yellow: #D7D768
//         * Purple: #9D66CC
//         * Orange: #DB9C3F
//         * Blue: #3889FC
//         */
//
//        configBar = {
//            type: "horizontalBar",
//            data: {
//                labels: ["Red", "Aqua", "Green", "Yellow", "Purple", "Orange", "Blue"],
//                datasets: [
//                    {
//                        label: "# of Hits",
//                        data: [33, 40, 28, 49, 58, 38, 44],
//                        backgroundColor: [
//                            "#F7604D",
//                            "#4ED6B8",
//                            "#A8D582",
//                            "#D7D768",
//                            "#9D66CC",
//                            "#DB9C3F",
//                            "#3889FC"
//                        ],
//                        borderWidth: 0
//                    }
//                ]
//            },
//            options: optionsBar
//        };
//
//        barChart = new Chart(ctxBar, configBar);
//    }
//}
//
//function drawPieChart() {
//    if ($("#pieChart").length) {
//        var chartHeight = 300;
//
//        $("#pieChartContainer").css("height", chartHeight + "px");
//
//        ctxPie = document.getElementById("pieChart").getContext("2d");
//
//        optionsPie = {
//            responsive: true,
//            maintainAspectRatio: false,
//            layout: {
//                padding: {
//                    left: 10,
//                    right: 10,
//                    top: 10,
//                    bottom: 10
//                }
//            },
//            legend: {
//                position: "top"
//            }
//        };
//
//        configPie = {
//            type: "pie",
//            data: {
//                datasets: [
//                    {
//                        data: [18.24, 6.5, 9.15],
//                        backgroundColor: ["#F7604D", "#4ED6B8", "#A8D582"],
//                        label: "Storage"
//                    }
//                ],
//                labels: [
//                    "Used Storage (18.240GB)",
//                    "System Storage (6.500GB)",
//                    "Available Storage (9.150GB)"
//                ]
//            },
//            options: optionsPie
//        };
//
//        pieChart = new Chart(ctxPie, configPie);
//    }
//}
//
//function updateLineChart() {
//    if (lineChart) {
//        lineChart.options = optionsLine;
//        lineChart.update();
//    }
//}
//
//function updateBarChart() {
//    if (barChart) {
//        barChart.options = optionsBar;
//        barChart.update();
//    }
//}

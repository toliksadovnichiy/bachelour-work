function createFullChart(fieldName, seriesName, data, chartName){

    am5.ready(function() {
        // Create root element
        var root = am5.Root.new(chartName);

        // Set themes
        root.setThemes([
            am5themes_Animated.new(root)
        ]);

        // Create chart
        var chart = root.container.children.push(am5xy.XYChart.new(root, {
            panX: true,
            panY: true,
            wheelX: "panX",
            wheelY: "zoomX",
            maxTooltipDistance: 0,
            pinchZoomX:true
        }));

        var date = new Date();
        date.setHours(0, 0, 0, 0);

        function generateData(i, fName) {
            am5.time.add(date, "day", 1);
            return {
                date: new Date(data[i]["date"]).getTime(),
                value: data[i][fName]
            };
        }

        function generateDatas(fName) {
            var tmp_data = [];
            for (var i = 0; i < data.length; ++i) {
                tmp_data.push(generateData(i, fName));
            }
            return tmp_data;
        }

        // Create axes
        var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
            maxDeviation: 0.2,
            baseInterval: {
                timeUnit: "day",
                count: 1
            },
            renderer: am5xy.AxisRendererX.new(root, {}),
            tooltip: am5.Tooltip.new(root, {})
        }));

        var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
            renderer: am5xy.AxisRendererY.new(root, {})
        }));

        // Add series
        function addSeries(fName, sName) {
            var series = chart.series.push(am5xy.LineSeries.new(root, {
                name: sName,
                xAxis: xAxis,
                yAxis: yAxis,
                valueYField: "value",
                valueXField: "date",
                legendValueText: "{valueY}",
                tooltip: am5.Tooltip.new(root, {
                    pointerOrientation: "horizontal",
                    labelText: "{valueY}"
                })
            }));

            date = new Date();
            date.setHours(0, 0, 0, 0);
            value = 0;

            var tmp_data = generateDatas(fName);
            series.data.setAll(tmp_data);

            // Make stuff animate on load
            series.appear();
        }

        for(var i=0; i<fieldName.length; i++) {
            addSeries(fieldName[i], seriesName[i]);
        }

        // Add cursor
        var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
            behavior: "none"
        }));
        cursor.lineY.set("visible", false);

        // Add scrollbar
        chart.set("scrollbarX", am5.Scrollbar.new(root, {
            orientation: "horizontal"
        }));

        chart.set("scrollbarY", am5.Scrollbar.new(root, {
            orientation: "vertical"
        }));

        // Add legend
        var legend = chart.rightAxesContainer.children.push(am5.Legend.new(root, {
            width: 200,
            paddingLeft: 15,
            height: am5.percent(100)
        }));

        // When legend item container is hovered, dim all the series except the hovered one
        legend.itemContainers.template.events.on("pointerover", function(e) {
            var itemContainer = e.target;

            // As series list is data of a legend, dataContext is series
            var series = itemContainer.dataItem.dataContext;

            chart.series.each(function(chartSeries) {
                if (chartSeries != series) {
                    chartSeries.strokes.template.setAll({
                        strokeOpacity: 0.15,
                        stroke: am5.color(0x000000)
                    });
                } else {
                    chartSeries.strokes.template.setAll({
                        strokeWidth: 3
                    });
                }
            })
        })

        // When legend item container is unhovered, make all series as they are
        legend.itemContainers.template.events.on("pointerout", function(e) {
            var itemContainer = e.target;
            var series = itemContainer.dataItem.dataContext;

            chart.series.each(function(chartSeries) {
                chartSeries.strokes.template.setAll({
                    strokeOpacity: 1,
                    strokeWidth: 1,
                    stroke: chartSeries.get("fill")
                });
            });
        })

        legend.itemContainers.template.set("width", am5.p100);
        legend.valueLabels.template.setAll({
            width: am5.p100,
            textAlign: "right"
        });

        // It's is important to set legend data after all the events are set on template, otherwise events won't be copied
        legend.data.setAll(chart.series.values);


        // Make stuff animate on load
        chart.appear(1000, 100);

    });// end am5.ready()

}

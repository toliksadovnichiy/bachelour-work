function createFullPieChart(chartName) {
    am5.ready(function() {

    // Create root element
    var root = am5.Root.new(chartName);

    // Set themes
    root.setThemes([
        am5themes_Animated.new(root)
        ]);

    // Create chart
    var chart = root.container.children.push(
        am5percent.PieChart.new(root, {
        endAngle: 270
    })
        );

    // Create series
    var series = chart.series.push(
        am5percent.PieSeries.new(root, {
        valueField: "value",
        categoryField: "category",
        endAngle: 270
    })
        );

    series.states.create("hidden", {
        endAngle: -90
    });

    // Set data
    series.data.setAll([{
        category: "0-17 років",
        value: 5.0
    }, {
        category: "18-29 років",
        value: 11.0
    }, {
        category: "30-49 років",
        value: 37.0
    }, {
        category: "50-69 років",
        value: 38.0
    }, {
        category: "70 років і більше",
        value: 9.0
    }]);

        series.appear(1000, 100);

    }); //
}// end am5.ready()

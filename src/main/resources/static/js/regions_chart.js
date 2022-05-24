<!-- Styles -->


<!-- Resources -->
    am5.ready(function() {

    // Create root element
    var root = am5.Root.new("chartdiv");


    // Set themes
    root.setThemes([
    am5themes_Animated.new(root)
    ]);


    // Create chart
    var chart = root.container.children.push(am5xy.XYChart.new(root, {
    panX: false,
    panY: false,
    wheelX: "panX",
    wheelY: "zoomX",
    layout: root.verticalLayout
}));


    // Add legend
    var legend = chart.children.push(am5.Legend.new(root, {
    centerX: am5.p50,
    x: am5.p50
}))



// Create axes
    var yAxis = chart.yAxes.push(am5xy.CategoryAxis.new(root, {
    categoryField: "region_name",
    renderer: am5xy.AxisRendererY.new(root, {
    inversed: true,
    cellStartLocation: 0.1,
    cellEndLocation: 0.9
})
}));

    yAxis.data.setAll(regions_data);

    var xAxis = chart.xAxes.push(am5xy.ValueAxis.new(root, {
    renderer: am5xy.AxisRendererX.new(root, {}),
    min: 0
}));


// Add series
    function createSeries(field, name) {
    var series = chart.series.push(am5xy.ColumnSeries.new(root, {
    name: name,
    xAxis: xAxis,
    yAxis: yAxis,
    valueXField: field,
    categoryYField: "region_name",
    sequencedInterpolation: true,
    tooltip: am5.Tooltip.new(root, {
    pointerOrientation: "horizontal",
    labelText: "[bold]{name}[/]\n{categoryY}: {valueX}"
})
}));

    series.columns.template.setAll({
    height: am5.p100
});


    series.bullets.push(function() {
    return am5.Bullet.new(root, {
    locationX: 1,
    locationY: 0.5,
    sprite: am5.Label.new(root, {
    centerY: am5.p50,
    text: "{valueX}",
    populateText: true
})
});
});

    series.bullets.push(function() {
    return am5.Bullet.new(root, {
    locationX: 1,
    locationY: 0.5,
    sprite: am5.Label.new(root, {
    centerX: am5.p100,
    centerY: am5.p50,
    text: "{name}",
    fill: am5.color(0xffffff),
    populateText: true
})
});
});

    series.data.setAll(regions_data);
    series.appear();

    return series;
}

    createSeries("population", "Населення");
    createSeries("infections", "Захворіло");


// Add legend
// https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
    var legend = chart.children.push(am5.Legend.new(root, {
    centerX: am5.p50,
    x: am5.p50
}));

    legend.data.setAll(chart.series.values);


// Add cursor
// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
    var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
    behavior: "zoomY"
}));
    cursor.lineY.set("forceHidden", true);
    cursor.lineX.set("forceHidden", true);


// Make stuff animate on load
// https://www.amcharts.com/docs/v5/concepts/animations/
    chart.appear(1000, 100);

}); // end am5.ready()

Readme test
He registrado esta Linea  <- no jueguen 
probando Julian Jaimes

public void init() {
        //createPieModel();
        createPolarAreaModel();
        createLineModel();
        createCartesianLinerModel();
        createBarModel();
        createBarModel2();
        createLineaTrampa();
        createHorizontalBarModel();
        createStackedBarModel();
        createStackedGroupBarModel();
        createRadarModel();
        createRadarModel2();
        createBubbleModel();
        createMixedModel();
        createDonutModel();
        //createScatterModel();
    }

     private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
         
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);
         
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
         
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
        data.setLabels(labels);
         
        pieModel.setData(data);
    }
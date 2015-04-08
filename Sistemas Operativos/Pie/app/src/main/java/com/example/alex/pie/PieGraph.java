package com.example.alex.pie;

import android.content.Context;

import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
/**
 * Created by Alex on 07/04/2015.
 */
public class PieGraph {

    public Intent getIntent(Context context) {

        int[] values = {1, 2, 3, 4, 5};
        int k = 0;

        CategorySeries series = new CategorySeries("Pie Graph");

        for (int value:  values) {
            series.add("Section" + (++k), value);
        }

        int[] colors = new int[] {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW,
                                 Color.CYAN};

        DefaultRenderer renderer = new DefaultRenderer();

        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }

        renderer.setChartTitle("Pie Chart Demo");
        renderer.setChartTitleTextSize(7);
        renderer.setZoomButtonsVisible(true);
        
        Intent intent = ChartFactory.getPieChartIntent(context, series, renderer, "Pie");

        return intent;
    }
}

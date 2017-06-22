package action;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;

/**
 * Created by white on 17/6/22.
 */
public class PieChartAction extends BaseAction{
    private JFreeChart chart;

    public JFreeChart getChart() {
        JFreeChart chart = ChartFactory.createPieChart("test pie", createDataSet(), true, true, false);
        chart.setTitle(new TextTitle("语种统计", new Font("Monoca", Font.ITALIC, 22)));
        LegendTitle legend = chart.getLegend(0);
        legend.setItemFont(new Font("Monoca", Font.BOLD, 15));
        PiePlot plot = (PiePlot)chart.getPlot();
        plot.setLabelFont(new Font("Monoca", Font.BOLD, 15));
        plot.setBackgroundAlpha(0.9f);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }

    private PieDataset createDataSet() {
        DefaultPieDataset set = new DefaultPieDataset();
        set.setValue("中文", 0.4);
        set.setValue("英文", 0.4);
        set.setValue("日文", 0.1);
        return set;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}

package action;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * Created by white on 17/6/22.
 */
public class BarChartAction extends BaseAction{
    private JFreeChart chart;

    public JFreeChart getChart() {
        JFreeChart chart = ChartFactory.createBarChart3D("test bar", null, "毫秒",  createDataset());
        chart.addSubtitle(new TextTitle("IDE启动时间", new Font("Monoca", Font.ITALIC, 22)));
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot)chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer)plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);

        return chart;
    }

    private  CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7445.0D, "IDEA", "第一种情况");
        dataset.addValue(24448.0D, "Eclipse", "第一种情况");
        dataset.addValue(4297.0D, "IDEA", "第二种情况");
        dataset.addValue(21022.0D, "Eclipse", "第二种情况");
        return dataset;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}

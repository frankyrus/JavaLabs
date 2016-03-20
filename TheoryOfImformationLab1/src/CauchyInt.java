import java.awt.Container;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.DoubleStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.Align;

import com.apple.eawt.Application;

import org.apache.commons.math3.distribution.CauchyDistribution;
import java.awt.Toolkit;

public class CauchyInt extends JFrame {
	private static final long serialVersionUID = 1L;
	String name;

	public CauchyInt() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Application application = Application.getApplication();
		Image image = Toolkit.getDefaultToolkit().getImage("24.png");
		application.setDockIconImage(image);

		JScrollPane sp = new JScrollPane();
		JTextArea textArea = new JTextArea();

		sp.setViewportView(textArea);
		sp.setAutoscrolls(true);

		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		final double ALPHA = 2.5D;

		//double sum = 0;
		
		final int ARRAY_SIZE = 2500;

		double[] r = new double[ARRAY_SIZE];
		CauchyDistribution cd = new CauchyDistribution(0, ALPHA);
		r = cd.sample(r.length);
		
		double sum = DoubleStream.of(r).sum();

		/*for (int i = 0; i < r.length; i++) {
			sum += r[i];
		} */

		Arrays.sort(r);

		textArea.append("Min r: " + r[0]);
		textArea.append("\nMax r: " + r[r.length - 1]);

		final double Mx = sum / r.length;
		textArea.append("\nMx: " + Mx);

		sum = 0;
		
		for (int i = 0; i < r.length; i++) {
			sum += Math.pow(r[i] - Mx, 2);
		}

		final double Dx = sum / r.length;
		textArea.append("\nDx: " + Dx);

		final double SD = Math.sqrt(Dx);
		textArea.append("\nSD: " + SD);

		HistogramDataset dataset = new HistogramDataset();
		dataset.setType(HistogramType.RELATIVE_FREQUENCY);
		dataset.addSeries("Cauchy2", r, 70, r[0], r[r.length - 1]);
		String plotTitle = "Cauchy Histogram";
		String xaxis = "Value";
		String yaxis = "Relative Frequency";
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		boolean show = false;
		boolean toolTips = false;
		boolean urls = true;

		JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis, yaxis, dataset, orientation, show, toolTips,
				urls);
		chart.setAntiAlias(true);

		BufferedImage img = ImageIO.read(new File("24.1.png"));
		chart.setBackgroundImage(img);
		chart.setBackgroundImageAlignment(Align.RIGHT);

		double tempsum = 0;

		XYSeries series1 = new XYSeries("Cumulative");
		for (int i = 0; i < dataset.getItemCount(0); i++) {
			tempsum += dataset.getYValue(0, i);
			series1.add((dataset.getStartXValue(0, i) + dataset.getEndXValue(0, i)) / 2, tempsum);
		}

		XYSeries series2 = new XYSeries("Approximation");
		for (int i = 0; i < dataset.getItemCount(0); i++) {
			series2.add((dataset.getStartXValue(0, i) + dataset.getEndXValue(0, i)) / 2, dataset.getYValue(0, i));
		}

		XYSeriesCollection dataset2 = new XYSeriesCollection();
		dataset2.addSeries(series1);
		dataset2.addSeries(series2);

		JFreeChart chart2 = ChartFactory.createXYAreaChart("Cumulative of Cauchy Histogram", "Value", "Probability",
				dataset2);

		// chart2.getXYPlot().setRenderer(new XYSplineRenderer());

		chart2.setAntiAlias(true);
		img = ImageIO.read(new File("24.png"));
		chart2.setBackgroundImage(img);
		chart2.setBackgroundImageAlignment(Align.LEFT);

		final ChartPanel chartPanelCouchy = new ChartPanel(chart);
		final ChartPanel chartPanelCumulative = new ChartPanel(chart2);

		Container pane = getContentPane();
		setContentPane(pane);
		Frame frame = new JFrame();
		setTitle("Fucking Cauchy");

		pane.setLayout(null);
		chartPanelCouchy.setBounds(10, 0, 650, 500);
		chartPanelCumulative.setBounds(670, 0, 650, 500);
		sp.setBounds(452, 510, 400, 70);
		setBounds(100, 100, 1325, 610);
		pane.add(chartPanelCouchy);
		pane.add(chartPanelCumulative);
		pane.add(sp);

		frame.pack();
	}
}
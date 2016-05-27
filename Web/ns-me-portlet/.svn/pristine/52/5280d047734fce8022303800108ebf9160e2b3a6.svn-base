package vn.dtt.sol.ns.portlet;

import java.awt.Color;
import java.util.List;

import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieRenderer {

	private Color[] color = null;
	public PieRenderer(Color[] colors) {
	this.color = colors;
	}
	
	public void setColor(PiePlot plot, DefaultPieDataset dataset) {
		List <Comparable> keys = dataset.getKeys();
		int aInt;
		for (int i = 0; i < keys.size(); i++)
		{
		aInt = i % this.color.length;
		plot.setSectionPaint(keys.get(i), this.color[aInt]);
		}
		}
	
}

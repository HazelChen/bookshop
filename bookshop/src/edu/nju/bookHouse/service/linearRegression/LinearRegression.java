package edu.nju.bookHouse.service.linearRegression;

import java.math.BigDecimal;

public class LinearRegression {

	private double sumX;
	private double sumY;
	/** sum of x*x */
	private double sumXX;
	/** sum of x*y */
	private double sumXY;
	/** sum of y*y */
	private double sumYY;

	private int XMin, XMax, YMin, YMax;

	/** line coefficient a0 */
	private float a0;
	/** line coefficient a1 */
	private float a1;

	/** number of data points */
	private int pn;
	/** true if coefficients valid */
	private boolean coefsValid;

	public LinearRegression(DataPoint data[]) {
		pn = 0;
		for (int i = 0; i < data.length; ++i) {
			addDataPoint(data[i]);
		}
	}

	/**
	 * Return the current number of data points.
	 * 
	 * @return the count
	 */
	public int getDataPointCount() {
		return pn;
	}

	/**
	 * Return the coefficient a0.
	 * 
	 * @return the value of a0
	 */
	public float getA0() {
		validateCoefficients();
		return a0;
	}

	/**
	 * Return the coefficient a1.
	 * 
	 * @return the value of a1
	 */
	public float getA1() {
		validateCoefficients();
		return a1;
	}

	/**
	 * Return the sum of the x values.
	 * 
	 * @return the sum
	 */
	public double getSumX() {
		return sumX;
	}

	/**
	 * Return the sum of the y values.
	 * 
	 * @return the sum
	 */
	public double getSumY() {
		return sumY;
	}

	/**
	 * Return the sum of the x*x values.
	 * 
	 * @return the sum
	 */
	public double getSumXX() {
		return sumXX;
	}

	/**
	 * Return the sum of the x*y values.
	 * 
	 * @return the sum
	 */
	public double getSumXY() {
		return sumXY;
	}

	public double getSumYY() {
		return sumYY;
	}

	public int getXMin() {
		return XMin;
	}

	public int getXMax() {
		return XMax;
	}

	public int getYMin() {
		return YMin;
	}

	public int getYMax() {
		return YMax;
	}

	/**
	 * Add a new data point: Update the sums.
	 * 
	 * @param dataPoint
	 *            the new data point
	 */
	public void addDataPoint(DataPoint dataPoint) {
		sumX += dataPoint.x;
		sumY += dataPoint.y;
		sumXX += dataPoint.x * dataPoint.x;
		sumXY += dataPoint.x * dataPoint.y;
		sumYY += dataPoint.y * dataPoint.y;

		if (dataPoint.x > XMax) {
			XMax = (int) dataPoint.x;
		}
		if (dataPoint.y > YMax) {
			YMax = (int) dataPoint.y;
		}

		// 把每个点的具体坐标存入ArrayList中，备用

//		xy[0] = (int) dataPoint.x + "";
//		xy[1] = (int) dataPoint.y + "";
//		if (dataPoint.x != 0 && dataPoint.y != 0) {
//			System.out.print(xy[0] + ",");
//			System.out.println(xy[1]);
//
//			try {
//				// System.out.println("n:"+n);
//				listX.add(pn, xy[0]);
//				listY.add(pn, xy[1]);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			/*
//			 * System.out.println("N:" + n);
//			 * System.out.println("ArrayList listX:"+ listX.get(n));
//			 * System.out.println("ArrayList listY:"+ listY.get(n));
//			 */
//		}
		++pn;
		coefsValid = false;
	}

	/**
	 * Return the value of the regression line function at x. (Implementation of
	 * Evaluatable.)
	 * 
	 * @param x
	 *            the value of x
	 * @return the value of the function at x
	 */
	public float at(int x) {
//		if (pn < 2)
//			return Float.NaN;

		validateCoefficients();
		return a0 + a1 * x;
	}

	public float at(float x) {
//		if (pn < 2)
//			return Float.NaN;

		validateCoefficients();
		return a0 + a1 * x;
	}

	/**
	 * Validate the coefficients. 计算方程系数 y=ax+b 中的a
	 */
	private void validateCoefficients() {
		if (coefsValid)
			return;

		if (pn >= 2) {
			float xBar = (float) sumX / pn;
			float yBar = (float) sumY / pn;

			a1 = (float) ((pn * sumXY - sumX * sumY) / (pn * sumXX - sumX
					* sumX));
			a0 = (float) (yBar - a1 * xBar);
		} else {
			a0 = a1 = Float.NaN;
		}

		coefsValid = true;
	}

	// 用于实现精确的四舍五入
	public double round(double v, int scale) {

		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	public float round(float v, int scale) {

		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).floatValue();

	}
}

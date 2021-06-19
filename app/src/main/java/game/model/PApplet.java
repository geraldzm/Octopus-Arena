package game.model;

/* -*- mode: java; c-basic-offset: 2; indent-tabs-mode: nil -*- */

/*
  Part of the Processing project - http://processing.org
  Copyright (c) 2012-15 The Processing Foundation
  Copyright (c) 2004-12 Ben Fry and Casey Reas
  Copyright (c) 2001-04 Massachusetts Institute of Technology
  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public
  License as published by the Free Software Foundation, version 2.1.
  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Lesser General Public License for more details.
  You should have received a copy of the GNU Lesser General
  Public License along with this library; if not, write to the
  Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA  02111-1307  USA
*/

import static game.model.PConstants.DEG_TO_RAD;
import static game.model.PConstants.RAD_TO_DEG;

public class PApplet {

    /**
     * ( begin auto-generated from lerp.xml )
     *
     * Calculates a number between two numbers at a specific increment. The
     * <b>amt</b> parameter is the amount to interpolate between the two values
     * where 0.0 equal to the first point, 0.1 is very near the first point,
     * 0.5 is half-way in between, etc. The lerp function is convenient for
     * creating motion along a straight path and for drawing dotted lines.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param start first value
     * @param stop second value
     * @param amt float between 0.0 and 1.0
     * @see PVector#lerp(PVector, float)
     */
    static public final float lerp(float start, float stop, float amt) {
        return start + (stop-start) * amt;
    }



    /**
     * ( begin auto-generated from sin.xml )
     *
     * Calculates the sine of an angle. This function expects the values of the
     * <b>angle</b> parameter to be provided in radians (values from 0 to
     * 6.28). Values are returned in the range -1 to 1.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param angle an angle in radians
     * @see PApplet#cos(float)
     * @see PApplet#tan(float)
     * @see PApplet#radians(float)
     */
    static public final float sin(float angle) {
        return (float)Math.sin(angle);
    }

    /**
     * ( begin auto-generated from cos.xml )
     *
     * Calculates the cosine of an angle. This function expects the values of
     * the <b>angle</b> parameter to be provided in radians (values from 0 to
     * PI*2). Values are returned in the range -1 to 1.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param angle an angle in radians
     * @see PApplet#sin(float)
     * @see PApplet#tan(float)
     * @see PApplet#radians(float)
     */
    static public final float cos(float angle) {
        return (float)Math.cos(angle);
    }

    /**
     * ( begin auto-generated from tan.xml )
     *
     * Calculates the ratio of the sine and cosine of an angle. This function
     * expects the values of the <b>angle</b> parameter to be provided in
     * radians (values from 0 to PI*2). Values are returned in the range
     * <b>infinity</b> to <b>-infinity</b>.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param angle an angle in radians
     * @see PApplet#cos(float)
     * @see PApplet#sin(float)
     * @see PApplet#radians(float)
     */
    static public final float tan(float angle) {
        return (float)Math.tan(angle);
    }

    /**
     * ( begin auto-generated from asin.xml )
     *
     * The inverse of <b>sin()</b>, returns the arc sine of a value. This
     * function expects the values in the range of -1 to 1 and values are
     * returned in the range <b>-PI/2</b> to <b>PI/2</b>.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param value the value whose arc sine is to be returned
     * @see PApplet#sin(float)
     * @see PApplet#acos(float)
     * @see PApplet#atan(float)
     */
    static public final float asin(float value) {
        return (float)Math.asin(value);
    }


    /**
     * ( begin auto-generated from acos.xml )
     *
     * The inverse of <b>cos()</b>, returns the arc cosine of a value. This
     * function expects the values in the range of -1 to 1 and values are
     * returned in the range <b>0</b> to <b>PI (3.1415927)</b>.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param value the value whose arc cosine is to be returned
     * @see PApplet#cos(float)
     * @see PApplet#asin(float)
     * @see PApplet#atan(float)
     */
    static public final float acos(float value) {
        return (float)Math.acos(value);
    }

    /**
     * ( begin auto-generated from atan.xml )
     *
     * The inverse of <b>tan()</b>, returns the arc tangent of a value. This
     * function expects the values in the range of -Infinity to Infinity
     * (exclusive) and values are returned in the range <b>-PI/2</b> to <b>PI/2 </b>.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param value -Infinity to Infinity (exclusive)
     * @see PApplet#tan(float)
     * @see PApplet#asin(float)
     * @see PApplet#acos(float)
     */
    static public final float atan(float value) {
        return (float)Math.atan(value);
    }

    /**
     * ( begin auto-generated from atan2.xml )
     *
     * Calculates the angle (in radians) from a specified point to the
     * coordinate origin as measured from the positive x-axis. Values are
     * returned as a <b>float</b> in the range from <b>PI</b> to <b>-PI</b>.
     * The <b>atan2()</b> function is most often used for orienting geometry to
     * the position of the cursor.  Note: The y-coordinate of the point is the
     * first parameter and the x-coordinate is the second due the the structure
     * of calculating the tangent.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param y y-coordinate of the point
     * @param x x-coordinate of the point
     * @see PApplet#tan(float)
     */
    static public final float atan2(float y, float x) {
        return (float)Math.atan2(y, x);
    }

    /**
     * ( begin auto-generated from degrees.xml )
     *
     * Converts a radian measurement to its corresponding value in degrees.
     * Radians and degrees are two ways of measuring the same thing. There are
     * 360 degrees in a circle and 2*PI radians in a circle. For example,
     * 90&deg; = PI/2 = 1.5707964. All trigonometric functions in Processing
     * require their parameters to be specified in radians.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param radians radian value to convert to degrees
     * @see PApplet#radians(float)
     */
    static public final float degrees(float radians) {
        return radians * RAD_TO_DEG;
    }

    /**
     * ( begin auto-generated from radians.xml )
     *
     * Converts a degree measurement to its corresponding value in radians.
     * Radians and degrees are two ways of measuring the same thing. There are
     * 360 degrees in a circle and 2*PI radians in a circle. For example,
     * 90&deg; = PI/2 = 1.5707964. All trigonometric functions in Processing
     * require their parameters to be specified in radians.
     *
     * ( end auto-generated )
     * @webref math:trigonometry
     * @param degrees degree value to convert to radians
     * @see PApplet#degrees(float)
     */
    static public final float radians(float degrees) {
        return degrees * DEG_TO_RAD;
    }

    /**
     * ( begin auto-generated from ceil.xml )
     *
     * Calculates the closest int value that is greater than or equal to the
     * value of the parameter. For example, <b>ceil(9.03)</b> returns the value 10.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param n number to round up
     * @see PApplet#floor(float)
     * @see PApplet#round(float)
     */
    static public final int ceil(float n) {
        return (int) Math.ceil(n);
    }

    /**
     * ( begin auto-generated from floor.xml )
     *
     * Calculates the closest int value that is less than or equal to the value
     * of the parameter.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param n number to round down
     * @see PApplet#ceil(float)
     * @see PApplet#round(float)
     */
    static public final int floor(float n) {
        return (int) Math.floor(n);
    }

    /**
     * ( begin auto-generated from round.xml )
     *
     * Calculates the integer closest to the <b>value</b> parameter. For
     * example, <b>round(9.2)</b> returns the value 9.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param n number to round
     * @see PApplet#floor(float)
     * @see PApplet#ceil(float)
     */
    static public final int round(float n) {
        return Math.round(n);
    }


    static public final float mag(float a, float b) {
        return (float)Math.sqrt(a*a + b*b);
    }

    /**
     * ( begin auto-generated from mag.xml )
     *
     * Calculates the magnitude (or length) of a vector. A vector is a
     * direction in space commonly used in computer graphics and linear
     * algebra. Because it has no "start" position, the magnitude of a vector
     * can be thought of as the distance from coordinate (0,0) to its (x,y)
     * value. Therefore, mag() is a shortcut for writing "dist(0, 0, x, y)".
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param a first value
     * @param b second value
     * @param c third value
     * @see PApplet#dist(float, float, float, float)
     */
    static public final float mag(float a, float b, float c) {
        return (float)Math.sqrt(a*a + b*b + c*c);
    }


    static public final float dist(float x1, float y1, float x2, float y2) {
        return sqrt(sq(x2-x1) + sq(y2-y1));
    }

    /**
     * ( begin auto-generated from dist.xml )
     *
     * Calculates the distance between two points.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param z1 z-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @param z2 z-coordinate of the second point
     */
    static public final float dist(float x1, float y1, float z1,
                                   float x2, float y2, float z2) {
        return sqrt(sq(x2-x1) + sq(y2-y1) + sq(z2-z1));
    }


    /**
     * ( begin auto-generated from norm.xml )
     *
     * Normalizes a number from another range into a value between 0 and 1.
     * <br/> <br/>
     * Identical to map(value, low, high, 0, 1);
     * <br/> <br/>
     * Numbers outside the range are not clamped to 0 and 1, because
     * out-of-range values are often intentional and useful.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param value the incoming value to be converted
     * @param start lower bound of the value's current range
     * @param stop upper bound of the value's current range
     * @see PApplet#lerp(float, float, float)
     */
    static public final float norm(float value, float start, float stop) {
        return (value - start) / (stop - start);
    }

    /**
     * ( begin auto-generated from sq.xml )
     *
     * Squares a number (multiplies a number by itself). The result is always a
     * positive number, as multiplying two negative numbers always yields a
     * positive result. For example, -1 * -1 = 1.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param n number to square
     * @see PApplet#sqrt(float)
     */
    static public final float sq(float n) {
        return n*n;
    }

    /**
     * ( begin auto-generated from sqrt.xml )
     *
     * Calculates the square root of a number. The square root of a number is
     * always positive, even though there may be a valid negative root. The
     * square root <b>s</b> of number <b>a</b> is such that <b>s*s = a</b>. It
     * is the opposite of squaring.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param n non-negative number
     * @see PApplet#pow(float, float)
     * @see PApplet#sq(float)
     */
    static public final float sqrt(float n) {
        return (float)Math.sqrt(n);
    }

    /**
     * ( begin auto-generated from pow.xml )
     *
     * Facilitates exponential expressions. The <b>pow()</b> function is an
     * efficient way of multiplying numbers by themselves (or their reciprocal)
     * in large quantities. For example, <b>pow(3, 5)</b> is equivalent to the
     * expression 3*3*3*3*3 and <b>pow(3, -5)</b> is equivalent to 1 / 3*3*3*3*3.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param n base of the exponential expression
     * @param e power by which to raise the base
     * @see PApplet#sqrt(float)
     */
    static public final float pow(float n, float e) {
        return (float)Math.pow(n, e);
    }

    /**
     * ( begin auto-generated from max.xml )
     *
     * Determines the largest value in a sequence of numbers.
     *
     * ( end auto-generated )
     * @webref math:calculation
     * @param a first number to compare
     * @param b second number to compare
     * @see PApplet#min(float, float, float)
     */
    static public final int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static public final float max(float a, float b) {
        return (a > b) ? a : b;
    }

  /*
  static public final double max(double a, double b) {
    return (a > b) ? a : b;
  }
  */

    /**
     * @param c third number to compare
     */
    static public final int max(int a, int b, int c) {
        return (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
    }


    static public final float max(float a, float b, float c) {
        return (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
    }

}

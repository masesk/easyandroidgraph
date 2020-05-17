package com.masesk.easyandroidgraph;

import android.graphics.Bitmap;
import android.graphics.Paint;

/**
 * Created by Mases Krikorian on 2/4/2018.
 */
enum GraphType {
    POINT, CIRCLE, OVAL, RECTANGLE, LINE, BITMAP
}

public class GraphObject {
    private GraphType type;
    private float nums[];
    private Bitmap bitmap = null;
    private Paint paint;
    private boolean visiable = true;

    public GraphObject(float num1, float num2, GraphType type, Paint paint, boolean visible) {
        this.visiable = visible;
        this.paint = paint;
        this.type = type; // line
        nums = new float[2];
        nums[0] = num1;
        nums[1] = num2;
    }

    public GraphObject(float radius, float x, float y, GraphType type, Paint paint, boolean visible) {
        this.visiable = visible;
        this.paint = paint;
        this.type = type; // circle
        nums = new float[3];
        nums[0] = radius;
        nums[1] = x;
        nums[2] = y;
    }

    public GraphObject(float num1, float num2, float num3, float num4, GraphType type, Paint paint, boolean visible) {
        this.visiable = visible;
        this.paint = paint;
        this.type = type;
        nums = new float[4];
        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;
        nums[3] = num4;
    }

    public GraphObject(float x, float y, Bitmap bitmap, GraphType type, Paint paint, boolean visible) {
        this.visiable = visible;
        this.paint = paint;
        this.type = type;
        this.bitmap = bitmap;
        nums = new float[2];
        nums[0] = x;
        nums[1] = y;
    }

    public void setFirstValue(float num) {
        nums[0] = num;
    }

    public void setSecondValue(float num) {
        nums[1] = num;
    }

    public void setThirdValue(float num) {
        nums[2] = num;
    }

    public void setFourthValue(float num) {
        nums[3] = num;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void setVisible(boolean visibility) {
        this.visiable = visibility;
    }

    public boolean isVisible() {
        return visiable;
    }

    public GraphType getType() {
        return type;
    }

    public float[] getNums() {
        return nums;
    }

    public float getFirstValue() {
        return nums[0];
    }

    public float getSecondValue() {
        return nums[1];
    }

    public float getThirdValue() {
        return nums[2];
    }

    public float getFourthValue() {
        return nums[3];
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Paint getPaint() {
        return paint;
    }

}
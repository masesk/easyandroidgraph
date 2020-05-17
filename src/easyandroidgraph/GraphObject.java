package com.example.easyandroidgraphtest;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * Created by Mases Krikorian on 2/4/2018.
 */
enum GraphType {
    POINT,
    CIRCLE,
    OVAL,
    RECTANGLE,
    LINE,
    BITMAP
}
public class GraphObject {
    private GraphType type;
    private float nums[] = new float[4];
    private Bitmap bitmap = null;
    private Paint paint;

    public GraphObject(float num1, float num2, GraphType type, Paint paint){
        this.paint = paint;
        this.type = type; //line
        nums[0] = num1;
        nums[1] = num2;
    }
    public GraphObject(float radius, float x, float y, GraphType type, Paint paint){
        this.paint = paint;
        this.type = type; //circle
        nums[0] = radius;
        nums[1] = x;
        nums[2] = y;
    }
    public GraphObject(float num1, float num2, float num3, float num4, GraphType type, Paint paint) {
        this.paint = paint;
        this.type = type;
        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;
        nums[3] = num4;
    }

    public GraphObject(float x, float y, Bitmap bitmap, GraphType type, Paint paint){
        this.paint = paint;
        this.type = type;
        this.bitmap = bitmap;
        nums[0] = x;
        nums[1] = y;
    }
    public GraphType getType(){
        return type;
    }
    public float[] getNums(){
        return nums;
    }
    public float getNums1(){
        return nums[0];
    }
    public float getNums2(){
        return nums[1];
    }
    public float getNums3(){
        return nums[2];
    }
    public float getNums4(){
        return nums[3];
    }
    public Bitmap getBitmap(){
        return bitmap;
    }
    public Paint getPaint() { return paint; }
}

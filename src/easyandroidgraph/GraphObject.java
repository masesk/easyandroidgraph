package easyandroidgraph;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by radon on 2/4/2018.
 */

public class GraphObject {
    private int type = 0x0; //0x1 point // 0x2 circle // 0x3 rect // 0x4 line // 0x5 oval //0x6 Bitmap
    private float nums[] = new float[4];
    private Bitmap bitmap = null;

    public GraphObject(float num1, float num2){
        type = 0x1; //line
        nums[0] = num1;
        nums[1] = num2;
    }
    public GraphObject(float radius, float x, float y){
        type = 0x2; //circle
        nums[0] = radius;
        nums[1] = x;
        nums[2] = y;
    }
    public GraphObject(float num1, float num2, float num3, float num4, int type) {
        this.type = type;
        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;
        nums[3] = num4;
    }

    public GraphObject(float x, float y, Bitmap bitmap){
        this.bitmap = bitmap;
        nums[0] = x;
        nums[1] = y;
    }
    public int getType(){
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
}

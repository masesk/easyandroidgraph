package easyandroidgraph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by radon on 2/4/2018.
 */

public class DrawView extends View {
    private float x = 0;
    private float y = 0;
    private int type = 0x0;
    private static boolean autoInvalidate = false;
    private static boolean calledFromRedraw = false;
    private ArrayList<GraphObject> objects = new ArrayList<GraphObject>();
    Paint paint = new Paint();
    public DrawView(final Context context, AttributeSet attr) {
        super(context, attr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(autoInvalidate){
	        for(int i = 0; i < objects.size(); i++){
	            int type = objects.get(i).getType();
	            if(type == 0x1){
	                canvas.drawPoint(objects.get(i).getNums1(), objects.get(i).getNums2(), paint);
	                continue;
	            }
	            if(type == 0x2){
	                canvas.drawCircle(objects.get(i).getNums1(), objects.get(i).getNums2(), objects.get(i).getNums3(), paint);
	                continue;
	            }
	            if(type == 0x3){
	                canvas.drawRect(objects.get(i).getNums1(), objects.get(i).getNums2(), objects.get(i).getNums3(), objects.get(i).getNums4(), paint);
	                continue;
	            }
	            if(type == 0x4){
	                canvas.drawLine(objects.get(i).getNums1(), objects.get(i).getNums2(), objects.get(i).getNums3(), objects.get(i).getNums4(), paint);
	                continue;
	            }
	            if(type == 0x5){
	                canvas.drawOval(objects.get(i).getNums1(), objects.get(i).getNums2(), objects.get(i).getNums3(), objects.get(i).getNums4(), paint);
	                continue;
	            }
	            if(type == 0x6){
	                canvas.drawBitmap(objects.get(i).getBitmap(), objects.get(i).getNums1(), objects.get(i).getNums2(), paint);
	                continue;
	            }
	
	        }
	        if(calledFromRedraw){
				calledFromRedraw = false;
				autoInvalidate = false;
			}
        }

    }



    public boolean drawCircle(float x, float y, float radius){
        objects.add(new GraphObject(x, y, radius));
        return true;
    }

    public boolean drawBitmap(Bitmap bitmap, float x, float y){
        objects.add(new GraphObject(x, y, bitmap));
        return true;
    }

    public boolean drawOval(float left, float top, float right, float bottom) {
        objects.add(new GraphObject(left,top,right,bottom, 0x5));
        return true;
    }

    public boolean drawLine(float startX, float startY, float endX, float endY){
        objects.add(new GraphObject(startX,startY,endX,endY, 0x4));
        return true;
    }

    public boolean drawPoint(float x, float y){
        objects.add(new GraphObject(x, y));
        return true;
    }


    public boolean drawRect(float left, float top, float right, float bottom){
        objects.add(new GraphObject(left,top,right,bottom, 0x3));
        return true;
    }

    public Paint getPaint(){
        return paint;
    }
    public void setPaint(Paint paint){
        this.paint = paint;
    }
    
    public void setAutoRedraw(boolean st){
    	autoInvalidate = st;
    }
    
    public boolean getAutoRedraw(){
    	return autoInvalidate;
    }
    
    public void redraw(){
    	if(autoInvalidate){
			calledFromRedraw = true;
			autoInvalidate = true;
			this.invalidate();
		}
		else{
			this.invalidate();
		}
    }
}

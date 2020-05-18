package com.masesk.easyandroidgraph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Mases Krikorian on 2/4/2018.
 */

public class DrawView extends View {
    private static boolean autoInvalidate = false;
    private HashMap<String, GraphObject> objects = new HashMap();
    Paint paint = new Paint();
    private boolean invalidated = false;

    public DrawView(final Context context, AttributeSet attr) {
        super(context, attr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (autoInvalidate || invalidated) {
            Iterator it = objects.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                GraphObject go = objects.get(pair.getKey());
                GraphType type = go.getType();
                if(!go.isVisible()){
                    continue;
                }
                if (type == GraphType.POINT) {
                    canvas.drawPoint(go.getNums1(),
                            go.getNums2(),
                            go.getPaint());
                    continue;
                }
                if (type == GraphType.CIRCLE) {
                    canvas.drawCircle(go.getNums1(),
                            go.getNums2(),
                            go.getNums3(),
                            go.getPaint());
                    continue;
                }
                if (type == GraphType.RECTANGLE) {
                    canvas.drawRect(go.getNums1(),
                            go.getNums2(),
                            go.getNums3(),
                            go.getNums4(),
                            go.getPaint());
                    continue;
                }
                if (type == GraphType.LINE) {
                    canvas.drawLine(go.getNums1()
                            , go.getNums2(),
                            go.getNums3(),
                            go.getNums4(),
                            go.getPaint());
                    continue;
                }
                if (type == GraphType.OVAL) {
                    canvas.drawOval(go.getNums1(),
                            go.getNums2(),
                            go.getNums3(),
                            go.getNums4(),
                            go.getPaint());
                    continue;
                }
                if (type == GraphType.BITMAP) {
                    canvas.drawBitmap(go.getBitmap(),
                            go.getNums1(),
                            go.getNums2(),
                            go.getPaint());
                    continue;
                }

            }
            invalidated = false;
        }

    }


    public boolean drawCircle(String id, float x, float y, float radius, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(x, y, radius, GraphType.CIRCLE,
                paint == null ? this.paint : paint, visible ));
        return true;
    }

    public boolean drawBitmap(String id, Bitmap bitmap, float x, float y, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(x, y, bitmap, GraphType.BITMAP,
                paint == null ? this.paint : paint, visible));
        return true;
    }

    public boolean drawOval(String id, float left, float top, float right,
                            float bottom, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(left, top, right, bottom, GraphType.OVAL,
                paint == null ? this.paint : paint, visible));
        return true;
    }

    public boolean drawLine(String id, float startX, float startY, float endX,
                            float endY, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(startX, startY, endX, endY, GraphType.LINE,
                paint == null ? this.paint : paint, visible));
        return true;
    }

    public boolean drawPoint(String id, float x, float y, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(x, y, GraphType.POINT, paint == null ?
                this.paint : paint, visible));
        return true;
    }


    public boolean drawRect(String id, float left, float top, float right,
                            float bottom, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(left, top, right, bottom, GraphType.RECTANGLE,
                paint == null ? this.paint : paint, visible));
        return true;
    }

    public boolean hide(String id){
        if(objects.containsKey(id)){
            objects.get(id).setVisible(false);
            redraw();
            return true;
        }
        return false;
    }

    public boolean show(String id){
        if(objects.containsKey(id)){
            objects.get(id).setVisible(true);
            redraw();
            return true;
        }
        return false;
    }

    public boolean remove(String id){
        if(objects.containsKey(id)){
            objects.remove(id);
            redraw();
            return true;
        }
        return false;
    }

    public Paint getDefaultPaint() {
        return paint;
    }

    public void setDefaultPaint(Paint paint) {
        this.paint = paint;
    }

    public void setAutoRedraw(boolean st) {
        autoInvalidate = st;
    }

    public boolean getAutoRedraw() {
        return autoInvalidate;
    }

    public void redraw() {
        this.invalidated = true;
        this.invalidate();
    }
}

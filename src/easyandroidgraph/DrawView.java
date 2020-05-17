package com.example.easyandroidgraphtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Mases Krikorian on 2/4/2018.
 */

public class DrawView extends View {
    private static boolean autoInvalidate = true;
    private HashMap<String, GraphObject> objects = new HashMap();
    Paint paint = new Paint();

    public DrawView(final Context context, AttributeSet attr) {
        super(context, attr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (autoInvalidate) {
            Iterator it = objects.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                GraphType type = objects.get(pair.getKey()).getType();
                if (type == GraphType.POINT) {
                    canvas.drawPoint(objects.get(pair.getKey()).getNums1(),
                            objects.get(pair.getKey()).getNums2(),
                            objects.get(pair.getKey()).getPaint());
                    continue;
                }
                if (type == GraphType.CIRCLE) {
                    canvas.drawCircle(objects.get(pair.getKey()).getNums1(),
                            objects.get(pair.getKey()).getNums2(),
                            objects.get(pair.getKey()).getNums3(),
                            objects.get(pair.getKey()).getPaint());
                    continue;
                }
                if (type == GraphType.RECTANGLE) {
                    canvas.drawRect(objects.get(pair.getKey()).getNums1(),
                            objects.get(pair.getKey()).getNums2(),
                            objects.get(pair.getKey()).getNums3(),
                            objects.get(pair.getKey()).getNums4(),
                            objects.get(pair.getKey()).getPaint());
                    continue;
                }
                if (type == GraphType.LINE) {
                    canvas.drawLine(objects.get(pair.getKey()).getNums1()
                            , objects.get(pair.getKey()).getNums2(),
                            objects.get(pair.getKey()).getNums3(),
                            objects.get(pair.getKey()).getNums4(),
                            objects.get(pair.getKey()).getPaint());
                    continue;
                }
                if (type == GraphType.OVAL) {
                    canvas.drawOval(objects.get(pair.getKey()).getNums1(),
                            objects.get(pair.getKey()).getNums2(),
                            objects.get(pair.getKey()).getNums3(),
                            objects.get(pair.getKey()).getNums4(),
                            objects.get(pair.getKey()).getPaint());
                    continue;
                }
                if (type == GraphType.BITMAP) {
                    canvas.drawBitmap(objects.get(pair.getKey()).getBitmap(),
                            objects.get(pair.getKey()).getNums1(),
                            objects.get(pair.getKey()).getNums2(),
                            objects.get(pair.getKey()).getPaint());
                    continue;
                }
                if(autoInvalidate){
                    this.invalidate();
                }

            }
        }

    }


    public boolean drawCircle(String id, float x, float y, float radius, Paint paint) {
        objects.put(id, new GraphObject(x, y, radius, GraphType.CIRCLE,
                paint == null ? this.paint : paint ));
        return true;
    }

    public boolean drawBitmap(String id, Bitmap bitmap, float x, float y, Paint paint) {
        objects.put(id, new GraphObject(x, y, bitmap, GraphType.BITMAP,
                paint == null ? this.paint : paint));
        return true;
    }

    public boolean drawOval(String id, float left, float top, float right,
                            float bottom, Paint paint) {
        objects.put(id, new GraphObject(left, top, right, bottom, GraphType.OVAL,
                paint == null ? this.paint : paint));
        return true;
    }

    public boolean drawLine(String id, float startX, float startY, float endX,
                            float endY, Paint paint) {
        objects.put(id, new GraphObject(startX, startY, endX, endY, GraphType.LINE,
                paint == null ? this.paint : paint));
        return true;
    }

    public boolean drawPoint(String id, float x, float y, Paint paint) {
        objects.put(id, new GraphObject(x, y, GraphType.POINT, paint == null ? this.paint : paint));
        return true;
    }


    public boolean drawRect(String id, float left, float top, float right,
                            float bottom, Paint paint) {
        objects.put(id, new GraphObject(left, top, right, bottom, GraphType.RECTANGLE,
                paint == null ? this.paint : paint));
        return true;
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
        this.invalidate();
    }
}

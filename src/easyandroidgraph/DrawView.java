package com.masesk.easyandroidgraph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mases Krikorian on 2/4/2018.
 */

public class DrawView extends View {
    private static boolean autoInvalidate = true;
    private LinkedHashMap<String, GraphObject> objects = new LinkedHashMap<String, GraphObject>();
    Paint paint = new Paint();
    private boolean invalidated = false;
    private final String invalidKeyMessage = "No draw object exists with given id";

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
                if (!go.isVisible()) {
                    continue;
                }
                switch (type) {
                    case POINT:
                        canvas.drawPoint(go.getFirstValue(), go.getSecondValue(), go.getPaint());
                        break;
                    case CIRCLE:
                        canvas.drawCircle(go.getFirstValue(), go.getSecondValue(),
                                go.getThirdValue(), go.getPaint());
                        break;
                    case RECTANGLE:
                        canvas.drawRect(go.getFirstValue(), go.getSecondValue(),
                                go.getThirdValue(), go.getFourthValue(), go.getPaint());
                        break;
                    case LINE:
                        canvas.drawLine(go.getFirstValue(), go.getSecondValue(),
                                go.getThirdValue(), go.getFourthValue(), go.getPaint());
                        break;
                    case OVAL:
                        canvas.drawOval(go.getFirstValue(), go.getSecondValue(), go.getThirdValue(),
                                go.getFourthValue(), go.getPaint());
                        break;
                    case BITMAP:
                        canvas.drawBitmap(go.getBitmap(), go.getFirstValue(),
                                go.getSecondValue(), go.getPaint());

                        break;

                }

            }
            invalidated = false;
        }

    }

    public static class ObjectTypeException extends RuntimeException {
        public ObjectTypeException(String message) {
            super(message);
        }
    }
    public static class InvalidIdException extends RuntimeException {
        public InvalidIdException(String message) {
            super(message);
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param x shape's new X value
     * @param y shape's new Y value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS
     */
    public boolean setCenter(String id, float x, float y) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.POINT && obj.getType() != GraphType.CIRCLE
                && obj.getType() != GraphType.BITMAP) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString())
                            .append(" has no center property").toString());
        } else {
            obj.setFirstValue(x);
            obj.setSecondValue(y);
            redrawInternal();
            return true;
        }

    }

    /**
     *
     * @param id unique shape identifier
     * @param x shape's new X value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS
     */
    public boolean setX(String id, float x) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.POINT && obj.getType() != GraphType.CIRCLE
                && obj.getType() != GraphType.BITMAP) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString())
                            .append(" has no center property").toString());
        } else {
            obj.setFirstValue(x);
            redrawInternal();
            return true;
        }

    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's X value
     * ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS
     */
    public float getX(String id){
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.POINT && obj.getType() != GraphType.CIRCLE
                && obj.getType() != GraphType.BITMAP) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString())
                            .append(" has no center property").toString());
        } else {
            return obj.getFirstValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param y shape's new Y value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS
     */
    public boolean setY(String id, float y) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.POINT && obj.getType() != GraphType.CIRCLE
                && obj.getType() != GraphType.BITMAP) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString())
                            .append(" has no center property").toString());
        } else {
            obj.setSecondValue(y);
            redrawInternal();
            return true;
        }

    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's Y value
     * ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS
     */
    public float getY(String id){
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.POINT && obj.getType() != GraphType.CIRCLE
                && obj.getType() != GraphType.BITMAP) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString())
                            .append(" has no center property").toString());
        } else {
            return obj.getSecondValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param radius circle's new radius
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS FOR CIRCLES
     */
    public boolean setRadius(String id, float radius) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.CIRCLE) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString())
                            .append(" has no center property").toString());
        } else {
            obj.setThirdValue(radius);
            redrawInternal();
            return true;
        }

    }

    /**
     *
     * @param id unique shape identifier
     * @return circle's radius
     * ONLY WORKS FOR CIRCLES
     */
    public float getRadius(String id){
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.CIRCLE) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString())
                            .append(" has no center property").toString());
        } else {
            return obj.getThirdValue();
        }
    }

    /**
     *
     * @param id shape unique identifier
     * @param startX line's new starting X value
     * @param startY line's new starting Y value
     * @param endX line's new ending X value
     * @param endY line's new ending Y value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS FOR LINES
     */
    public boolean setLinePoints(String id, float startX, float startY, float endX, float endY) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.LINE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no start and ending point properties").toString());
        } else {
            obj.setFirstValue(startX);
            obj.setSecondValue(startY);
            obj.setThirdValue(endX);
            obj.setFourthValue(endY);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param startX line's new starting X value
     * @param startY line's new starting Y value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS FOR LINES AND RECTANGLES
     */
    public boolean setStartPoint(String id, float startX, float startY) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no starting point property").toString());
        } else {
            obj.setFirstValue(startX);
            obj.setSecondValue(startY);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id shape unique identifier
     * @param endX line's new ending X value
     * @param endY line's new ending Y value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS FOR LINES AND RECTANGLES
     */
    public boolean setEndPoint(String id, float endX, float endY) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no ending point property").toString());
        } else {
            obj.setThirdValue(endX);
            obj.setFourthValue(endY);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param startX line's new starting X value
     * @return false if id does not exist, true if operation completed.
     */
    public boolean setStartX(String id, float startX) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no starting point property").toString());
        } else {
            obj.setFirstValue(startX);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's starting X value
     * ONLY WORKS WITH LINES AND RECTANGLES
     */
    public float getStartX(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no ending point property").toString());
        } else {
            return obj.getFirstValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param startY shape's new starting Y value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH LINES AND RECTANGLES
     */
    public boolean setStartY(String id, float startY) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no starting point property").toString());
        } else {
            obj.setSecondValue(startY);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's starting Y value
     * ONLY WORKS WITH RECTANGLES AND LINES
     */
    public float getStartY(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no ending point property").toString());
        } else {
            return obj.getSecondValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param endX shape's new ending X value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH LINES AND RECTANGLES
     */
    public boolean setEndX(String id, float endX) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no ending point property").toString());
        } else {
            obj.setThirdValue(endX);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's ending X value
     * ONLY WORKS WITH LINES AND RECTANGLES
     */
    public float getEndX(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no ending point property").toString());
        } else {
            return obj.getThirdValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param endY shape's new ending Y value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH LINES AND RECTANGLES
     */
    public boolean setEndY(String id, float endY) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no ending point property").toString());
        } else {
            obj.setFourthValue(endY);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's ending Y value
     * ONLY WORKS WITH LINES AND RECTANGLES
     */
    public float getEndY(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.LINE && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no ending point property").toString());
        } else {
            return obj.getFourthValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param bitmap new bitmap instance
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH BITMAPS
     */
    public boolean setBitmap(String id, Bitmap bitmap) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.BITMAP) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString()).
                            append(" has no bitmap property").toString());
        } else {
            obj.setBitmap(bitmap);
            redrawInternal();
            return true;
        }

    }

    /**
     *
     * @param id unique shape identifier
     * @return current bitmap instance
     * ONLY WORKS WITH BITMAPS
     */
    public Bitmap getBitmap(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.BITMAP) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString()).append("" +
                            " has no bitmap property").toString());
        } else {
            return obj.getBitmap();
        }

    }

    /**
     *
     * @param id unique shape identifier
     * @param left oval's new left length
     * @param top oval's new top length
     * @param right oval's new right length
     * @param bottom oval's new bottom length
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH OVALS
     */
    public boolean setOvalLengths(String id, float left, float top, float right, float bottom) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.OVAL) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString()).append(" is not an oval.").toString());
        } else {
            obj.setFirstValue(left);
            obj.setSecondValue(top);
            obj.setThirdValue(right);
            obj.setFourthValue(bottom);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param left rectangle's new left length
     * @param top rectangle's new top length
     * @param right rectangle's new right length
     * @param bottom rectangle's new bottom length
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH RECTANGLES
     */
    public boolean setRectPoints(String id, float left, float top, float right, float bottom) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(
                    new StringBuilder().append(obj.getType().toString()).append(" is not a rectangle.").toString());
        } else {
            obj.setFirstValue(left);
            obj.setSecondValue(top);
            obj.setThirdValue(right);
            obj.setFourthValue(bottom);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param x circle's new center x value
     * @param y circle's new center y value
     * @param radius circle's new radius value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH CIRCLES
     */
    public boolean setCircleCenterAndRadius(String id, float x, float y, float radius) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.CIRCLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no left length property").toString());
        } else {
            obj.setFirstValue(x);
            obj.setSecondValue(y);
            obj.setThirdValue(radius);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unqiue shape identifier
     * @param left shape's new left value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH OVALS AND RECTANGLES
     */
    public boolean setLeft(String id, float left) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no left length property").toString());
        } else {
            obj.setFirstValue(left);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifer
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH OVALS AND RECTANGLES
     */
    public float getLeft(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no bottom length property").toString());
        } else {
            return obj.getFirstValue();
        }
    }

    /**
     *
     * @param id unique shape identifer
     * @param top shape's new top value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH OVALS AND RECTANGLES
     */
    public boolean setTop(String id, float top) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no top length property").toString());
        } else {
            obj.setSecondValue(top);
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifer
     * @return shape's top value
     * ONLY WORKS WITH OVALS AND RECTANGLES
     */
    public float getTop(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no bottom length property").toString());
        } else {
            return obj.getSecondValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param right shape's new right value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH OVALS AND RECTANGLES
     */
    public boolean setRight(String id, float right) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no right length property").toString());
        } else {
            obj.setThirdValue(right);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's right value
     * ONLY WORKS WITH OVALS AND RECTANGLES
     */
    public float getRight(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no bottom length property").toString());
        } else {
            return obj.getThirdValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param bottom shape's new bottom value
     * @return false if id does not exist, true if operation completed.
     * ONLY WORKS WITH OVAL AND RECTANGLES
     */
    public boolean setBottom(String id, float bottom) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no bottom length property").toString());
        } else {
            obj.setFourthValue(bottom);
            redrawInternal();
            return true;
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @return shape's bottom value
     * ONLY WORKS WITH OVALS AND RECTANGLES
     */
    public float getBottom(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            throw new InvalidIdException(invalidKeyMessage);
        } else if (obj.getType() != GraphType.OVAL && obj.getType() != GraphType.RECTANGLE) {
            throw new ObjectTypeException(new StringBuilder().append(obj.getType().toString())
                    .append(" has no bottom length property").toString());
        } else {
            return obj.getFourthValue();
        }
    }

    /**
     *
     * @param id unique shape identifier
     * @param paint new paint instance
     * @return false if id does not exist, true if operation completed.
     */
    public boolean setPaint(String id, Paint paint) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return false;
        }
        obj.setPaint(paint);
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @return paint instance belonging to given id
     */
    public Paint getPaint(String id) {
        GraphObject obj = objects.get(id);
        if (!objects.containsKey(id)) {
            return null;
        }
        return obj.getPaint();

    }

    /**
     *
     * @param id unique shshapeape identifier
     * @return false if id does not exist, true if operation completed.
     */
    public boolean bringToFront(String id){
        if(!objects.containsKey(id)){
            return false;
        }
        GraphObject obj = objects.remove(id);
        objects.put(id, obj);
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @param x center x value
     * @param y center y value
     * @param radius radius of circle
     * @param paint describes color, stroke width, etc
     * @param visible visibility of shape
     * @return
     */
    public boolean drawCircle(String id, float x, float y, float radius, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(x, y, radius, GraphType.CIRCLE, paint == null ? this.paint : paint, visible));
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @param bitmap bitmap instance
     * @param x bitmap x value
     * @param y bitmap y value
     * @param paint describes color, stroke width, etc
     * @param visible visibility of shape
     * @return
     */
    public boolean drawBitmap(String id, Bitmap bitmap, float x, float y, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(x, y, bitmap, GraphType.BITMAP, paint == null ? this.paint : paint, visible));
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @param left position
     * @param top length value
     * @param right length value
     * @param bottom length value
     * @param paint describe color, stroke width, etc
     * @param visible visibility of shape
     * @return
     */
    public boolean drawOval(String id, float left, float top, float right, float bottom, Paint paint, boolean visible) {
        objects.put(id,
                new GraphObject(left, top, right, bottom, GraphType.OVAL, paint == null ? this.paint : paint, visible));
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @param startX line starting x position value
     * @param startY line starting y position value
     * @param endX line ending x value
     * @param endY line ending y value
     * @param paint describe color, stroke width, etc
     * @param visible visibility of shape
     * @return
     */
    public boolean drawLine(String id, float startX, float startY, float endX, float endY, Paint paint,
                            boolean visible) {
        objects.put(id, new GraphObject(startX, startY, endX, endY, GraphType.LINE, paint == null ? this.paint : paint,
                visible));
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @param x position of point
     * @param y position of point
     * @param paint describe color, stroke width, etc
     * @param visible visibility of shape
     * @return
     */
    public boolean drawPoint(String id, float x, float y, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(x, y, GraphType.POINT, paint == null ? this.paint : paint, visible));
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @param left position value
     * @param top position value
     * @param right position value
     * @param bottom position value
     * @param paint describe color, stroke width, etc
     * @param visible visibility of shape
     * @return
     */
    public boolean drawRect(String id, float left, float top, float right, float bottom, Paint paint, boolean visible) {
        objects.put(id, new GraphObject(left, top, right, bottom, GraphType.RECTANGLE,
                paint == null ? this.paint : paint, visible));
        redrawInternal();
        return true;
    }

    /**
     *
     * @param id unique shape identifier
     * @return false if id does not exist, true if operation completed.
     */
    public boolean hide(String id) {
        if (objects.containsKey(id)) {
            objects.get(id).setVisible(false);
            redrawInternal();
            return true;
        }
        return false;
    }

    /**
     *
     * @param id unique shape identifier
     * @return false if id does not exist, true if operation completed.
     */
    public boolean show(String id) {
        if (objects.containsKey(id)) {
            objects.get(id).setVisible(true);
            redrawInternal();
            return true;
        }
        return false;
    }

    /**
     *
     * @param id unique shape identifier
     * @return true if shape is visible
     */
    public boolean isVisible(String id){
        if (objects.containsKey(id)) {
            return objects.get(id).isVisible();
        }
        return false;
    }

    /**
     *
     * @param id unique shape identifier
     * @return false if id does not exist, true if operation completed.
     */
    public boolean remove(String id) {
        if (objects.containsKey(id)) {
            objects.remove(id);
            redrawInternal();
            return true;
        }
        return false;
    }

    /**
     *
     * @return default paint that will be used if null is passed for a shape
     */
    public Paint getDefaultPaint() {
        return paint;
    }

    /**
     *
     * @param paint new default paint
     */
    public void setDefaultPaint(Paint paint) {
        this.paint = paint;
    }

    /**
     *
     * @param st set the state of auto redraw
     */
    public void setAutoRedraw(boolean st) {
        autoInvalidate = st;
    }

    /**
     *
     * @return true if auto redraw is enabled
     */
    public boolean getAutoRedraw() {
        return autoInvalidate;
    }

    /**
     * Called every time a shape draws or an existing one is updated
     * Does not guarantee redraw
     */
    private void redrawInternal() {
        this.invalidate();
    }

    /**
     * user invoked to force redraw
     */
    public void redraw() {
        this.invalidated = true;
        this.invalidate();
    }
}
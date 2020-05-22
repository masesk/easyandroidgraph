# [easyandroidgraph](http://www.masesk.com)
[![license](https://img.shields.io/github/license/masesk/easyandroidgraph.svg)](https://github.com/masesk/easyandroidgraph/blob/master/README.md)
[![stars](https://img.shields.io/github/stars/masesk/easyandroidgraph.svg?style=social)](https://github.com/masesk/easyandroidgraph/stargazers)
[![forks](https://img.shields.io/github/forks/masesk/easyandroidgraph?style=social)](https://github.com/masesk/process-google-dataset/network/members)

This tool makes it easier to use the built in Android tools to draw<br>
points, lines, shapes, and bitmaps.

![Test](https://i.imgur.com/auFhvAm.gif)
## Features

* Drawing shapes in Android no longer requires dealing with canvas, revalidating, and handling the data yourself.
* Simple built in functions let you draw anything you want
* Setup and use takes seconds, and saves you many lines of code.
* Great for reusability.



## Installation

### Option 1: Download JAR File

1. Head over to [latest releases](https://github.com/masesk/easyandroidgraph/releases) and download the latest JAR file.

2. Add the JAR file as an external library to  your code. [Here is an example for Android Studio](https://stackoverflow.com/questions/25660166/how-to-add-a-jar-in-external-libraries-in-android-studio).


### Option 2: Source
1. Clone the [easyandroidgraph git repo](https://github.com/masesk/easyandroidgraph).
2. Copy the contents of the source folder into your own project's src folder.



## How to use

easyandroidgraph provides you with a single view that can be added to a layout and contains utility functions to draw on said view.

### Import
```
import com.masesk.easyandroidgraph.DrawView;
```
**NOTE: com.masesk.easyandroidgraph would be replaced with your package name if you use the source installation.**

### Layout as XML

Use the following in your layout XML as an example:

```
    <com.masesk.easyandroidgraph.DrawView
        android:id="@+id/drawView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1" />
```

**NOTE: com.masesk.easyandroidgraph would be replaced with your package name if you use the source installation.**

**NOTE: Change the id ("drawView" in this example) as need but keep track of it**

Use the following in your Java Activity as an example:
```
 DrawView drawView = findViewById(R.id.drawView);
```

### Layout as Java

Use the following in your Java Activity as an example:

```
DrawView drawView = new DrawView(context, attributeSet);
layout.addView(view);
```


## Constructor, Methods, and Parameters



-   -   ### Constructor Detail

        -   #### DrawView

                public DrawView(Context context,
                                AttributeSet attr)

    -   ### Method Detail

        -   #### setCenter

                public boolean setCenter(java.lang.String id,
                                         float x,
                                         float y)

            Parameters:
            :   `id` - unique shape identifier
            :   `x` - shape's new X value
            :   `y` - shape's new Y value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS

        -   #### setX

                public boolean setX(java.lang.String id,
                                    float x)

            Parameters:
            :   `id` - unique shape identifier
            :   `x` - shape's new X value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS

        -   #### getX

                public float getX(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's X value ONLY WORKS FOR CIRCLES, POINTS, AND
                BITMAPS

        -   #### setY

                public boolean setY(java.lang.String id,
                                    float y)

            Parameters:
            :   `id` - unique shape identifier
            :   `y` - shape's new Y value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS FOR CIRCLES, POINTS, AND BITMAPS

        -   #### getY

                public float getY(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's Y value ONLY WORKS FOR CIRCLES, POINTS, AND
                BITMAPS

        -   #### setRadius

                public boolean setRadius(java.lang.String id,
                                         float radius)

            Parameters:
            :   `id` - unique shape identifier
            :   `radius` - circle's new radius
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS FOR CIRCLES

        -   #### getRadius

                public float getRadius(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   circle's radius ONLY WORKS FOR CIRCLES

        -   #### setLinePoints

                public boolean setLinePoints(java.lang.String id,
                                             float startX,
                                             float startY,
                                             float endX,
                                             float endY)

            Parameters:
            :   `id` - shape unique identifier
            :   `startX` - line's new starting X value
            :   `startY` - line's new starting Y value
            :   `endX` - line's new ending X value
            :   `endY` - line's new ending Y value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS FOR LINES

        -   #### setStartPoint

                public boolean setStartPoint(java.lang.String id,
                                             float startX,
                                             float startY)

            Parameters:
            :   `id` - unique shape identifier
            :   `startX` - line's new starting X value
            :   `startY` - line's new starting Y value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS FOR LINES AND RECTANGLES

        -   #### setEndPoint

                public boolean setEndPoint(java.lang.String id,
                                           float endX,
                                           float endY)

            Parameters:
            :   `id` - shape unique identifier
            :   `endX` - line's new ending X value
            :   `endY` - line's new ending Y value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS FOR LINES AND RECTANGLES

        -   #### setStartX

                public boolean setStartX(java.lang.String id,
                                         float startX)

            Parameters:
            :   `id` - unique shape identifier
            :   `startX` - line's new starting X value
            Returns:
            :   false if id does not exist, true if operation completed.

        -   #### getStartX

                public float getStartX(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's starting X value ONLY WORKS WITH LINES AND
                RECTANGLES

        -   #### setStartY

                public boolean setStartY(java.lang.String id,
                                         float startY)

            Parameters:
            :   `id` - unique shape identifier
            :   `startY` - shape's new starting Y value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH LINES AND RECTANGLES

        -   #### getStartY

                public float getStartY(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's starting Y value ONLY WORKS WITH RECTANGLES AND
                LINES

        -   #### setEndX

                public boolean setEndX(java.lang.String id,
                                       float endX)

            Parameters:
            :   `id` - unique shape identifier
            :   `endX` - shape's new ending X value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH LINES AND RECTANGLES

        -   #### getEndX

                public float getEndX(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's ending X value ONLY WORKS WITH LINES AND
                RECTANGLES

        -   #### setEndY

                public boolean setEndY(java.lang.String id,
                                       float endY)

            Parameters:
            :   `id` - unique shape identifier
            :   `endY` - shape's new ending Y value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH LINES AND RECTANGLES

        -   #### getEndY

                public float getEndY(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's ending Y value ONLY WORKS WITH LINES AND
                RECTANGLES

        -   #### setBitmap

                public boolean setBitmap(java.lang.String id,
                                         Bitmap bitmap)

            Parameters:
            :   `id` - unique shape identifier
            :   `bitmap` - new bitmap instance
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH BITMAPS

        -   #### getBitmap

                public Bitmap getBitmap(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   current bitmap instance ONLY WORKS WITH BITMAPS

        -   #### setOvalLengths

                public boolean setOvalLengths(java.lang.String id,
                                              float left,
                                              float top,
                                              float right,
                                              float bottom)

            Parameters:
            :   `id` - unique shape identifier
            :   `left` - oval's new left length
            :   `top` - oval's new top length
            :   `right` - oval's new right length
            :   `bottom` - oval's new bottom length
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH OVALS

        -   #### setRectPoints

                public boolean setRectPoints(java.lang.String id,
                                             float left,
                                             float top,
                                             float right,
                                             float bottom)

            Parameters:
            :   `id` - unique shape identifier
            :   `left` - rectangle's new left length
            :   `top` - rectangle's new top length
            :   `right` - rectangle's new right length
            :   `bottom` - rectangle's new bottom length
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH RECTANGLES

        -   #### setCircleCenterAndRadius

                public boolean setCircleCenterAndRadius(java.lang.String id,
                                                        float x,
                                                        float y,
                                                        float radius)

            Parameters:
            :   `id` - unique shape identifier
            :   `x` - circle's new center x value
            :   `y` - circle's new center y value
            :   `radius` - circle's new radius value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH CIRCLES

        -   #### setLeft

                public boolean setLeft(java.lang.String id,
                                       float left)

            Parameters:
            :   `id` - unqiue shape identifier
            :   `left` - shape's new left value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH OVALS AND RECTANGLES

        -   #### getLeft

                public float getLeft(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifer
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH OVALS AND RECTANGLES

        -   #### setTop

                public boolean setTop(java.lang.String id,
                                      float top)

            Parameters:
            :   `id` - unique shape identifer
            :   `top` - shape's new top value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH OVALS AND RECTANGLES

        -   #### getTop

                public float getTop(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifer
            Returns:
            :   shape's top value ONLY WORKS WITH OVALS AND RECTANGLES

        -   #### setRight

                public boolean setRight(java.lang.String id,
                                        float right)

            Parameters:
            :   `id` - unique shape identifier
            :   `right` - shape's new right value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH OVALS AND RECTANGLES

        -   #### getRight

                public float getRight(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's right value ONLY WORKS WITH OVALS AND RECTANGLES

        -   #### setBottom

                public boolean setBottom(java.lang.String id,
                                         float bottom)

            Parameters:
            :   `id` - unique shape identifier
            :   `bottom` - shape's new bottom value
            Returns:
            :   false if id does not exist, true if operation completed.
                ONLY WORKS WITH OVAL AND RECTANGLES

        -   #### getBottom

                public float getBottom(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   shape's bottom value ONLY WORKS WITH OVALS AND
                RECTANGLES

        -   #### setPaint

                public boolean setPaint(java.lang.String id,
                                        Paint paint)

            Parameters:
            :   `id` - unique shape identifier
            :   `paint` - new paint instance
            Returns:
            :   false if id does not exist, true if operation completed.

        -   #### getPaint

                public Paint getPaint(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   paint instance belonging to given id

        -   #### bringToFront

                public boolean bringToFront(java.lang.String id)

            Parameters:
            :   `id` - unique shshapeape identifier
            Returns:
            :   false if id does not exist, true if operation completed.

        -   #### drawCircle

                public boolean drawCircle(java.lang.String id,
                                          float x,
                                          float y,
                                          float radius,
                                          Paint paint,
                                          boolean visible)

            Parameters:

            `id` - unique shape identifier

            `x` - center x value

            `y` - center y value

            `radius` - radius of circle

            `paint` - describes color, stroke width, etc

            `visible` - visibility of shape

            Returns:

        -   #### drawBitmap

                public boolean drawBitmap(java.lang.String id,
                                          Bitmap bitmap,
                                          float x,
                                          float y,
                                          Paint paint,
                                          boolean visible)

            Parameters:

            `id` - unique shape identifier

            `bitmap` - bitmap instance

            `x` - bitmap x value

            `y` - bitmap y value

            `paint` - describes color, stroke width, etc

            `visible` - visibility of shape

            Returns:

        -   #### drawOval

                public boolean drawOval(java.lang.String id,
                                        float left,
                                        float top,
                                        float right,
                                        float bottom,
                                        Paint paint,
                                        boolean visible)

            Parameters:

            `id` - unique shape identifier

            `left` - position

            `top` - length value

            `right` - length value

            `bottom` - length value

            `paint` - describe color, stroke width, etc

            `visible` - visibility of shape

            Returns:

        -   #### drawLine

                public boolean drawLine(java.lang.String id,
                                        float startX,
                                        float startY,
                                        float endX,
                                        float endY,
                                        Paint paint,
                                        boolean visible)

            Parameters:

            `id` - unique shape identifier

            `startX` - line starting x position value

            `startY` - line starting y position value

            `endX` - line ending x value

            `endY` - line ending y value

            `paint` - describe color, stroke width, etc

            `visible` - visibility of shape

            Returns:

        -   #### drawPoint

                public boolean drawPoint(java.lang.String id,
                                         float x,
                                         float y,
                                         Paint paint,
                                         boolean visible)

            Parameters:

            `id` - unique shape identifier

            `x` - position of point

            `y` - position of point

            `paint` - describe color, stroke width, etc

            `visible` - visibility of shape

            Returns:

        -   #### drawRect

                public boolean drawRect(java.lang.String id,
                                        float left,
                                        float top,
                                        float right,
                                        float bottom,
                                        Paint paint,
                                        boolean visible)

            Parameters:

            `id` - unique shape identifier

            `left` - position value

            `top` - position value

            `right` - position value

            `bottom` - position value

            `paint` - describe color, stroke width, etc

            `visible` - visibility of shape

            Returns:

        -   #### hide

                public boolean hide(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   false if id does not exist, true if operation completed.

        -   #### show

                public boolean show(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   false if id does not exist, true if operation completed.

        -   #### isVisible

                public boolean isVisible(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   true if shape is visible

        -   #### remove

                public boolean remove(java.lang.String id)

            Parameters:
            :   `id` - unique shape identifier
            Returns:
            :   false if id does not exist, true if operation completed.

        -   #### getDefaultPaint

                public Paint getDefaultPaint()

            Returns:
            :   default paint that will be used if null is passed for a
                shape

        -   #### setDefaultPaint

                public void setDefaultPaint(Paint paint)

            Parameters:
            :   `paint` - new default paint

        -   #### setAutoRedraw

                public void setAutoRedraw(boolean st)

            Parameters:
            :   `st` - set the state of auto redraw

        -   #### getAutoRedraw

                public boolean getAutoRedraw()

            Returns:
            :   true if auto redraw is enabled

        -   #### redraw

                public void redraw()

            user invoked to force redraw




Source code can be found on [github](https://github.com/masesk/easyandroidgraph). 

Developed by [Mases Krikorian](http://masesk.com)

    
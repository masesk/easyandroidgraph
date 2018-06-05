# [easyandroidgraph](http://www.masesk.com)

This tool makes it easier to use the built in Android tools to draw<br>
points, lines, shapes, and bitmaps.
## Features

* Drawing shapes in Android no longer requires dealing with canvas, revalidating, and handling the data yourself.
* Simple built in functions let you draw anything you want
* Setup and use takes seconds, and saves you many lines of code.
* Great for reusability.



## Getting Started


#### Using Easy Android Graph

(1) Download and import the easyandroidgraph.jar file into your android project. To do this, simply download this as zip, extract it, and import the file into <projectname>\app\libs

(2) Re-Sync project if your IDE does not automatically detect new libraries

(3) In your XML, declare the layout for easyandroidgraph.DrawView. Here is an example:
```bash
    <easyandroidgraph.DrawView
        android:id="@+id/graph"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
In the example above, id name can be set to anything but needs to be consistent to Java code. Width and height<br>
are required but can be assigned to other values.

(4) In your Java activity section, declare a new instance of DrawView
```bash
DrawView view = (DrawView) findViewById(R.id.graph) ;
```

(5) Now your view object of class DrawView can be used to draw on the graph layout. Here is an example:

```bash
        view.drawRect(100, 200, 300, 400);
        view.drawPoint(500,100);
        view.drawLine(300, 400, 500, 500);
```

(6) Here are the function that can be used and how to use them:
```bash
        drawCircle(float x, float y, float radius): bool
        drawBitmap(Bitmap bitmap, float x, float y): bool
        drawOval(float left, float top, float right, float bottom): bool
        drawLine(float startX, float startY, float endX, float endY): bool
        drawRect(float left, float top, float right, float bottom): bool
        getPaint(): Paint
        setPaint(Paint paint): void
        setAutoRedraw(boolean st): void
        getAutoRedraw(): bool
        redraw(): void
```
Note: Function that draw will return a boolean if drawn successfully.

(7) IMPORTANT ADDITIONAL NOTES

* Paint is a built in Android class used to determine important visual factors such as color and width.<br>
Create a new instance of paint, change it's settings, and pass it to setPaint(Paint) function to change <br>
drawing colors, witdth, and other settings.
* To save memory and speed up your app during executing, auto redrawing (invalidation) is discouraged if<br>
excessive drawing is done. Set auto invalidating through setAutoInvalidate(boolean) to false, and manually<br>
call invaldate() when necessary.

## Licence

Source code can be found on [github](https://github.com/masesk/easyandroidgraph). <br>
[![Screen Shot](https://licensebuttons.net/l/by/4.0/88x31.png)This work is licensed under a Creative Commons Attribution 4.0 International License.](https://creativecommons.org/licenses/by/4.0/)

Developed by [Mases Krikorian](http://masesk.com)

    

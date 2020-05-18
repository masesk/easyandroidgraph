# [easyandroidgraph](http://www.masesk.com)

This tool makes it easier to use the built in Android tools to draw<br>
points, lines, shapes, and bitmaps.
## Features

* Drawing shapes in Android no longer requires dealing with canvas, revalidating, and handling the data yourself.
* Simple built in functions let you draw anything you want
* Setup and use takes seconds, and saves you many lines of code.
* Great for reusability.



## Installation

### Option 1 (RECOMMENDED): Download JAR File

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

### Layout as XML (RECOMMENDED)

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

## Functions 

```
drawCircle(String id, float x, float y, float radius, Paint paint, boolean visible): bool
        
drawBitmap(String id, Bitmap bitmap, float x, float y, Paint paint, boolean visible): bool
        
drawOval(String id, float left, float top, float right, float bottom, Paint paint, boolean visible): bool

drawLine(String id, float startX, float startY, float endX, float endY, Paint paint, boolean visible): bool

drawRect(String id, float left, float top, float right, float bottom, Paint paint, boolean visible): bool

show(String id): bool

hide(String id): bool

remove(String id): bool

getDefaultPaint(): Paint

setDefaultPaint(Paint paint): void

setAutoRedraw(boolean st): void

getAutoRedraw(): bool

redraw(): void
```

### Additional Information

```
-- String id: 
        Unique for each shape. Useful for updating shape location, size, type, or visiblity state. Simply call draw function with the same id to update any of mentioned features.

-- Paint paint:
        Object containing information about visuals of the shape. If passed null, default paint will be used.

-- Boolean visible:
        Visibility of the shape when it is created or updated.

-- Boolean autoRedraw & redraw():
        When set true, the canvas will redraw whenever any draw function is called. Can improve efficiency if redraw() is called to redraw; avoiding the canvas update every frame tick.
```



Source code can be found on [github](https://github.com/masesk/easyandroidgraph). 

Developed by [Mases Krikorian](http://masesk.com)

    

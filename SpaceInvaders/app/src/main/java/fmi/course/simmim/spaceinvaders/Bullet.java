package fmi.course.simmim.spaceinvaders;

import android.graphics.RectF;

/**
 * Bullet class represent weapon for Invader and PlayerShip classes
 */
public class Bullet {
    public Bullet(int screenResolutionY) {
        height = screenResolutionY / 20;
        isActive = false;

        rect = new RectF();
    }

    public RectF getRect() {
        return rect;
    }

    public boolean getStatus() {
        return isActive;
    }

    public void setInactive() {
        isActive = false;
    }

    public float getImplactPointY() {
        if (heading == DOWN) {
            return coordinateY + height;
        } else {
            return coordinateY;
        }
    }

    public boolean shoot(float startX, float startY, int direction) {
        if(!isActive) {
            coordinateX = startX;
            coordinateY = startY;
            heading = direction;
            isActive = true;

            return true;
        }

        return false;
    }

    public void update(long fps) {
        if (heading == UP) {
            coordinateY = coordinateY - speed / fps;
        } else {
            coordinateY = coordinateY + speed / fps;
        }

        rect.left = coordinateX;
        rect.right = coordinateX + width;
        rect.top = coordinateY;
        rect.bottom = coordinateY + height;
    }

    public static final int UP = 0;
    public static final int DOWN = 1;

    private float coordinateX;
    private float coordinateY;

    private RectF rect;

    private int heading = -1;
    private int speed = 350;

    private int width = 1;
    private int height;

    private boolean isActive;
}

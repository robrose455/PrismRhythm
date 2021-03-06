package ge.core.sprite.controller;

public class SpriteWASDController extends Controller {

    boolean wPressed;
    boolean sPressed;
    boolean aPressed;
    boolean dPressed;

    public SpriteWASDController() { }

    public boolean isMovingUp() {
        return wPressed;
    }
    public boolean isMovingDown() {
        return sPressed;
    }
    public boolean isMovingLeft() {
        return aPressed;
    }
    public boolean isMovingRight() {
        return dPressed;
    }

    public void movingUp() {
        wPressed = true;
    }
    public void movingDown() {
        sPressed = true;
    }
    public void movingLeft() {
        aPressed = true;
    }
    public void movingRight() {
        dPressed = true;
    }

    //Resets Keys for the next frame
    public void ResetKeys() {

        wPressed = false;
        sPressed = false;
        aPressed = false;
        dPressed = false;

    }

    public String typeOfController() {
        return "WASD";
    }
}

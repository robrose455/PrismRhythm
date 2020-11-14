package ge.core;

import ge.*;
import ge.KeyManager;
import ge.MouseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneManager extends JPanel implements  ActionListener {

    //Create both options for sprite controllers to be used as parameters
    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

    //Scene Canvas Reference
    Scene sc;

    //Reference to the current loaded game
    Game game;

    //Handles Sprite Drawing, Adding, and Removal
    SpriteManager sprM;

    //Handles Key Inputs
    KeyManager km;

    //Handles Mouse Inputs
    MouseManager mm;

    //Handles all text on Scene
    TextManager tm;

    //Handles current state of game (win or loss)
    GameStateManager gsm;

    //Create Timer
    Timer t = new Timer(10, this);

    public SceneManager(Scene s) {

        //Set Initial Background
        this.setBackground(Color.BLACK);

        //Initialize all Listeners and Sprites
        this.sc = s;
        game = sc.getGame();

        this.sprM = new SpriteManager(this,game);
        this.km = new KeyManager(this);
        this.mm = new MouseManager(this);
        this.tm = new TextManager(this);
        this.gsm = new GameStateManager(this);

        game.Init(this);


        //Initialize All Designated Sprites to be Active Sprites
        //TestGame();
        //Start Timer
        t.start();

    }

    @Override

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        sprM.drawSprites(g);
        tm.drawText(g);

        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        if (gsm.isWinner()) {
            g.setFont(smallFont);
            g.drawString("You did it!", 350, 130);
            g.setFont(smallFont);
        }

    }

    public void actionPerformed(ActionEvent e) {
        Update();
    }

    public void Update() {

        //Update Each Frame According to Game Logic
        game.Update();
        //Repaint All Changes Made
        this.repaint();

    }

    public void TestGame() {

        //Test a basic game onto the scene here

    }

    public Scene getScene() {
        return sc;
    }
    public Game getGame() { return game; }
    public SpriteManager getSpriteManager() {
        return sprM;
    }
    public GameStateManager getGameStateManager() {
        return gsm;
    }
    public TextManager getTextManager() { return tm; }
    public KeyManager getKeyManager() { return km; }
    public MouseManager getMouseManager() { return mm; }


}
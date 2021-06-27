import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class pomodoro1point0 extends PApplet {


long startTime = System.nanoTime();
long deltaTime = 0;
long pauseTime = 0;
int sec; int min;
int state;
int prevState;

public void setup() {
  surface.setTitle("Pomodoro by Ian Chasse, 2021");
  surface.setResizable(true);
  
  textSize(110);
  textAlign(CENTER);
  state = 1; // in a 25 min lap
  
  
}

public void draw() {
  println("Pause time: " + pauseTime);
  println("Pause time: " + startTime);
  background(30);
  if (state != 3) {
    sec = (int)((((System.nanoTime() - deltaTime) - startTime) / 1000000000));
    min = sec / 60;
  }
  else {
    sec = (int)(((pauseTime - startTime) / 1000000000));
    min = sec / 60;
  }
  String display = (String.format("%02d", min) + ":" + String.format("%02d" , sec % 60));
  if (min >= 25 && state == 1) {
    state = 2;
    startTime = System.nanoTime(); sec = 0; min = 0;
      
  }
  if (min >= 5 && state == 2) {
    state = 1;
    startTime = System.nanoTime(); sec = 0; min = 0;
  }  
  text(display, 300, 200);
  
  
  switch(state){
    case 1: text("Study time!", 300, 350); break;
    case 2: text("Break time!", 300, 350); break;
    case 3: text("Paused.", 300, 350); break;
  }
}


public void mouseClicked() {
  if (state == 3) {
    state = prevState;
    prevState = 3;
    deltaTime = System.nanoTime() - pauseTime;
  }
  else {
     prevState = state;
     state = 3;
     pauseTime = System.nanoTime();
     
     println("paused"); 
  }
  
}
  public void settings() {  size(600,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "pomodoro1point0" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

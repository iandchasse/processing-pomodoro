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
long pauseTime;
int sec; int min;
boolean running = false;
int state;

public void setup() {
  System.out.println("Hello World");
  
  textSize(110);
  textAlign(CENTER);
  state = 1; // in a 25 min lap
  
  //clock();
  
}

//void clock() {
//  int sec = (int)(((System.nanoTime() - startTime) / 1000000000));
//  int min = sec / 60;
//  if (min < 25){
//    sec = (int)(((System.nanoTime() - startTime) / 1000000000));
//    min = sec / 60;
//    draw();
//  }
//  println("yo");
//  startTime = System.nanoTime();
//  sec = (int)(((System.nanoTime() - startTime) / 1000000000));
//  min = sec / 60;
//  println(min);
//  if (min < 5) {
//    sec = (int)(((System.nanoTime() - startTime) / 1000000000));
//    min = sec / 60;
//    draw();
//  }
//  startTime = System.nanoTime();
//}

public void draw() {
  println(state);
  background(30);
  sec = (int)(((System.nanoTime() - startTime) / 1000000000));
  min = sec / 60;
  String display = (String.format("%02d", min) + ":" + String.format("%02d" , sec % 60));
  if (min >= 25 && state == 1) {
    state = 2;
    startTime = System.nanoTime(); sec = 0; min = 0;
      
  }
  if (min >= 5 && state == 2) {
    state = 2;
    startTime = System.nanoTime(); sec = 0; min = 0;
  }
  text(display, 300, 200);
  switch(state){
    case 1: text("Study time!", 300, 350); break;
    case 2: text("Break time!", 300, 350); break;
  }
}


//void pauseButton(running, elapsed) {
//  if (running) {
    
//  }
//  else {
//    pauseTime = System.nanoTime();
    
//  }
//}
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

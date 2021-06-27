
long startTime = System.nanoTime();
long pauseTime;
int sec; int min;
boolean running = false;
int state;

void setup() {
  System.out.println("Hello World");
  size(600,400);
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

void draw() {
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

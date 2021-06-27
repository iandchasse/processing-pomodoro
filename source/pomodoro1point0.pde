
long startTime = System.nanoTime();
long deltaTime = 0;
long pauseTime = 0;
int sec; int min;
int state;
int prevState;

void setup() {
  surface.setTitle("Pomodoro by Ian Chasse, 2021");
  surface.setResizable(true);
  size(600,400);
  textSize(110);
  textAlign(CENTER);
  state = 1; // in a 25 min lap
  
  
}

void draw() {
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


void mouseClicked() {
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

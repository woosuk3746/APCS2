//Woosuk Lee
//APCS2 pd8
//HW52 -- Grow & Shrink
//2018-5-23 W

float x=0; //counter
float radius = 5; //starting radius

void setup(){
  size(400,400); //window size 400 * 400
  color(0,0,0);
}

void draw(){
  color(255,255,255);
  //take advantage of the parity of the counter to grow or shrink
  if(x%2==0 && x!=0){
    ellipse(200,200,radius,radius);
    radius--;
  }
  else if(x!=0){
    ellipse(200,200,radius,radius);
    radius++;
  }
}

void mouseClicked(){
  x++; //increment counter
}

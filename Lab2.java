public class Lab2
{ 
  public static void turnRight(double delay) {
      for (int i=1; i<=3; i++) {
          Robot.setDelay(0); //unnecessary, but delayless turning
          Robot.turnLeft(); 
          Robot.setDelay(delay); //using an arg is even more unnecessary but allows for universal usage if needed
      }
  }
  public static void cleanSquare()
  {
    Robot.load("square.txt");
    Robot.setDelay(0.1);
    
    for (int i=1; i<=24; i++) {
        if (Robot.onDark()) {Robot.makeLight();}
        if (!Robot.frontIsClear()) {Robot.turnLeft();}
        Robot.move();
    }
  }
  
  public static void darkenComb()
  {
    Robot.load("comb.txt");
    Robot.setDelay(0.05);
    Lab2.turnRight(0.05);
    for (int i=1; i<=63; i++) {
        if (!Robot.onDark()) {Robot.makeDark();}
        for (int k = 1; k<=2; k++) {if (!Robot.frontIsClear()) {Lab2.turnRight(0.05);}}
        Robot.move();
        Lab2.turnRight(0.05);
        if (!Robot.frontIsClear()) {Robot.turnLeft();}
    }
  }
  
  public static void makeCheckered()
  {
    Robot.load("blank.txt");
    Robot.setDelay(0.05);
    
    for (int col=1; col<= 8; col++) {
        for (int row=1; row<=8; row++) {
           if (row % 2 == 1) {Robot.makeDark();} //if I had robot's x/y (private vars :( ) I would use (x+y) % 2
           if (Robot.frontIsClear()) {Robot.move();}
           else {
               if (col % 2 == 1) {Lab2.turnRight(0.05);}
               else {Robot.turnLeft();}
               if (col != 8) {Robot.move();}
               if (col % 2 == 1) {Lab2.turnRight(0.05);}
               else {Robot.turnLeft();} 
           }
        }
    }
  }
}
import java.util.*;
import Game.*;

class Main {
  static boolean running = true;
  static int level = 0;
  static double dMult = 1;
  static Scanner scan = new Scanner(System.in);
  static Group group;

  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";

  public static final String BLACK_BACKGROUND = "\u001B[40m";
  public static final String RED_BACKGROUND = "\u001B[41m";
  public static final String GREEN_BACKGROUND = "\u001B[42m";
  public static final String YELLOW_BACKGROUND = "\u001B[43m";
  public static final String BLUE_BACKGROUND = "\u001B[44m";
  public static final String PURPLE_BACKGROUND = "\u001B[45m";
  public static final String CYAN_BACKGROUND = "\u001B[46m";
  public static final String WHITE_BACKGROUND = "\u001B[47m";

  public static void Print(String color, String text, boolean ln){
    if(ln){
      System.out.println(color + text + RESET);
    }
    else{
      System.out.print(color + text + RESET);
    }
  }

  public static void Print(String background, String color, String text, boolean ln){
    if(ln){
      System.out.println(background + color + text + RESET);
    }
    else{
      System.out.print(background + color + text + RESET);
    }
  }

  public static void Delay(int mTime){
    try{
      Thread.sleep(mTime);
    } catch(InterruptedException e){
    }
  }

  public static void Setup(){
    System.out.print("Loading");
    Delay(1000);
    System.out.print(".");
    Delay(1000);
    System.out  .print(".");
    Delay(1000);
    System.out.println(".");
    Delay(1000);
  }

  public static void Help(){
    Print(YELLOW, "Add Help Stuff here later for the noobs", true);
    MenuHandler();
  }

  public static void MenuHandler(){
    Print(RED, " ____  __  ____  ____  __ _  __  ____  ____ \n(  __)/  \\(  _ \\(_  _)(  ( \\(  )(_  _)(  __)\n ) _)(  O ))   /  )(  /    / )(   )(   ) _) \n(__)  \\__/(__\\_) (__) \\_)__)(__) (__) (____)", true);
    Print(RED, "\t\tWill you kill the little kids", true);
    Print(GREEN, "1. Start", true);
    Print(YELLOW, "2. Help", true);
    Print(RED, "3. Quit", true);
    int choice = scan.nextInt();
    if(choice == 1){
      Start();
    }
    else if(choice == 2){
      Help();
    }
    else if(choice == 3){
      running = false;
    }
    else{
      Print(RED, "Your Retarded", true);
      MenuHandler();
    }
  }

  public static void EventHandler(){
    int input = scan.nextInt();
  }

  public static void Start(){
    Print(GREEN, "1: Easy", true);
    Print(YELLOW, "2: Normal", true);
    Print(RED, "3: Hard", true); 
    int diff = scan.nextInt(); 
    if (diff == 1){
      dMult = 0.75;
    }
    else if (diff == 2){
      dMult = 1;
    }
    else if (diff == 3){
      dMult = 3;

    }
    else{
      Print(RED, "That is not a valid option.", true);
    }

    
  }

  public static void main(String[] args){
    Setup();
    MenuHandler();
    while(running){
      
    }
  }
}
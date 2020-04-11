import java.util.Scanner;
import Game.*;

class Main {
  static boolean running = true;
  static int gameState = 0;

  static int level = 0;
  static float dMult = 1;
  static Scanner scan = new Scanner(System.in);
  static Group group;
  static int posX = 10;
  static int posY = 10;
  static Map selectedMap;

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

  public static final String CLEAR = "\033[H\033[2J";

  //Monster Type
  static Monster crab;

  //Maps
  static Map testMap = new Map("Maps/Test.txt");

  public static void MonSetup(){
     //                    String pic, int hp, int baseDamage, int levelDamage, float ccrit?, int level, float damageMultiplier
    crab = new Monster("(\\/) (°,,,,°) (\\/)", 4, 2, 25, 0.1f, 0, dMult);
  }

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

  public static void Loading(int times){
    System.out.print(CLEAR);
    Print(BLACK_BACKGROUND, RED, "Loading", false);
    Delay(1000);
    for(int i = 0; i < times; i++){
     Print(BLACK_BACKGROUND, RED, ".", false);
      Delay(250);
    }
    Print(BLACK_BACKGROUND, RED, ".", true);
  }

  public static void Setup(){
    Loading(10);

    selectedMap = testMap;
  }

  public static void Help(){
    Print(YELLOW, "Add Help Stuff here later for the noobs", true);
    Delay(400);
    MenuHandler();
  }

  public static void MenuHandler(){
    System.out.print(CLEAR);
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
      Delay(400);
      MenuHandler();
    }
  }

  public static void Start(){
    System.out.print(CLEAR);
    Print(GREEN, "1: Easy", true);
    Print(YELLOW, "2: Normal", true);
    Print(RED, "3: Hard", true); 
    int diff = scan.nextInt(); 
    if (diff == 1){
      dMult = 0.75f;
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

    //Final Setup
    MonSetup();
  }

  public static void Moving(Map m, String move){
    if (move.equalsIgnoreCase("right") || move.equalsIgnoreCase("d")){
      int val = m.map[posX+1][posY];
      if(val == 0){
        posX++;
      }
      else if(val == 1){
          Print(BLUE, "You cannot Enter Water", true);
          Delay(2000);
      }
      else if(val == 2){
          Print(RED, "A Wall is in your way", true);
          Delay(2000);
      }
    }
    else if (move.equalsIgnoreCase("left") || move.equalsIgnoreCase("a")){
      int val = m.map[posX-1][posY];
      if(val == 0){
        posX--;
      }
      else if(val == 1){
          Print(BLUE, "You cannot Enter Water", true);
          Delay(2000);
      }
      else if(val == 2){
          Print(RED, "A Wall is in your way", true);
          Delay(2000);
      }
    }
    else if (move.equalsIgnoreCase("up") || move.equalsIgnoreCase("w")){
      int val = m.map[posX][posY-1];
      if(val == 0){
        posY--;
      }
      else if(val == 1){
          Print(BLUE, "You cannot Enter Water", true);
          Delay(2000);
      }
      else if(val == 2){
          Print(RED, "A Wall is in your way", true);
          Delay(2000);
      }
    }
    else if (move.equalsIgnoreCase("down") || move.equalsIgnoreCase("s")){
      int val = m.map[posX][posY+1];
      if(val == 0){
        posY++;
      }
      else if(val == 1){
          Print(BLUE, "You cannot Enter Water", true);
          Delay(2000);
      }
      else if(val == 2){
          Print(RED, "A Wall is in your way", true);
          Delay(2000);
      }
    }
    else{
      System.out.println("Invalid Command");
      EventHandler();
    }
  }
  
  public static void EventHandler(){
    Print(RED, "Enter a Command: ", false);
    String input = scan.nextLine();
    Moving(testMap, input);
  }

  public static void RenderHandler(){
    System.out.print(CLEAR);

    if(gameState == 0){
      for(int y = 0; y < 50; y++){
        for(int x = 0; x < 50; x++){
          if(posX == x && posY == y){
            Print(YELLOW, "@", false);
          }
          else if(selectedMap.map[x][y] == 2){
            Print(RED, "1", false);
          }
          else if(selectedMap.map[x][y] == 1){
            Print(BLUE, "1", false);
          }
          else if(selectedMap.map[x][y] == 0){
            Print(GREEN, "0", false);
          }
        }
        System.out.println("");
      }
    }
  }

  public static void main(String[] args){
    Setup();
    MenuHandler();
    while(running){
      RenderHandler();
      EventHandler();
    }
  }
}
package Game;

import java.io.*;
import java.util.Scanner;

public class Map{
  public static int[][] map = new int[50][50];
  public static String[] sMap = new String[50];

  public Map(String loc){
    File file = new File(loc);
    try{
      Scanner scan = new Scanner(file); 
      int y = 0;
      String s = "";
      while (scan.hasNextLine()) {
        s = scan.nextLine();
        sMap[y] = s;
        for(int i = 0; i < s.length(); i++){
          map[i][y] = Character.getNumericValue(s.charAt(i));
        }
        y++;
      }
    } catch(FileNotFoundException e){

    }
  }
}
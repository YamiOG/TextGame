package Game;

import java.lang.*;

public class Monster{
  static int hp = 0;
  static float critC = 0.0f;
  static int bDamage = 0;
  static int lDamage = 0;
  static int level = 0;
  static float dMult = 0;
  static String pic = "";

  public Monster(String p, int h, int bD, int lD, float c, int l, float dM){
    pic = p;
    hp = h;
    critC = c;
    bDamage = bD;
    lDamage = lD;
    level = l;
    dMult = dM;
  }

  public static void Set(String p, int h, int bD, int lD, float c, int l, float dM){
    pic = p;
    hp = h;
    critC = c;
    bDamage = bD;
    lDamage = lD;
    level = l;
    dMult = dM;
  }

  public static void RandLvl(int max, int min){
    int range = max - min + 1;
    int level = (int)(Math.random() * range) + min;
  }

  public static int GetDamage(){
    if((Math.random() * 1.0f) < critC){
      int dmg = (int)((float)(bDamage + (lDamage * level)) * dMult * 1.25f);
      return dmg;
    }
    else{
      int dmg = (int)((float)(bDamage + (lDamage * level)) * dMult);
      return dmg;
    }
  }
}
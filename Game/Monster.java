package Game;

import java.lang.*;

public class Monster{
  static float critC = 0.0f;
  static int bDamage = 0;
  static int lDamage = 0;
  static int level = 0;
  static int dMult = 0;
  static String pic = "";

  public static void Set(String p, int bD, int lD, float c, int l, int dM){
    pic = p;
    critC = c;
    bDamage = bD;
    lDamage = lD;
    level = l;
    dMult = dM;
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
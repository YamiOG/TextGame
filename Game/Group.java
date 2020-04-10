package Game;

public class Group{
  //Melee 0 Mage 1 Range 2
  static int group = -1;
  static int difficulty;

  public Group(int setD){
    difficulty = setD;
  }

  public static void SetGroup(int setG){
    group = setG;
  }

  public static int GetSpeed(int level){
    switch(group){
      case 0:
          return level * 4;
      case 1:
          return level * 2;
      case 2:
          return level * 6;
      default:
        break;
    }
    return -1;
  }

  public static int GetDamage(int level){
    switch(group){
      case 0:
          return level * 30 + 50;
      case 1:
          return level * 50 + 15;
      case 2:
          return level * 20 + 40;
      default:
        break;
    }
    return -1;
  }
}
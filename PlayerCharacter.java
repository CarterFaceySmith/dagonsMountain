package dagonsMountain;

public class PlayerCharacter {
    String playerClass = "";
    String playerVerb = "";
    int playerHealth = 1;
    int playerDMG = 1;
    int playerMP = 1;
    int playerEVD = 1;
    int playerDEF = 1;
    int playerPRC = 1;
    int playXP = 0;
    int playLVL = 1;

        public PlayerCharacter(String playerClass, String playerVerb, int health, int dmg, int mp, int evd, int def, int prc, int xp, int lvl){
                this.playerClass = playerClass;
                this.playerVerb = playerVerb;
                this.playerHealth = health;
                this.playerDMG = dmg;
                this.playerMP = mp;
                this.playerEVD = evd;
                this.playerDEF = def;
                this.playerPRC = prc;
                this.playXP = xp;
                this.playLVL = lvl;
        }

}

package dagonsMountain;
import java.util.Scanner;
import java.util.Random;

public class dagonsMountain {

	//Game methods

	//Assassin Abilities
	public static int shockwave(int enemyHP){
		System.out.println("\tYou channel a shockwave towards the enemy, hitting them for 50 damage.");
		enemyHP -= 50;
		return enemyHP;
	}

	public static int siphon(int enemyHP){
		System.out.println("\tYou channel a siphon towards the enemy, absorbing 20 points of health.");
		enemyHP -= 20;
		return enemyHP;
	}

	public static int focusedBlast(int enemyHP){
		System.out.println("\tYou channel a focused blast towards the enemy, hitting them for 100 damage.");
		enemyHP -= 100;
		return enemyHP;
	}

	public static int heavySwing(int enemyHP){
		System.out.println("\tYou wind your arm back before sending your sword arcing toward the enemy, slicing them for 50 damage and straining your arms for 15.");
		enemyHP -= 50;
		return enemyHP;
	}

	public static int shoulderCharge(int enemyHP){
		System.out.println("\tThe earth cracks beneath you as you send your shoulder slamming into the enemy, crushing their body for 150 damage and injuring you for 30.");
		enemyHP -= 150;
		return enemyHP;
	}

	public static int rest(int playerHP){
		System.out.println("\tYou take a moment to collect yourself and centre your spirit, gaining 20 health.");
		playerHP += 20;
		return playerHP;
	}

	public static int pinpointThrow(int enemyHP){
		System.out.println("\tYou send your throwing knife soaring towards the enemy, hitting them for 30 damage.");
		enemyHP -= 30;
		return enemyHP;
	}

	/*public static int blend(int ){
		System.out.println("\tYou dissolve into the shadows surrounding you, increasing your evasion.");
		return ;
	}*/

	public static int crossSlice(int enemyHP){
		System.out.println("\tYou leap high above the enemy, before coming hurtling down and ripping through them for 70 damage.");
		enemyHP -= 70;
		return enemyHP;
	}

	public static int enemyBasicAtk(int playerHP, int playerDEF, int playerEVD, int enemyATK, String enemyName, String atkVerb, Random rand){
		boolean ifDodge = false;
		
		if ((playerEVD / rand.nextInt(100)) > enemyATK){
			ifDodge = true;
		}

		if (ifDodge == true){
			System.out.println("\tYou dodged the " + enemyName + "'s attack!\n");
			return playerHP;
		}

		else {
			int dmgVal = enemyATK - (playerDEF / 2);
			
			if (dmgVal > 0){
				playerHP -= dmgVal;
				System.out.println("\tThe " + enemyName + " " + atkVerb + " you for " + dmgVal + " damage in retaliation!");
				return playerHP;
			}
			
			else {
				System.out.println("\tYou defend against the strike! It glances off you dealing no damage.\n");
				return playerHP;
			}
			
		}
		
	}

	public static void main(String[] args) {

		//System objects
		Scanner scnr = new Scanner(System.in);	
		Random rand = new Random();
		String userInput;

		//Game variables

			//Enemy variables
			String[] enemies = {"Slime", "Skeleton", "Warrior", "Assassin", "Lesser Daemon", "Ghost of Spicy Curry"};
			String[] enemyAttackVerbs = {"goops", "clubs", "cleaves", "slices", "burns", "evicerates"};
			int[] enemyHealth = {10, 50, 75, 40, 100, 1000};
			int[] enemyAttackDamage = {1, 10, 20, 40, 30, 50};
			int[] enemyMP = {0, 10, 20, 40, 100, 1000};

			//Boss variables
			//FIXME: Add boss instance and data

		//General player variables
		String[] playerClass = {"Mage", "Warrior", "Assassin"};
		String[] playerAttackVerbs = {"shock", "cleave", "rend"};
		String[] mageAbilityNames = {"Shockwave", "Siphon", "Focused Blast"};
		String[] mageAbilityDescriptions = {"(20 MP)(50 DMG) An electrical shockwave surges towards the enemy.", "(10 MP)(+20 HP) You connect to the enemy's spirit, siphoning health for yourself.", "(50 MP)(50 DMG) You charge up a blast of focused energy and send it flying towards the enemy."};
		String[] warriorAbilityNames = {"Heavy Swing", "Shoulder Charge", "Rest"};
		String[] warriorAbilityDescriptions = {"(-15 HP)(50 DMG) You strain under the might of your own swing, slashing the enemy with immense strength.", "(-30 HP)(150 DMG) You hurtle through the air towards the enemy, slamming into them with your armor-clad shoulder.", "(+20 HP) You take a moment to rest and recover from the strain of your body."};
		String[] assassinAbilityNames = {"Pinpoint Throw", "Blend", "Cross Slice"};
		String[] assassinAbilityDescriptions = {"(15 MP)(x DMG) You throw your knife at the enemy with deadly precision.", "(x MP) Your eyes shift as you fade into your surroundings, increasing your evasion.", "(30 MP)(70 DMG) You bring both blades down towards your enemy, striking with ferocious speed."};
		int[] playerHealth = {50, 100, 70};
		int[] attackDamage = {10, 40, 25};
		int[] playerMP = {150, 0, 60};
		int[] playerEvasionPercent = {15, 5, 30};
		int[] playerDefencePercent = {15, 25, 5};
		int[] playerPercepPercent = {35, 15, 20};
		int playerXP = 0;
		int playerLevel = 1;

		//Current player variables
		String currPlayerClass = playerClass[1];
		String currPlayerAttackVerb = playerAttackVerbs[1];
		int currPlayerHealth = playerHealth[1];
		int currPlayerDamage = attackDamage[1];
		int currPlayerMP = playerMP[1];
		int currPlayerEvade = playerEvasionPercent[1];
		int currPlayerDef = playerDefencePercent[1];
		int currPlayerPercep = playerPercepPercent[1];

		

		boolean running = true;

		//Welcome screen and class selection
			System.out.println("#############################################################");
			System.out.println("####                                                     ####");
			System.out.println("####             WELCOME TO DAGON'S MOUNTAIN!            ####");
			System.out.println("####                                                     ####");
			System.out.println("#############################################################");
			System.out.println();

			System.out.println("\tPlease pick your class:");
			System.out.println();

			System.out.println("\t1. Mage");
			System.out.println();
			System.out.println("\tHP: " + playerHealth[0]);
			System.out.println("\tMP: " + playerMP[0]);
			System.out.println("\tEvasion: " + playerEvasionPercent[0]);
			System.out.println("\tDefence: " + playerDefencePercent[0]);
			System.out.println("\tPerception: " + playerPercepPercent[0]);
			System.out.println("\tAttack Damage: " + attackDamage[0]);
			System.out.println();
			System.out.print("\tAbilities: ");
			for(int i = 0; i < mageAbilityNames.length; ++i){
					
					if (i == mageAbilityNames.length - 1){
						System.out.print(mageAbilityNames[i]);
					}
					else {
						System.out.print(mageAbilityNames[i] + ", ");
					}
				};
			System.out.println();
			System.out.println();

			System.out.println("\t2. Warrior");
			System.out.println();
			System.out.println("\tHP: " + playerHealth[1]);
			System.out.println("\tMP: " + playerMP[1]);
			System.out.println("\tEvasion: " + playerEvasionPercent[1]);
			System.out.println("\tDefence: " + playerDefencePercent[1]);
			System.out.println("\tPerception: " + playerPercepPercent[1]);
			System.out.println("\tAttack Damage: " + attackDamage[1]);
			System.out.println();
			System.out.print("\tAbilities: ");
			for(int i = 0; i < warriorAbilityNames.length; ++i){
					
					if (i == warriorAbilityNames.length - 1){
						System.out.print(warriorAbilityNames[i]);
					}
					else {
						System.out.print(warriorAbilityNames[i] + ", ");
					}
				};
			System.out.println();
			System.out.println();

			System.out.println("\t3. Assassin");
			System.out.println();
			System.out.println("\tHP: " + playerHealth[2]);
			System.out.println("\tMP: " + playerMP[2]);
			System.out.println("\tEvasion: " + playerEvasionPercent[2]);
			System.out.println("\tDefence: " + playerDefencePercent[2]);
			System.out.println("\tPerception: " + playerPercepPercent[2]);
			System.out.println("\tAttack Damage: " + attackDamage[2]);
			System.out.println();
			System.out.print("\tAbilities: ");
			for(int i = 0; i < assassinAbilityNames.length; ++i){
					
				if (i == assassinAbilityNames.length - 1){
					System.out.print(assassinAbilityNames[i]);
				}
				else {
					System.out.print(assassinAbilityNames[i] + ", ");
				}
			};
			System.out.println();
			System.out.println();

			userInput = scnr.nextLine();
				if (userInput.equals("1")){
					currPlayerClass = playerClass[0];
					currPlayerAttackVerb = playerAttackVerbs[0];
					currPlayerHealth = playerHealth[0];
					currPlayerDamage = attackDamage[0];
					currPlayerMP = playerMP[0];
					currPlayerEvade = playerEvasionPercent[0];
					currPlayerDef = playerDefencePercent[0];
					currPlayerPercep = playerPercepPercent[0];
					System.out.println("\tYou feel the roar of mana surging through your body, your feet lift from the ground as you levitate forth.");
					System.out.println();
				}
				if (userInput.equals("2")){
					currPlayerClass = playerClass[1];
					currPlayerAttackVerb = playerAttackVerbs[1];
					currPlayerHealth = playerHealth[1];
					currPlayerDamage = attackDamage[1];
					currPlayerMP = playerMP[1];
					currPlayerEvade = playerEvasionPercent[1];
					currPlayerDef = playerDefencePercent[1];
					currPlayerPercep = playerPercepPercent[1];
					System.out.println("\tYour body rushes with adrenaline, you rip your sword from the earth as if it weighs nothing and set forth.");
					System.out.println();
				}
				if (userInput.equals("3")){
					currPlayerClass = playerClass[2];
					currPlayerAttackVerb = playerAttackVerbs[2];
					currPlayerHealth = playerHealth[2];
					currPlayerDamage = attackDamage[2];
					currPlayerMP = playerMP[2];
					currPlayerEvade = playerEvasionPercent[2];
					currPlayerDef = playerDefencePercent[2];
					currPlayerPercep = playerPercepPercent[2];
					System.out.println("\tYour eyes flit towards the shadows creeping around you, fingering your dagger you silently move towards the mountain.");
					System.out.println();
				}

		GAME:
		while(running){
			
			System.out.println("-------------------------------------");

			//Initialize enemy
			int setEnemy = rand.nextInt(enemies.length);
			String enemy = enemies[setEnemy];
			int currEnemyAttack = enemyAttackDamage[setEnemy];
			String currEnemyVerb = enemyAttackVerbs[setEnemy];
			int currEnemyHealth = (int)(rand.nextDouble()* (playerLevel * enemyHealth[setEnemy]));
			int enemyXP = (int)(rand.nextDouble()*(enemyAttackDamage[setEnemy] + currEnemyHealth + enemyMP[setEnemy]) / playerLevel);


			System.out.println("\t# " + enemy + " appeared! #\n");

			BATTLE:
			while(currEnemyHealth > 0){

				//Battle state
					
					//Choice output
					System.out.println("\tYour HP: " + currPlayerHealth);
					System.out.println("\tYour MP: " + currPlayerMP);
					System.out.println("\tYour XP: " + playerXP + "/" + (playerLevel * 100) + "\n");
					System.out.println("\t" + enemy + "'s HP: " + currEnemyHealth);
					System.out.println("\n\tWhat will you do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Use ability");
					System.out.println("\t3. Run");
					System.out.println();

					//Result output
					userInput = scnr.nextLine();

					if (userInput.equals("1")){
						System.out.println("\tYou " + currPlayerAttackVerb + " the " + enemy + " for " + currPlayerDamage + " damage!");
						currEnemyHealth -= currPlayerDamage;

						if (currEnemyHealth > 0){
						currPlayerHealth = enemyBasicAtk(currPlayerHealth, currPlayerDef, currPlayerEvade, currEnemyAttack, enemy, currEnemyVerb, rand);
						System.out.println();
						}
					}

					if (userInput.equals("2")){

						if (currPlayerClass.equals("Mage")){

							for(int i = 0; i < mageAbilityNames.length; ++i){
								System.out.println("\t" + i + ". " + mageAbilityNames[i] + ": " + mageAbilityDescriptions[i]);
								System.out.println();
							}

							System.out.println("\t3. Return to previous menu");
							System.out.println();
							System.out.println("\tWhich ability will you use?");

							String abilityInput = scnr.nextLine();

							if(abilityInput.equals("0")){
								currEnemyHealth = shockwave(currEnemyHealth);
								currPlayerMP -= 20;
								System.out.println();
							}

							else if(abilityInput.equals("1")){
								currEnemyHealth = siphon(currEnemyHealth);
								currPlayerMP -= 10;
								currPlayerHealth += 20;
								System.out.println();
							}
							
							else if(abilityInput.equals("2")){
								currEnemyHealth = focusedBlast(currEnemyHealth);
								currPlayerMP -= 50;
								System.out.println();
							}

							else if(abilityInput.equals("3")){
								continue BATTLE;
							}
							
							if (currEnemyHealth > 0){
							currPlayerHealth = enemyBasicAtk(currPlayerHealth, currPlayerDef, currPlayerEvade, currEnemyAttack, enemy, currEnemyVerb, rand);
							System.out.println();
							}
						}
					

						if(currPlayerClass.equals("Warrior")){

							for(int i = 0; i < warriorAbilityNames.length; ++i){
								System.out.println("\t" + i + ". " + warriorAbilityNames[i] + ": " + warriorAbilityDescriptions[i]);
								System.out.println();
							}

							System.out.println("\t3. Return to previous menu");
							System.out.println();
							System.out.println("\tWhich ability will you use?");

							String abilityInput = scnr.nextLine();

							if(abilityInput.equals("0")){
								currEnemyHealth = heavySwing(currEnemyHealth);
								currPlayerHealth -= 15;
								System.out.println();
							}

							else if(abilityInput.equals("1")){
								currEnemyHealth = shoulderCharge(currEnemyHealth);
								currPlayerHealth -= 30;
								System.out.println();
							}
							
							else if(abilityInput.equals("2")){
								currPlayerHealth = rest(currPlayerHealth);
								System.out.println();
							}

							else if(abilityInput.equals("3")){
								continue BATTLE;
							}
							
							if (currEnemyHealth > 0){
								currPlayerHealth = enemyBasicAtk(currPlayerHealth, currPlayerDef, currPlayerEvade, currEnemyAttack, enemy, currEnemyVerb, rand);
								System.out.println();

							}
						}

						if(currPlayerClass.equals("Assassin")){
							
							for(int i = 0; i < assassinAbilityNames.length; ++i){
								System.out.println("\t" + i + ". " + assassinAbilityNames[i] + ": " + assassinAbilityDescriptions[i]);
								System.out.println();
							}

							System.out.println("\t3. Return to previous menu");
							System.out.println();
							System.out.println("\tWhich ability will you use?");

							String abilityInput = scnr.nextLine();

							if(abilityInput.equals("0")){
								currEnemyHealth = pinpointThrow(currEnemyHealth);
								currPlayerMP -= 15;
								System.out.println();
							}

							else if(abilityInput.equals("1")){
								System.out.println("Blend not yet implemented.");
								continue BATTLE;
								//currEnemyHealth = blend();
								//currPlayerMP -= 15;
								//System.out.println();
							}
							
							else if(abilityInput.equals("2")){
								currEnemyHealth = crossSlice(currEnemyHealth);
								currPlayerMP -= 30;
								System.out.println();
							}

							else if(abilityInput.equals("3")){
								continue BATTLE;
							}
							
							if (currEnemyHealth > 0){
							currPlayerHealth = enemyBasicAtk(currPlayerHealth, currPlayerDef, currPlayerEvade, currEnemyAttack, enemy, currEnemyVerb, rand);
							System.out.println();
						
						}
					}
							

						
						
					

					if (userInput.equals("3")){
						System.out.println("\tYou move swiftly, retreating from danger...");
						System.out.println();
						continue GAME;
					}

					else if ((!userInput.equals("1")) && (!userInput.equals("2")) && (!userInput.equals("3"))){
						System.out.println("\tYou ponder your next move, eyes glancing towards the " + enemy + " before you.\n");
					}
			}

				//Loss state
				if (currPlayerHealth < 1) {
					System.out.println("\tAs your stamina falters, the " + enemy + " sees it's opportunity and " + enemyAttackVerbs[setEnemy] + " you a final time, dealing a lethal blow.");
					System.out.println("\tYou fall to your knees, the vast grey expanse of the roiling sky your final sight as your vision fades.");
					System.out.println("\tYour mangled corpse has joined the many others littering the mountain.");
					System.exit(0);
				}

				//Win state, level up state, and continue or exit choice
				if(currEnemyHealth < 1) {
					
					if (currPlayerClass.equals("Mage")){
						System.out.println("\tGathering the remaining might of your mana, you unleash a bolt that scorches the " + enemy + " until nothing remains!");
						System.out.println();
					}
					
					else if (currPlayerClass.equals("Warrior")){
						System.out.println("\tWith a final mighty swing, you cleave the " + enemy + " in two!");
						System.out.println();
					}
					
					else if (currPlayerClass.equals("Assassin")){
						System.out.println("\tAs the " + enemy + " stumbles before you, you seize your chance, swiftly sending a knife burrowing into it's vital point!");
						System.out.println();
					}

					System.out.println("\tYou gained " + enemyXP + "XP for defeating the " + enemy + "!\n");
					playerXP += enemyXP;

				}
			
				
					if(playerXP >= (playerLevel * 100)){
						int levels = playerXP / 100;
						playerLevel += levels;
						System.out.println("\tYou feel energy surge through you, you have reached level " + playerLevel + "!\n");
						int pointsLeftCount = 3;

						LEVELING:
						while(pointsLeftCount > 0){
						System.out.println("\tWhich stat will you upgrade?\n");
						System.out.println("\tPoints left: " + pointsLeftCount + "/3\n");
						System.out.println("\t0. +5 Health");
						System.out.println("\t1. +5 Mana");
						System.out.println("\t2. +2 Attack Damage");
						System.out.println("\t3. +1 Evasion");
						System.out.println("\t4. +1 Defence");
						System.out.println("\t5. +1 Perception");

						userInput = scnr.nextLine();
						
						if(userInput.equals("0")){
							currPlayerHealth += 5;
							System.out.println("\tHealth increased by 5!\n");
							pointsLeftCount -= 1;
							continue LEVELING;
						}

						if(userInput.equals("1")){
							currPlayerMP += 5;
							System.out.println("\tMana increased by 5!\n");
							pointsLeftCount -= 1;
							continue LEVELING;
						}

						if(userInput.equals("2")){
							currPlayerDamage += 2;
							System.out.println("\tDamage increased by 2!\n");
							pointsLeftCount -= 1;
							continue LEVELING;
						}

						if(userInput.equals("3")){
							currPlayerEvade += 1;
							System.out.println("\tEvasion increased by 5!\n");
							pointsLeftCount -= 1;
							continue LEVELING;
						}

						if(userInput.equals("4")){
							currPlayerHealth += 1;
							System.out.println("\tDefence increased by 5!\n");
							pointsLeftCount -= 1;
							continue LEVELING;
						}

						if(userInput.equals("5")){
							currPlayerPercep += 1;
							System.out.println("\tPerception increased by 5!\n");
							pointsLeftCount -= 1;
							continue LEVELING;
						}

					}

					System.out.println("\tJourney further up the mountain?");
					System.out.println("\t1. Venture onwards.");
					System.out.println("\t2. Return to the base of the mountain.");

					userInput = scnr.nextLine();
					if (userInput.equals("1")){
						continue GAME;
					}
					if(userInput.equals("2")){
						System.out.println("\tYou return to the base of the mountain bruised and battered, but alive to fight another day.");
						System.exit(0);
					}
				}
			}

			

			

		}
	}
}
	





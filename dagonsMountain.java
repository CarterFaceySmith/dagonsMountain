package dagonsMountain;
import java.util.Scanner;
import java.util.Random;

public class dagonsMountain {
	public static void main(String[] args) {

		//Game methods
		

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


		//General player variables
		String[] playerClass = {"Mage", "Warrior", "Assassin"};
		String[] playerAttackVerbs = {"shock", "cleave", "rend"};
		int[] playerHealth = {50, 100, 70};
		int[] attackDamage = {20, 50, 30};
		int[] playerMP = {100, 20, 40};

		//Current player variables
		String currPlayerClass = playerClass[1];
		String currPlayerAttackVerb = playerAttackVerbs[1];
		int currPlayerHealth = playerHealth[1];
		int currPlayerDamage = attackDamage[1];
		int currPlayerMP = playerMP[1];
		
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
			System.out.println("\tHP: " + playerHealth[0]);
			System.out.println("\tMP: " + playerMP[0]);
			System.out.println("\tAttack Damage: " + attackDamage[0]);
			System.out.println();

			System.out.println("\t2. Warrior");
			System.out.println("\tHP: " + playerHealth[1]);
			System.out.println("\tMP: " + playerMP[1]);
			System.out.println("\tAttack Damage: " + attackDamage[1]);
			System.out.println();

			System.out.println("\t3. Assassin");
			System.out.println("\tHP: " + playerHealth[2]);
			System.out.println("\tMP: " + playerMP[2]);
			System.out.println("\tAttack Damage: " + attackDamage[2]);
			System.out.println();

			userInput = scnr.nextLine();
				if (userInput.equals("1")){
					currPlayerClass = playerClass[0];
					currPlayerAttackVerb = playerAttackVerbs[0];
					currPlayerHealth = playerHealth[0];
					currPlayerDamage = attackDamage[0];
					currPlayerMP = playerMP[0];
					System.out.println("\tYou feel the roar of mana surging through your body, your feet lift from the ground as you levitate forth.");
					System.out.println();
				}
				if (userInput.equals("2")){
					currPlayerClass = playerClass[1];
					currPlayerAttackVerb = playerAttackVerbs[1];
					currPlayerHealth = playerHealth[1];
					currPlayerDamage = attackDamage[1];
					currPlayerMP = playerMP[1];
					System.out.println("\tYour body rushes with adrenaline, you rip your sword from the earth as if it weighs nothing and set forth.");
					System.out.println();
				}
				if (userInput.equals("3")){
					currPlayerClass = playerClass[2];
					currPlayerAttackVerb = playerAttackVerbs[2];
					currPlayerHealth = playerHealth[2];
					currPlayerDamage = attackDamage[2];
					currPlayerMP = playerMP[2];
					System.out.println("\tYour eyes flit towards the shadows creeping around you, fingering your dagger you silently move towards the mountain..");
					System.out.println();
				}

		GAME:
		while(running){
			
			System.out.println("-------------------------------------");

			int setEnemy = rand.nextInt(enemies.length);
			String enemy = enemies[setEnemy];
			int currEnemyHealth = enemyHealth[setEnemy];

			System.out.println("\t# " + enemy + " appeared! #\n");

			while(currEnemyHealth > 0){

				//Battle state

					//Choice output
					System.out.println("\tYour HP: " + currPlayerHealth);
					System.out.println("\t" + enemy + "'s HP: " + currEnemyHealth);
					System.out.println("\n\tWhat will you do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Run");
					System.out.println();

					//Result output
					userInput = scnr.nextLine();

					if (userInput.equals("1")){
						System.out.println("\tYou " + currPlayerAttackVerb + " the " + enemy + " for " + currPlayerDamage + " damage!");
						currEnemyHealth -= currPlayerDamage;
						System.out.println("\tThe " + enemy + " " + enemyAttackVerbs[setEnemy] + " you for " + enemyAttackDamage[setEnemy] + " damage in retaliation!");
						currPlayerHealth -= enemyAttackDamage[setEnemy];
						System.out.println();
					}

					if (userInput.equals("2")){
						System.out.println("\tYou ran like a coward...");
						System.out.println();
						continue GAME;
					}

					else if ((!userInput.equals("1")) && (!userInput.equals("2"))){
						System.out.println("\tYou ponder your next move, eyes glancing towards the " + enemy + " before you.");
					}
				
				//Loss state
				if (currPlayerHealth < 1) {
					System.out.println("\tAs your stamina falters, the " + enemy + " sees it's opportunity and " + enemyAttackVerbs[setEnemy] + " you a final time, dealing a lethal blow.");
					System.out.println("\tYou fall to your knees, the vast grey expanse of the roiling sky your final sight as your vision fades.");
					System.out.println("\tYour mangled corpse has joined the many others littering the mountain.");
					System.exit(0);
				}

				//Win state and continue or exit choice
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
						System.out.println("\tAs the " + enemy + " stumbles from before you, you seize your chance, swiftly sending the knife burrowing into it's vital point!");
						System.out.println();
					}
				
					System.out.println("\tJourney further up the mountain?");
					System.out.println("\t1. Venture onwards.");
					System.out.println("\t2. Return to the base of the mountain.");

					userInput = scnr.nextLine();
					if (userInput.equals("1")){
						continue GAME;
					}
					if(userInput.equals("2")){
						System.out.println("\tYou return to the base of the mountain a bruised and battered warrior.");
						System.exit(0);
					}
				}

			}

			

		}

	}
}

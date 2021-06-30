/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinalproject;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Sarah
 */
public class JavaFinalProject {
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        
        int menu = 1, dice = 0, i = 0, tempInput = 0;
        
        String[] data;
        String fileName;
        
        int charclass;
        String name;
        int attack = 0, defense = 0, sanity = 0, knowledge = 0, speed = 0;
        
        Scanner scan = new Scanner(System.in);
        Characters driver = new Characters();

        while(menu != 5){
            System.out.println("Welcome to the character manager! Please select the option you would like to use.");
            System.out.println("Enter 1 to create a new character");
            System.out.println("Enter 2 if you would like to select a character already created.");
            System.out.println("Enter 3 to save a character to a file");
            System.out.println("Enter 4 to perform an action!");
            System.out.println("Enter 5 if you would like to exit the character manager");
            System.out.println();
            menu = scan.nextInt();
            if (menu == 1){
                
                System.out.println("Choose a character:");
                System.out.println("Enter 1 for Wizard");
                System.out.println("Enter 2 for Archer");
                System.out.println("Enter 3 for Hunter");
                System.out.println("Enter 4 for Knight");
                charclass = scan.nextInt();
                
                System.out.println("Enter your character's name:");
                name = scan.next();
                
                for (int a = 0; a < 5; a++) 
                {
                    
                    //while(a>5)
                    
                    i = driver.rollNum();
                        System.out.println("Assign " + i + " points to your stats");
                        System.out.println("Enter 1 for attack");
                        System.out.println("Enter 2 for defense");
                        System.out.println("Enter 3 for sanity");
                        System.out.println("Enter 4 for knowledge");
                        System.out.println("Enter 5 for speed");
                    tempInput = scan.nextInt();
                    if (tempInput == 1)
                        attack = i;
                    else if (tempInput == 2)
                        defense = i;
                    else if (tempInput == 3)
                        sanity = i;
                    else if (tempInput == 4)
                        knowledge = i;
                    else if (tempInput == 5)
                        speed = i;
                    else{
                        System.out.println("Please enter a digit 1-5");
                        a--;
                    }
                }
                driver.createCharacter(name, charclass, attack, defense, sanity, knowledge, speed);
            } 
        
    
            else if (menu == 2){
                System.out.println("What is your file's name (exclude .txt extension):");
                fileName = scan.next();
                driver.loadCharacter(fileName);
            }

            else if (menu == 3){
                try {
                    System.out.println("What is your file's name (exclude .txt extension):");
                    fileName = scan.next();
                    driver.saveCharacter(fileName);
                }
                catch(IOException e){
                    
                }
            }
            else if (menu == 4){
                
                while(dice <= 0 || dice >= 0){
                    System.out.println("Would you like to roll for 1-Attack, 2-Defense, 3-Sanity, 4-Knowledge, 5-Speed, or Choose 6 for main menu?");
                    dice = scan.nextInt();
                
                    if(dice == 1){
                        System.out.println("You rolled a " + driver.rollAttack());
                        break;
                    }
                    else if(dice == 2){
                        System.out.println("You rolled a " + driver.rollDefense());
                        break;
                    }
                    else if(dice == 3){
                        System.out.println("You rolled a " + driver.rollKnowledge());
                        break;
                    }
                    else if(dice == 4){
                        System.out.println("You rolled a " + driver.rollSanity());
                        break;
                    }
                    else if(dice == 5){
                        System.out.println("You rolled a " + driver.rollSpeed());
                        break;    
                    }
                    else if(dice == 6){
                        break;
                    }
                    else{
                    System.out.println("Please enter one of the single digit numbers");
                        
                    }
                }
                
            }
            else if (menu == 5){
                System.out.println("Thank you! Please come back soon!");
            }
            else {
                System.out.println("Please enter a single digit number");
            }
            
        }
    }

}

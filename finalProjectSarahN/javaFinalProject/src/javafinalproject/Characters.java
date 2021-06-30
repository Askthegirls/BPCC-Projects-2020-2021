/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinalproject;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author Sarah
 */
public class Characters {
    
    /*File directory = new File("directory/path");
       File[] listOfFiles = directory.listFiles();
       Random rand = new Random();
       java.io.FilenameFilter;
       
       
    for (File file : listOfFiles) {
    // Access file.getName() or do anything else here
}*/
    int attack = 0, defense = 0, sanity = 0, knowledge = 0, speed = 0, i = 0, score = 0;
    int charClass;
    String name;
    
    ArrayList<Object> clist = new ArrayList<>();
    ArrayList<Object> character = new ArrayList<>();
    Random rand = new Random();
    
    
    public void createCharacter(String name, int charClass, int attack, int defense, int sanity, int knowledge, int speed) {
        this.charClass = charClass;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.sanity = sanity;
        this.knowledge = knowledge;
        this.speed = speed;
        
        clist.add(new Knight("Lance", 2, 7, 3, 9, 1));
        clist.add(new Archer("Chichi", 3, 4, 8, 1, 2));
        
        if (charClass == 1)
            clist.add(new Wizard(this.name, this.attack, this.defense, this.sanity, this.knowledge, this.speed));
        else if (charClass == 2)
            clist.add(new Archer(this.name, this.attack, this.defense, this.sanity, this.knowledge, this.speed));
        else if (charClass == 3)
            clist.add(new Hunter(this.name, this.attack, this.defense, this.sanity, this.knowledge, this.speed));
        else if (charClass == 4)
            //clist.add(new Knight(this.name, this.attack, this.defense, this.sanity, this.knowledge, this.speed));
            character.add(new Knight(this.name, this.attack, this.defense, this.sanity, this.knowledge, this.speed));
        else{
            System.out.println("Please choose a number");
            
        }
    }
    
    public int rollNum() {
        int num;
        num = rand.nextInt(10);
        num = num+1;
        return num;
    }
    
    public void saveCharacter(String filename) throws IOException{
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to save your character?");
        String save = scan.next();
        if (save.equals("yes") || save.equals("Yes")){
        
            FileWriter writer = new FileWriter(filename+".txt"); 

            int size = character.size();
            writer.write("");
            for(i = 0; i < size; i++){
                writer.write(character.get(i).toString() + System.lineSeparator());
            }
            writer.close();
        
        }
        
    }
    public void loadCharacter(String filename) throws FileNotFoundException{
        Scanner load = new Scanner (new File(filename+".txt"));
        character.clear();
            while (load.hasNextLine()){
                character.add(load.nextLine());
        
            }
    }
    
    
    //Roll dice methods
    public int rollAttack(){
        this.attack = attack;
        i = (attack*attack);
        score = rand.nextInt(i+1);
        return score;
    }
    
    public int rollDefense(){
        this.defense = defense;
        i = defense*defense;
        score = rand.nextInt(i+1);
        return score;
    }
    
    public int rollSanity(){
        this.sanity = sanity;
        i = sanity*sanity;
        score = rand.nextInt(i+1);
        return score;
    }
    
    public int rollKnowledge(){
        this.knowledge = knowledge;
        i = knowledge*knowledge;
        score = rand.nextInt(i+1);
        return score;
    }
    
    public int rollSpeed(){
        this.speed = speed;
        i = speed*speed;
        score = rand.nextInt(i+1);
        return score;
    }
}

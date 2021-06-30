/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinalproject;

/**
 *
 * @author Sarah
 */
public class Archer extends Characters{
    
    String name;
    int attack, defense, sanity, knowledge, speed;
    
    public Archer(String name, int attack, int defense, int sanity, int knowledge, int speed){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.sanity = sanity;
        this.knowledge = knowledge;
        this.speed = speed;
    }
    
    @Override
    public String toString()
    {
        return (name + "|" + attack + "|" + defense + "|"+ sanity + "|" + knowledge + "|" + speed);
    }
}

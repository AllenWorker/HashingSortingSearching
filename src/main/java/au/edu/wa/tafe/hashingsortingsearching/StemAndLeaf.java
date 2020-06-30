/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.wa.tafe.hashingsortingsearching;

import java.util.ArrayList;

/**
 *
 * @author AllenWorker
 */
public class StemAndLeaf {
    int stem;
    ArrayList<Integer> leaves = new ArrayList<>();
    
    public StemAndLeaf(int stem, int leaf){
        this.stem = stem;
        addLeaf(leaf);
    }
    
    public void addLeaf(int leaf){
         this.leaves.add(leaf);
    }
    @Override
    public String toString(){
        String leavesString = "";
        for (int leaf : leaves){
            leavesString += leaf + " ";
        }
        return stem + " | " + leavesString;
    }
}

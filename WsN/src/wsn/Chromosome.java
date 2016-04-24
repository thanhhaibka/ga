/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsn;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hai
 */
public class Chromosome {
    private ArrayList chrom=new ArrayList<Gene>();
    
    public static int num;
    public static int num_r1;
    public static int num_r2;
    public static int num_r3;
    public static double r1;
    public static double r2;
    public static double r3;
    
    public Chromosome(){
        for(int i=0; i<num;i++){
            chrom.add(null);
        }
    }
    
    public void setGene(int i, Gene gene){
        chrom.set(i, gene);
    }
    
    
    public Gene getGene(int i){
        return (Gene)chrom.get(i);
    }
    
    public int getTotal(){
        int total=0;
        for(int m=0; m<=100;m++){
            for(int n=0; n<=100;n++){
                for(int i=0;i<num;i++){
                    if(this.getGene(i).getOverage(m, n)){
                        total+=1;
                        break;
                    }else{
                        
                    }
                }
            }
        }
        return total;
    }
    
    @Override
    public String toString(){
        String c="";
        for(int i=0;i<num;i++){
            c+=this.getGene(i)+" ";
        }
        return c;
    }
    
    public void initChrom(){
        double a, b;
        for(int i=0; i<num_r1;i++){
            a=(double)(Math.random()*100);
            b=(double)(Math.random()*100);
            setGene(i, new Gene(a, b, r1));
        }
        for(int i=num_r1; i<num_r2;i++){
            a=(double)(Math.random()*100);
            b=(double)(Math.random()*100);
            setGene(i, new Gene(a, b, r2));
        }
        for(int i=num_r2; i<num_r3;i++){
            a=(double)(Math.random()*100);
            b=(double)(Math.random()*100);
            setGene(i, new Gene(a, b, r3));
        }
        sortChrom();
    }
    
    public void sortChrom(){
        Gene tempGene=new Gene();
        for(int i=0;i<num_r1-1;i++){
            for(int j=i+1;j<num_r1;j++){
                if(getGene(i).getX()>getGene(j).getX()){
                    tempGene=getGene(i);
                    setGene(i, getGene(j));
                    setGene(j, tempGene);
                }else if(getGene(i).getX()==getGene(j).getX()){
                    if(getGene(i).getY()>getGene(j).getY()){
                        tempGene=getGene(i);
                        setGene(i, getGene(j));
                        setGene(j, tempGene);
                    }else{
                        
                    }
                }else{
                    
                }
            }
        }
        for(int i=num_r1;i<num_r2-1;i++){
            for(int j=i+1;j<num_r2;j++){
                if(getGene(i).getX()>getGene(j).getX()){
                    tempGene=getGene(i);
                    setGene(i, getGene(j));
                    setGene(j, tempGene);
                }else if(getGene(i).getX()==getGene(j).getX()){
                    if(getGene(i).getY()>getGene(j).getY()){
                        tempGene=getGene(i);
                        setGene(i, getGene(j));
                        setGene(j, tempGene);
                    }else{
                        
                    }
                }else{
                    
                }
            }
        }
        for(int i=num_r2;i<num_r3-1;i++){
            for(int j=i+1;j<num_r3;j++){
                if(getGene(i).getX()>getGene(j).getX()){
                    tempGene=getGene(i);
                    setGene(i, getGene(j));
                    setGene(j, tempGene);
                }else if(getGene(i).getX()==getGene(j).getX()){
                    if(getGene(i).getY()>getGene(j).getY()){
                        tempGene=getGene(i);
                        setGene(i, getGene(j));
                        setGene(j, tempGene);
                    }else{
                        
                    }
                }else{
                    
                }
            }
        }
    }
    
    public boolean isContain(Gene gene){
        return chrom.contains(gene);
    }
}

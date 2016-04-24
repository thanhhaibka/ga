/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsn;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author hai
 */
public class WsN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try (FileReader fr=new FileReader("/home/hai/text/input2.txt")){
            Scanner sc=new Scanner(fr);
            Chromosome.num=sc.nextInt();
            Chromosome.num_r1=sc.nextInt();
            Chromosome.r1=sc.nextDouble();
            Chromosome.num_r2=sc.nextInt()+Chromosome.num_r1;
            Chromosome.r2=sc.nextDouble();
            Chromosome.num_r3=sc.nextInt()+Chromosome.num_r2;
            Chromosome.r3=sc.nextDouble();
        } catch (Exception e) {
        }
        
        Population pop= new Population(50);
        System.out.println(pop.getFit().getTotal());
        System.out.println(pop.getFit());
//        System.out.println(pop.getChrom(0).getTotal());
//        System.out.println(pop.getChrom(0));
//       for (int i = 0; i < pop.getPopSize(); i++) {
//            System.out.println(pop.getChrom(i));
//            System.out.println(pop.getChrom(i).getTotal());
//            
//           System.out.println(pop.getChrom(i).getTotal());
//////            System.out.println("fuck");
//////            System.out.println(pop.getFit().totalValue());
//        }
        for(int i=0; i<1000; i++){
            pop=GA.evol(pop);
            System.out.println(i+":"+pop.getFit());
            System.out.println(pop.getFit().getTotal());
        }
        
        try (FileWriter fw= new FileWriter("/home/hai/text/result11.txt")){
            for(int i=0; i<pop.getFit().num;i++){
                fw.write(pop.getFit().getGene(i).getX()+" "+pop.getFit().getGene(i).getY()+" "+ pop.getFit().getGene(i).getR()+"\n");
            }
        } catch (Exception e) {
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsn;

/**
 *
 * @author hai
 */
public class GA {
    
    public static Population evol(Population pop){
        Population newPop=new Population(76);
        Population newPop2=new Population(50);
        for(int i=0;i<50;i++){
            newPop.save(i, pop.getChrom(i));
        }
        for(int i=50; i<75;i++){
            Chromosome pa1=select1(pop);
            Chromosome pa2=select2(pop);
            Chromosome child= crossOver(pa1, pa2);
            newPop.save(i, child);
        }

        for(int i=0; i<newPop.getPopSize(); i++){
            mutate(newPop.getChrom(i));
        }
        newPop.quickSort(0, 74);
        for(int i=0; i<pop.getPopSize(); i++){
            newPop2.save(i, newPop.getChrom(i));
        }
        return newPop2;
    }
    
    public static Chromosome crossOver(Chromosome pa1, Chromosome pa2){
        Chromosome child=new Chromosome();
        for(int i=0;i<pa1.num;i++){
            child.setGene(i, new Gene(num_cross(pa1.getGene(i).getX(), pa2.getGene(i).getX()),num_cross(pa1.getGene(i).getY(), pa2.getGene(i).getY()), pa1.getGene(i).getR()));
        }
        return child;
    }
    
    private static double num_cross(double x, double y){
        double a=(double)(Math.abs(Math.min(x, y)-0.5*(Math.abs(x-y))));
        double b=(double)(Math.max(x, y)+0.5*(Math.abs(x-y)));
        double k=b-a;
        double t=(double)(Math.random()*k);
        double t2=a+t;
        return t2;
    }
    
    public static void mutate(Chromosome chrom){
        int p=(int)(chrom.num);
        p= (int) (Math.random()*p);
        
        double x=chrom.getGene(p).getX();
        double y=chrom.getGene(p).getY();
        double z=chrom.getGene(p).getR();
        double gX=(1/(Math.sqrt(2*3.14)*50))*Math.pow(2.718, -1/2*(x*x)/2500);
        double gY=(1/(Math.sqrt(2*3.14)*50))*Math.pow(2.718, -1/2*(y*y)/2500);
        p=(int)(Math.random()*3);
        if(p>=1){
            chrom.setGene(p, new Gene(x+gX, y+gY, z));
        }else{
            chrom.setGene(p, new Gene(x-gX, y-gY, z));
        }
    }
    
    public static Chromosome select(Population pop){
        int p=(int)(pop.getPopSize());
        p= (int) (Math.random()*p);
        Chromosome best=pop.getChrom(p);
        return best;
    }
    public static Chromosome select1(Population pop){
        int p= (int) (Math.random()*20);
        Chromosome best=pop.getChrom(p);
        return best;
    }
    
    public static Chromosome select2(Population pop){
        int p= (int) (Math.random()*30)+20;
        Chromosome best=pop.getChrom(p);
        return best;
    }
}

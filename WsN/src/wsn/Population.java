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
public class Population {
    
    Chromosome[] chroms;
    
    public Population(int size){
        chroms=new Chromosome[size];
        for(int i=0;i<size;i++){
            Chromosome newChrom=new Chromosome();
            newChrom.initChrom();
            this.save(i,newChrom);
        }
    }
    
//    public void sortPop(){
//        Chromosome chrom=new Chromosome();
//        for(int i=0;i<this.getPopSize()-1;i++){
//            for(int j=i+1;j<this.getPopSize();j++){
//                if(this.getChrom(i).getTotal()<this.getChrom(j).getTotal()){
//                    chrom=this.getChrom(i);
//                    this.save(i, this.getChrom(j));
//                    this.save(j, chrom);
//                }
//            }
//        }
//    }
    
    public void swap(int i,int j){
	Chromosome tmp=chroms[i];
	chroms[i]=chroms[j];
	chroms[j]=tmp;
    }
    
    public int part(int l,int r){
	int i=l; int j=r+1;int p=chroms[l].getTotal();
	while(i<j){
		i+=1;
		while(i<=r&&chroms[i].getTotal()>p) i+=1;
		j-=1;
		while(j>=l&&chroms[j].getTotal()<p) j-=1;
		swap(i,j);
	}
	swap(i,j);
	swap(j,l);
	return j;
    }

    public void quickSort(int l,int r){
	if(l<r){
		int p=part(l,r);
		quickSort(l,p-1);
		quickSort(p+1,r);
	}
    }   

    
    public void remove(int i){
        chroms[i]=null;
    }
    
    public void save(int i, Chromosome newChrom){
        chroms[i]=newChrom;
    }
    
    public Chromosome getChrom(int i){
        return chroms[i];
    }
    
    public int getPopSize(){
        return chroms.length;
    }
    
    public Chromosome getFit(){
        Chromosome best=chroms[0];
        int index=0;
        for(int i=1; i<getPopSize(); i++){
            if(chroms[i].getTotal() > chroms[index].getTotal()){
                index=i;
            }
        }
        best=chroms[index];
        return best;
    }
}

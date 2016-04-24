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
public class Gene {
    private double x;
    private double y;
    private double r;
    
    public Gene(){
        
    }
    
    public Gene(double x, double y, double r){
        this.x=x;
        this.y=y;
        this.r=r;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return this.r;
    }

    public void setR(double r) {
        this.r = r;
    }
    
    public boolean getOverage(int x, int y){
        if( ((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y)) <= (this.r*this.r) )
             return true;
        else return false;
    }
    
    
    
    @Override
    public String toString(){
        return getX()+" "+getY()+" "+this.r;
    }
}

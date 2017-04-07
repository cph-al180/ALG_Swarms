/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_swarms;

/**
 *
 * @author Andreas
 */
public class Particle {

    private Position position;
    private Velocity velocity;
    private double fitness;
    private Position pBest;

    private void calcFitness() {
        double x = this.position.getX();
        double y = this.position.getY();
        this.fitness = x * Math.exp(-x * x - y * y);
    }
    
    public double getFitness(){
        calcFitness();
        return fitness;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Position getpBest() {
        return pBest;
    }

    public void setpBest(Position pBest) {
        this.pBest = pBest;
    }

    @Override
    public String toString() {
        return "Particle{" + "position=" + position + ", velocity=" + velocity + ", fitness=" + fitness + ", pBest=" + pBest + '}';
    }
    
    

}

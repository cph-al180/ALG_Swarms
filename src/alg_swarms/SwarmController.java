/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_swarms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Andreas
 */
public class SwarmController {

    private Random random;
    private Particle global;
    private int swarmSize;
    private int dimensions;
    private int iterations;
    private List<Particle> swarm;

    private void initSwarm(int swarmSize, int dimensions) {
        this.random = new Random();
        this.swarmSize = swarmSize;
        this.dimensions = dimensions;
        this.swarm = new ArrayList<>();
        for (int i = 0; i < swarmSize; i++) {
            Particle p = new Particle();
            p.setPosition(new Position(random.nextDouble() * 4 - 2, random.nextDouble() * 4 - 2));
            p.setpBest(p.getPosition());
            p.setVelocity(new Velocity(-4, 4));
            swarm.add(p);
            if (p.getFitness() < global.getFitness()) {
                global.setPosition(p.getPosition());
            }
        }
    }

    private double getFitness(Position pBest) {
        return pBest.getX() * Math.exp(-pBest.getX() * pBest.getX() - pBest.getY() * pBest.getY());
    }

    private double getVelocity(double velocity, double pBest, double location, double r1, double r2) {
        return 0.1 * velocity + 0.1 * r1 * (pBest - location) + 0.1 * r2 * (global.getPosition().getX() - location);
    }

    public void Swarm(int swarmSize, int dimensions, int iterations) {
        this.iterations = iterations;
        this.global = new Particle();
        global.setPosition(new Position(1, 0));
        initSwarm(swarmSize, dimensions);
        PrintParticles();
        for (int i = 0; i < iterations; i++) {
            for (Particle p : swarm) {
                int dimensionCounter = 0;
                double r1 = random.nextDouble();
                double r2 = random.nextDouble();
                double xVelocity = 0;
                double yVelocity = 0;
                while (dimensionCounter < dimensions) {
                    if (dimensionCounter == 0) {
                        xVelocity = getVelocity(p.getVelocity().getX(), p.getpBest().getX(), p.getPosition().getX(), r1, r2);
                    } else if (dimensionCounter == 1) {
                        yVelocity = getVelocity(p.getVelocity().getX(), p.getpBest().getX(), p.getPosition().getX(), r1, r2);
                    }
                    dimensionCounter++;
                }
                p.setVelocity(new Velocity(xVelocity, yVelocity));
                p.setPosition(new Position(p.getPosition().getX() + xVelocity, p.getPosition().getY() + yVelocity));
                if (p.getFitness() < getFitness(p.getpBest())) {
                    p.setpBest(p.getPosition());
                    if(p.getFitness() < getFitness(global.getPosition())){
                        global.setPosition(p.getPosition());
                    }

                }
            }
            PrintParticles();
        }
    }

    public void PrintParticles() {
        for (Particle particle : swarm) {
            System.out.println(particle);
        }
        System.out.println("--------------------------");
    }

}

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
public class SwarmRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwarmController swarmController = new SwarmController();
        // size, dimensions, iteraions 
        swarmController.Swarm(10, 2, 25);
    }

}

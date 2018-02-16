/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler_79;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hoang
 */
public class CS2169_lab9 {

    /**
     * @param args the command line arguments
     */
    
    public static Set<String> addNumbers() {
        String file = "p079_keylog.txt";
        String line = null;
        Set<String> keylog = new HashSet<String>();
        BufferedReader bufferedReader;
        
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while(bufferedReader.ready()) {
                line = bufferedReader.readLine();
                keylog.add(line);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return keylog;
    }
    
    public static char[] connections(String number) {
        char[] array = new char[3];
        for(int i = 0; i < number.length();i++){
            array[i] = number.charAt(i);
        }
        return array;
    }
    
    public static Graph<Character,String> drawGraph(Set<String> keylog) {
        Graph<Character,String> graph = new SparseGraph<Character,String>();
        for (String attempt: keylog) {
            char[] array = connections(attempt);
            
            for(int i = 0; i < array.length; i++) {
                if(!graph.containsVertex(array[i])){
                    graph.addVertex(array[i]);
                }
            }
            for(int i = 0; i < array.length-1;i++) {
                if(!graph.containsEdge(attempt + "_" + i)) {
                    graph.addEdge(attempt + "_" + i, array[i], array[i+1], EdgeType.DIRECTED);
                }
            }
        }
        return graph;
    }
    
    public static void findSequence(Graph<Character,String> graph) {
        while(graph.getVertexCount() != 0) {
            for(char node: graph.getVertices()) {
                if(graph.inDegree(node) == 0) {
                    System.out.print(node);
                    graph.removeVertex(node);
                    break;
                }
            }
        }

    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Set<String> keylog = new HashSet<String>();
        keylog = addNumbers();
        Graph<Character,String> g = new SparseGraph<Character,String>();
        g = drawGraph(keylog);
        findSequence(g);
        System.out.println();
    }
    
}

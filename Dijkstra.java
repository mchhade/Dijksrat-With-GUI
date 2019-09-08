/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MahmoudChhade_AbbasNajem_I3341_Project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mahmoud
 * @author Abbas
 * 
 */
public class Dijkstra {
    
    static  int numberNode = 9;
    static Graph g = new Graph(numberNode);

 public static void main(String[] arg){
	    JFrame jFrame =new JFrame();
            jFrame.setLayout(new GridLayout(4,1));
            jFrame.setSize(560, 620);
            JPanel jPanel =new JPanel();
            jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JPanel jPanel2 =new JPanel();
            jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
            jPanel2.add(new JLabel("Nombre de noeud"));
            JTextField nbNoeud =new JTextField(5);
            nbNoeud.setText("9");
            jPanel2.add(nbNoeud);
            
            JButton addNoeud =new JButton("submit");
                    addNoeud.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   int numberNode = nbNoeud.getText().isEmpty() ? 1 : Integer.parseInt(nbNoeud.getText().toString());
                   if (numberNode == 1 ) nbNoeud.setText("1");
                   g = new Graph(numberNode);
                }
            });
                    
                jPanel2.add(addNoeud);    
                JButton restBut =new JButton("RESET");
                restBut.setBackground(Color.red);
                    restBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nbNoeud.setText("9");
                   numberNode = 9;
                   g = new Graph(numberNode);
                   
                g.addEdge(0, 1, 4); g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8); g.addEdge(1, 7, 11); g.addEdge(2, 1, 8);
		g.addEdge(2, 8, 2); g.addEdge(2, 5, 4); g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7); g.addEdge(3, 5, 14); g.addEdge(3, 4, 9); 
		g.addEdge(4, 3, 9); g.addEdge(4, 5, 10); 
		g.addEdge(5, 4, 10); g.addEdge(5, 3, 9); g.addEdge(5, 2, 4); g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1); g.addEdge(6, 8, 6); g.addEdge(6, 5, 2);
		g.addEdge(7, 0, 8); g.addEdge(7, 8, 7); g.addEdge(7, 1, 11); g.addEdge(7, 6, 1);
		g.addEdge(8, 2, 2); g.addEdge(8, 7, 7); g.addEdge(8, 6, 6);
                }
            }); 
                    
                    
            jPanel2.add(restBut);
            jPanel2.add(new JLabel("the reset button reset the graph to the inital values"));
            JPanel jPanel13= new JPanel();
            jPanel13.setLayout(new FlowLayout(FlowLayout.LEFT));
            jPanel13.add(new JLabel("source"));
            JTextField source1 =new  JTextField(5);
            jPanel13.add(source1);
            jPanel13.add(new JLabel("Destination"));
            JTextField destination =new  JTextField(5);
            jPanel13.add(destination);
            jPanel13.add(new JLabel("Cost"));
            JTextField cost =new  JTextField(5);
            jPanel13.add(cost);
            JButton addButtun=new JButton("ADD");
            addButtun.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    g.addEdge(Integer.parseInt(source1.getText().toString()), Integer.parseInt(destination.getText().toString()), Integer.parseInt(cost.getText().toString()));
                }
            });
            
            jPanel13.add(addButtun);
            jFrame.add(jPanel2);
            jFrame.add(jPanel13);
            jPanel.add(new JLabel("Saisir un source"));
            JTextField source_field =new JTextField(5);
            jPanel.add(source_field);
            jFrame.add(jPanel);
            JButton button =new JButton("Calcule");
            jPanel.add(button);
            JPanel jPanel1 =new JPanel();
            jPanel1.setLayout(new GridLayout(9, 1));
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
            
		
		
		
		// Ajoute les edges requis.
                g.addEdge(0, 1, 4); g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8); g.addEdge(1, 7, 11); g.addEdge(2, 1, 8);
		g.addEdge(2, 8, 2); g.addEdge(2, 5, 4); g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7); g.addEdge(3, 5, 14); g.addEdge(3, 4, 9); 
		g.addEdge(4, 3, 9); g.addEdge(4, 5, 10); 
		g.addEdge(5, 4, 10); g.addEdge(5, 3, 9); g.addEdge(5, 2, 4); g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1); g.addEdge(6, 8, 6); g.addEdge(6, 5, 2);
		g.addEdge(7, 0, 8); g.addEdge(7, 8, 7); g.addEdge(7, 1, 11); g.addEdge(7, 6, 1);
		g.addEdge(8, 2, 2); g.addEdge(8, 7, 7); g.addEdge(8, 6, 6);	
                button.addActionListener((ActionEvent e) -> {
                    jPanel1.removeAll();
                    jPanel1.repaint();
                    int source = source_field.getText().isEmpty() ? 0 : Integer.parseInt(source_field.getText().toString());
                    if (source == 0 ) source_field.setText("0");
                    Dijkstra obj = new Dijkstra();
                    // Calcule de  Dijkstra.
                    obj.calculate(g.getVertex(source));
                    
                    // affiche  le distance minimal.
                    g.getVertices().stream().map((v) -> {
                        String s = "";
                        s=s+"Vertex - "+v+" , Dist - "+ v.minDistance+" , Path - ";
                        for(Vertex pathvert:v.path) {
                            s=s+pathvert+" ";
                        }
                        s=s+""+v;
                        return s;
                    }).map((s) -> {
                        jPanel1.add(new JLabel(s));
                        return s;
                    }).forEachOrdered((_item) -> {
                        jFrame.add(jPanel1);
                    }); //To change body of generated methods, choose Tools | Templates.
                    
                    jPanel1.revalidate();
            });
	}

	public void calculate(Vertex source){
		// Algo:
		// 1. Prend les node de plus petit cost .
		// 2. Visit touts ses voisin.
		// 3. reactualisation les  distances pour touts les voisin  (In the Priority Queue).
		// repete ce processusjusqu'a touts les node sont visite.
		source.minDistance = 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			
			Vertex u = queue.poll();
		
			for(Edge neighbour:u.neighbours){
				Double newDist = u.minDistance+neighbour.weight;
				
				if(neighbour.target.minDistance>newDist){
					// Supprime le noeud de la file d'attente pour mettre à jour la valeur de distance.
                                        
					queue.remove(neighbour.target);
					neighbour.target.minDistance = newDist;
					
					// Prend le chemin visité jusqu'à maintenant et ajoute le nouveau noeud.
					neighbour.target.path = new LinkedList<Vertex>(u.path);
					neighbour.target.path.add(u);
					
					// Réentrez le noeud avec la nouvelle distance.
					queue.add(neighbour.target);
                                        
				}
                                
			}
                       
		}
		
		}
	}


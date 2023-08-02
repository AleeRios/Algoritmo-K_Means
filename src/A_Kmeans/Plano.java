//Beckham Alejandro Rios Campusano
//Bladimir Axley Graduño Sanchez

package A_Kmeans;

import java.awt.event.*;
import javax.swing.*;
import org.math.plot.*;
import java.awt.*;
import java.util.*;

public class Plano {
    private JFrame frame; 
    private int numM, numC;
    private JTextField txtM, txtCl;
    private JButton btnG, btnS, btnO;
    private Plot2DPanel plot = new Plot2DPanel();
    private double[][] cent, aux;
    private ArrayList<Color> colors = new ArrayList<>();
    private ArrayList<Color> colores = new ArrayList<>();
    
    public Plano(){
        initComponents();
    }
    
    private void initComponents(){
        txtM = new JTextField(10);
        txtCl = new JTextField(10);
        btnG = new JButton("Graficar");
        btnS = new JButton("Limpiar");
        btnO = new JButton("Ordenar");
       
        //idetificarColor(xyC);
        //plot.addScatterPlot("",Color.gray, puntos);
        
        btnG.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                btnGActionPerformed(ev);
            }
        });
        
        btnS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                btnSActionPermormed(ev);
            }
        });
        
        btnO.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                btnOActionPermormed(ev);
            }
        });
        
        frame = new JFrame("Algoritmo KNN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(panelPrincipal());
        frame.setVisible(true);
    }
    
    private void btnSActionPermormed(ActionEvent ev){
        //new Principal();
        //frame.dispose();
        plot.removeAllPlots();
        colors.clear();
        //txtM.setText("");
        //txtCl.setText("");
    }
    
    private void btnGActionPerformed(ActionEvent ev){
        numM = Integer.parseInt(txtM.getText());
        numC = Integer.parseInt(txtCl.getText());
        
        A_KMeans km = new A_KMeans(numM, numC);
        aux = km.generarMuestras();
        plot.addScatterPlot("",Color.gray, aux);
        //System.out.println(Arrays.deepToString(aux));
        
        cent = km.generarCentroides();
        //System.out.println(Arrays.deepToString(cent));
        
        crearColorCentroide();
        pintarCentroides();
        colores = km.distancias(colors);
    }
    
    private void btnOActionPermormed(ActionEvent ev){
        //pintarCentroides();
        pintarClases();
        
    }
    
    private void reacomodarCentroides(){
        
    }
    
    private void pintarClases(){
        plot.removeAllPlots();
        pintarCentroides();
        for(int i=0; i<colores.size(); i++){
            double [] x = {aux[i][0]};
            double [] y = {aux[i][1]};
            //System.out.print(colores.get(i));
            plot.addScatterPlot("", colores.get(i), x, y);
        }
    }
    
    private void crearColorCentroide(){
        for(int i=0; i<cent.length; i++){
            int r = (int)(Math.random() * 255);
            int g = (int)(Math.random() * 255);
            int b = (int)(Math.random() * 255);
            colors.add(new Color(r, g, b));
        }
    }
    
    private void pintarCentroides(){
        for(int i=0; i<colors.size(); i++){
            //System.out.println(Arrays.toString(cent[i]));
            double [] x = {cent[i][0]};
            double [] y = {cent[i][1]};
            plot.addScatterPlot("", colors.get(i), x, y);
        }
    }
    
    private JPanel panelPrincipal(){
        JPanel pPri = new JPanel();
        BorderLayout bl = new BorderLayout();
        pPri.setLayout(bl);
        pPri.add(plot, bl.CENTER);
        pPri.add(panelSur(), bl.SOUTH);
        return pPri;
    }
    
    private JPanel panelSur(){
        JPanel pS = new JPanel();
        pS.add(btnS);
        pS.add(new JLabel("Muestras: "));
        pS.add(txtM);
        pS.add(new JLabel("Clusters: "));
        pS.add(txtCl);
        pS.add(btnG);
        pS.add(btnO);
        return pS;
    }
    
    public static void main(String[] agvs){
        new Plano();
    }
       
}
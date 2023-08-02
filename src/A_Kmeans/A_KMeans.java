//Beckham Alejandro Rios Campusano
//Bladimir Axley Graduño Sanchez

package A_Kmeans;

import java.util.*;
import java.awt.Color;
        
public class A_KMeans {
    private double[][] muestras, centroides;
    private double[] distancias;
    private int numM, numC;
    private ArrayList<Integer> d = new ArrayList<>();
    
    public A_KMeans(int numM, int numC){
        this.numM = numM;
        this.numC = numC;
    }
    
    public double[][] getMuestras(){
        return this.muestras;
    }
    
    public double[][] generarMuestras(){
        muestras = new double[numM][2];
        for(int i=0; i<muestras.length; i++){
           double x = Math.random() * 100;
           double y = Math.random() * 100;
           muestras[i][0] = x;
           muestras[i][1] = y;
        }
        return this.muestras;
    }
    
    public double[][] generarCentroides(){
        centroides = new double[numC][2];
        for(int i=0; i<centroides.length; i++){
           double x = Math.random() * 100;
           double y = Math.random() * 100;
           centroides[i][0] = x;
           centroides[i][1] = y;
        }
        return this.centroides;
    }
    
    public double distancia(double xi, double xj, double yi, double yj){
        return Math.sqrt(Math.pow(xj-xi, 2) + Math.pow(yj-yi,2));
    }
    
    public ArrayList<Color> distancias(ArrayList<Color> colors){
        ArrayList<Double> cent = new ArrayList<>();
        ArrayList<Double> aux = new ArrayList<>();
        ArrayList<Color> colores = new ArrayList<>();
        //System.out.println(colors);
        Color c;
        for(int i=0; i<muestras.length; i++){
            double xi = muestras[i][0];
            double yi = muestras[i][1];
            for(int j=0; j<centroides.length; j++){
                double xj = centroides[j][0];
                double yj = centroides[j][1];
                double dis = distancia(xi, xj, yi, yj);
                cent.add(dis);
                aux.add(dis);
            }
            Collections.sort(cent);
            c = colors.get(aux.indexOf(cent.get(0)));
            colores.add(c);
            cent.clear();
            aux.clear();
            
        }
        //System.out.println(cent);
        return colores;
    }
  
}

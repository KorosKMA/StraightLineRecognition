package line_recognition;

import java.io.*;
import java.util.*;

import princeton.lib.StdDraw;

public class Fast {

	private static final String in = "rs1423.txt";
	private static final String out = "out.txt";
	
	public static void main(String[] args) throws IOException{
		Scanner in = null;
		PrintWriter out;
		in = new Scanner(new BufferedReader(new FileReader(Fast.in)));
		out = new PrintWriter(Fast.out);
		int numOfPoints = in.nextInt();
		Point[] points = new Point[numOfPoints];
		for(int i=0;i<numOfPoints;i++)
			points[i]=new Point(in.nextInt(), in.nextInt());
		in.close();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		
		Point[] sorted = points.clone();
		int counter;
		String outPrint;
		for(int p=0;p<numOfPoints;p++){
			counter=0;
			outPrint="";
			points[p].draw();
			Arrays.sort(sorted, points[p].SLOPE_ORDER);
			for(int i=1;i<numOfPoints;i++){
				if(sorted[i].slopeTo(sorted[0])==sorted[i-1].slopeTo(sorted[0])){
					counter++;
					outPrint+=sorted[i-1]+" -> ";
				}
				else{
					if(counter>1){
						sorted[i-counter].drawTo(sorted[0]);	
						out.println(outPrint+"();");
						outPrint="";
					}
					counter=0;
				}
			}
			if(counter>1){
				sorted[numOfPoints-counter].drawTo(sorted[0]);	
				out.println(outPrint+"();");
			}
				
		}
		out.close();
	}

}

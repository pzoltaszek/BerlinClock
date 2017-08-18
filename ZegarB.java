/*  Berlin clock
 * The principle of operation:
 * https://en.wikipedia.org/wiki/Mengenlehreuhr
 */

import java.awt.*;
import java.applet.*;
import java.util.Calendar;
import java.awt.event.*;


public class ZegarB extends Applet implements Runnable {
	Calendar calendar;
	Thread t = null;
	boolean flaga = false;
	String zeg;
	int h, m, s ;
	//**************** MOUSE - co-ordinates *********************
	public void init(){
		addMouseMotionListener(new MouseMotionAdapter(){ 
			public void mouseMoved(MouseEvent me){
				showStatus (me.getX() + " , " + me.getY() + "   Autor: P.Zoltaszek :)");
				repaint();
			}
		}); 
	}
	// ************* START **********************
	public void start() {
		
		t = new Thread (this);
		t.start();	
	}
	//*************** RUN *********************
	public void run(){
		for ( ; ; ){   // nieskonczona petla
			if (flaga)
				break;
			
			calendar = Calendar.getInstance();
			h = calendar.get(Calendar.HOUR_OF_DAY);
			m = calendar.get(Calendar.MINUTE);
			s = calendar.get(Calendar.SECOND);
			zeg = Integer.toString(h) +":"+Integer.toString(m)+":"+Integer.toString(s);
			try { Thread.sleep(1000);	
			} catch (InterruptedException e){}
			repaint();
		} // for petla
	} //run
	//************** STOP ***********************
	public void stop(){
		flaga = true;
		t = null;
	}
	// ******************* PAINT **********************
	public void paint (Graphics g){
		g.drawString(zeg, 10, 20);
		
		// ***********  seconds - circle *************
		if(s%2 == 0){
			g.setColor(Color.ORANGE);
			g.fillOval(30,30,30,30);
		}
		else {
			g.setColor(Color.RED);
			g.fillOval(30, 30, 30,30);
		}
		g.setColor(Color.BLACK);
		g.drawString("SEKUNDY", 140, 40);
		
		// *************hours - first line *******************
		// 1 prostokšt
		g.setColor(Color.BLACK);
		g.drawRoundRect(10,65,15,30,2,2);
		if (h>=5){
			g.setColor(Color.RED);
			g.fillRoundRect(10, 65, 15, 30, 2, 2);
		}
		//2
		g.setColor(Color.BLACK);
		g.drawRoundRect(30,65,15,30,2,2);
		if (h>=10){
			g.setColor(Color.RED);
			g.fillRoundRect(30, 65, 15, 30, 2, 2);
		}
		//3
		g.setColor(Color.BLACK);
		g.drawRoundRect(50, 65, 15, 30, 2, 2);
		if(h>=15){
			g.setColor(Color.RED);
			g.fillRoundRect(50, 65, 15, 30, 2, 2);
		}
		//4
		g.setColor(Color.BLACK);
		g.drawRoundRect(70, 65, 15, 30, 2, 2);
		if(h>=20){
			g.setColor(Color.RED);
			g.fillRoundRect(70, 65, 15, 30, 2, 2);
		}
		
		// ************ hours - second linie ****************
		//1
		g.setColor(Color.BLACK);
		g.drawRoundRect(10,100,15,30,2,2);
		for (int i=1; i<25; i+=5){
			if (h==i){
				g.setColor(Color.RED);
				g.fillRoundRect(10, 100, 15, 30, 2, 2);
			}
		}
		//2
		g.setColor(Color.BLACK);
		g.drawRoundRect(30,100,15,30,2,2);
		for (int i=2; i<25; i+=5){
			if(h==i){
			g.setColor(Color.RED);
			g.fillRoundRect(10, 100, 15, 30, 2, 2);
			g.fillRoundRect(30, 100, 15, 30, 2, 2);
			}
		}
		//3
		g.setColor(Color.BLACK);
		g.drawRoundRect(50,100,15,30,2,2);
		for (int i =3; i<25; i+=5){
			if(h==i){
			g.setColor(Color.RED);
			g.fillRoundRect(10, 100, 15, 30, 2, 2);
			g.fillRoundRect(30, 100, 15, 30, 2, 2);
			g.fillRoundRect(50, 100, 15, 30, 2, 2);
			}
		}
		//4
		g.setColor(Color.BLACK);
		g.drawRoundRect(70,100,15,30,2,2);
		for (int i=4; i<24; i+=5){
			if (h==i){
				g.setColor(Color.RED);
				g.fillRoundRect(10, 100, 15, 30, 2, 2);
				g.fillRoundRect(30, 100, 15, 30, 2, 2);
				g.fillRoundRect(50, 100, 15, 30, 2, 2);
				g.fillRoundRect(70, 100, 15, 30, 2, 2);
			}
		}
		g.setColor(Color.BLACK);
		g.drawString("GODZINY", 140, 90);
		// ********** minutes **************
		g.setColor(Color.BLACK);
		g.drawRoundRect(10, 140, 10, 20, 2, 2); //1
		g.drawRoundRect(22, 140, 10, 20, 2, 2); //2
		g.drawRoundRect(34, 140, 10, 20, 2, 2); //3 
		g.drawRoundRect(46, 140, 10, 20, 2, 2); //4
		g.drawRoundRect(58, 140, 10, 20, 2, 2); //5
		g.drawRoundRect(70, 140, 10, 20, 2, 2); //6
		g.drawRoundRect(82, 140, 10, 20, 2, 2); //7
		g.drawRoundRect(94, 140, 10, 20, 2, 2); //8
		g.drawRoundRect(106, 140, 10, 20, 2, 2); //9
		g.drawRoundRect(118, 140, 10, 20, 2, 2); //10
		g.drawRoundRect(130, 140, 10, 20, 2, 2); //11
		//1
			if (m >=5){
				g.setColor(Color.ORANGE);
				g.fillRoundRect(10, 140, 10, 20, 2, 2);
			}
		//2
				if (m >=10){
						g.setColor(Color.ORANGE);
						g.fillRoundRect(10, 140, 10, 20, 2, 2);
						g.fillRoundRect(22, 140, 10, 20, 2, 2);
					}
		//3 RED
				if (m>=15){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
				}
		//4
				if (m>=20){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
				}
		//5
				if (m>=25){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
					g.fillRoundRect(58, 140, 10, 20, 2, 2);
				}
		//6 RED
				if (m>=30){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
					g.fillRoundRect(58, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(70, 140, 10, 20, 2, 2);
				}
		//7
				if (m>=35){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
					g.fillRoundRect(58, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(70, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(82, 140, 10, 20, 2, 2);
				}
		//8
				if (m>=40){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
					g.fillRoundRect(58, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(70, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(82, 140, 10, 20, 2, 2);
					g.fillRoundRect(94, 140, 10, 20, 2, 2);
						}
		//9
				if (m>=45){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
					g.fillRoundRect(58, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(70, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(82, 140, 10, 20, 2, 2);
					g.fillRoundRect(94, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(106, 140, 10, 20, 2, 2);
						}
		//10
				if (m>=50){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
					g.fillRoundRect(58, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(70, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(82, 140, 10, 20, 2, 2);
					g.fillRoundRect(94, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(106, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);;
					g.fillRoundRect(118, 140, 10, 20, 2, 2);
						}
		//11		
				if (m>=55){
					g.setColor(Color.ORANGE);
					g.fillRoundRect(10, 140, 10, 20, 2, 2);
					g.fillRoundRect(22, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(34, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(46, 140, 10, 20, 2, 2);
					g.fillRoundRect(58, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(70, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(82, 140, 10, 20, 2, 2);
					g.fillRoundRect(94, 140, 10, 20, 2, 2);
					g.setColor(Color.RED);
					g.fillRoundRect(106, 140, 10, 20, 2, 2);
					g.setColor(Color.ORANGE);
					g.fillRoundRect(118, 140, 10, 20, 2, 2);
					g.fillRoundRect(130, 140, 10, 20, 2, 2);
						}
				g.setColor(Color.BLACK);
				g.drawString("MINUTY", 145, 150);
		// *************  MINUTES - second linie**********************
				//1
				g.setColor(Color.BLACK);
				g.drawRoundRect(10,170,18,40,2,2);
				for (int i=1; i<60; i+=5){
					if (m==i){
						g.setColor(Color.YELLOW);
						g.fillRoundRect(10,170,18,40,2,2);
					}
				}
				//2
				g.setColor(Color.BLACK);
				g.drawRoundRect(30,170,18,40,2,2);
				for (int i=2; i<60; i+=5){
					if (m==i){
						g.setColor(Color.YELLOW);
						g.fillRoundRect(10,170,18,40,2,2);
						g.fillRoundRect(30,170,18,40,2,2);
					}
				}
				//3
				g.setColor(Color.BLACK);
				g.drawRoundRect(50,170,18,40,2,2);
				for (int i=3; i<60; i+=5){
					if (m==i){
						g.setColor(Color.YELLOW);
						g.fillRoundRect(10,170,18,40,2,2);
						g.fillRoundRect(30,170,18,40,2,2);
						g.fillRoundRect(50,170,18,40,2,2);
					}
				}
				//4
				g.setColor(Color.BLACK);
				g.drawRoundRect(70,170,18,40,2,2);
				for (int i=4; i<60; i+=5){
					if (m==i){
						g.setColor(Color.YELLOW);
						g.fillRoundRect(10,170,18,40,2,2);
						g.fillRoundRect(30,170,18,40,2,2);
						g.fillRoundRect(50,170,18,40,2,2);
						g.fillRoundRect(70,170,18,40,2,2);
					}
				}
				g.setColor(Color.BLACK);
				g.drawString("MINUTY", 140, 190);
	} // paint method
	
} // zegar calss

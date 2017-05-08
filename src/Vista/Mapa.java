package Vista;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Modelo.DatosMapa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Mapa extends JPanel {
	
	private DatosMapa datos;
	private boolean datosIngresados;
	private URL urlA=getClass().getResource("/Imagenes/A.png");
	private URL urlB=getClass().getResource("/Imagenes/B.png");
	private URL urlC=getClass().getResource("/Imagenes/C.png");
	private URL urlD=getClass().getResource("/Imagenes/D.png");
	private URL urlE=getClass().getResource("/Imagenes/E.png");
	private URL urlF=getClass().getResource("/Imagenes/F.png");
	private URL urlG=getClass().getResource("/Imagenes/G.png");
	private URL urlH=getClass().getResource("/Imagenes/H.png");
	private URL urlI=getClass().getResource("/Imagenes/I.png");
	private BufferedImage imagenA,imagenB,imagenC,imagenD,imagenE,imagenF,imagenG,imagenH,imagenI;
	/**
	 * Create the panel.
	 */
	public Mapa() {
		setLayout(null);
		this.datosIngresados = false;
		this.datos = null;
		crearImagenes();
	}
	public void crearImagenes(){
		try {
			imagenA = ImageIO.read(urlA);
			imagenB = ImageIO.read(urlB);
			imagenC = ImageIO.read(urlC);
			imagenD = ImageIO.read(urlD);
			imagenE = ImageIO.read(urlE);
			imagenF = ImageIO.read(urlF);
			imagenG = ImageIO.read(urlG);
			imagenH = ImageIO.read(urlH);
			imagenI = ImageIO.read(urlI);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setDatos(DatosMapa datos) {
		this.datos = datos;
		this.datosIngresados = true;
	}
	@Override
	protected void paintComponent(Graphics g) {
		if(datosIngresados){
			super.paintComponent(g);
			g.setColor(getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
			int tableroTemp[][]=datos.getTablero();
	        int px = 40;
	        for(int i=0; i<tableroTemp.length;i++){
	            for(int j=0; j<tableroTemp[i].length;j++){
	                int valor = tableroTemp[i][j];
	                if(valor==9){
	                    g.setColor(Color.DARK_GRAY);
	                    g.fillRect(j*px, i*px, px, px);
	                }
	                if(valor==10){
	                    g.setColor(Color.WHITE);
	                    g.fillRect(j*px, i*px, px, px);
	                }
	                if(valor==11){
	                    g.setColor(Color.ORANGE);
	                    g.fillRect(j*px, i*px, px, px);
	                }
	                if(valor==0){
	                	g.drawImage(imagenA,j*40,i*40,40,40, this);
	                }
	                if(valor==1){
	                	g.drawImage(imagenB,j*40,i*40,40,40, this);
	                }
	                if(valor==2){
	                	g.drawImage(imagenC,j*40,i*40,40,40, this);
	                }
	                if(valor==3){
	                	g.drawImage(imagenD,j*40,i*40,40,40, this);
	                }
	                if(valor==4){
	                	g.drawImage(imagenE,j*40,i*40,40,40, this);
	                }
	                if(valor==5){
	                	g.drawImage(imagenF,j*40,i*40,40,40, this);
	                }
	                if(valor==6){
	                	g.drawImage(imagenG,j*40,i*40,40,40, this);
	                }
	                if(valor==7){
	                	g.drawImage(imagenH,j*40,i*40,40,40, this);
	                }
	                if(valor==8){
	                	g.drawImage(imagenI,j*40,i*40,40,40, this);
	                }
	                g.setColor(Color.BLACK);
	                g.drawRect(j*px, i*px, px, px);
	            }
	        }
		}
	}
}

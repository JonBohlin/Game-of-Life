import java.util.Random;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.awt.Dimension;

public class GameOfLifeEngine extends JPanel{
	private int[][] MatrixOfLife;
	private int[][] NeighborMatrix;
	private int isAlive = 0;
	private int gridWidth, gridHeight;
	private int screenWidth, screenHeight;
	private final int pointWidth = 4;
	
	public GameOfLifeEngine(int x, int y){
		gridWidth = x;
		gridHeight = y;
		screenWidth = x*pointWidth;
		screenHeight = x*pointWidth;
		MatrixOfLife = new int[gridWidth][gridHeight];
		NeighborMatrix = new int[gridWidth][gridHeight];

		startEstimation( 25 );
	}

	public void startEstimation( int randomProportion ){
		setSize( screenWidth, screenHeight );
		setPreferredSize( new Dimension (screenHeight, screenHeight));
		Random rand = new Random();
		for(int i = 1; i < gridHeight - 1; i++){
			for(int j = 1; j < gridWidth - 1; j++){
				int randomNumberDraw = rand.nextInt(100);
				if( randomNumberDraw < randomProportion ){
					MatrixOfLife[j][i] = 1;
					isAlive++;
				}

			}
		}
		updateMatrix();
	}

	private void updateMatrix(){

		for(int i = 1; i < gridHeight - 1; i++)
				for(int j = 1; j < gridWidth - 1; j++)
					NeighborMatrix[j][i] = scanForNeighborsAlive(j,i);
		
		for(int i = 1; i < gridHeight - 1; i++){
			for(int j = 1; j < gridWidth - 1; j++){
				if(MatrixOfLife[j][i] == 1){
					if(NeighborMatrix[j][i] >= 2 && NeighborMatrix[j][i] <= 3){
						MatrixOfLife[j][i]=1;
						isAlive--;
					}
					else{
						MatrixOfLife[j][i]=0;
						isAlive--;
					}
				}
				else if(MatrixOfLife[j][i] == 0)
						if( NeighborMatrix[j][i] == 3 ){
							MatrixOfLife[j][i] = 1;
							isAlive++;
						}
			}
		}
		repaint();
	}

	private int scanForNeighborsAlive(int x, int y){
		int numAliveCells = 0;
		if( MatrixOfLife[x][y] ==1 ){
			numAliveCells--;
		}
		
		for(int i = y-1; i <= y+1; i++)
			for(int j = x-1; j <= x+1; j++)
				numAliveCells+=MatrixOfLife[j][i];

		return numAliveCells;
	}

	private void createGrid(int x, int y, int x_width, int y_height, Graphics2D g2d){

		final int screenWidth = x*x_width;
		final int screenHeight = y*y_height;
		g2d.setColor( Color.BLACK );
		g2d.drawRect( 0,0, screenWidth, screenHeight );
		for(int i = 0; i < screenWidth; i+=x_width )
			g2d.drawLine(i, 0, i, screenHeight);
		for(int j = 0; j < screenHeight; j+=y_height )
			g2d.drawLine(0, j, screenWidth, j);

	}

	private void drawPoint(int x, int y, int x_width, int y_height, Graphics2D g2d){
		final int x_t = x_width*x;
		final int y_t = y_height*y;
		g2d.fillRect(x_t, y_t, x_width, y_height);
	}

	public void paintComponent( Graphics g ){
		super.paintComponent( g );
		Graphics2D g2d = (Graphics2D) g;
		createGrid( gridWidth, gridHeight, pointWidth, pointWidth, g2d);
		for(int y = 0; y < gridHeight; y++){
			for(int x = 0; x < gridWidth; x++){
				if(MatrixOfLife[x][y]==1){
					g2d.setColor( Color.RED );
					drawPoint(x, y, pointWidth, pointWidth, g2d);
				}
			}
		}
		try{TimeUnit.MILLISECONDS.sleep( 100 );
		} catch (InterruptedException ie){
			System.out.println("Timer interrupted");
		}

		updateMatrix();
//		System.out.println(isAlive);
	}
}


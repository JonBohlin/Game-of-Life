import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GameOfLife extends JFrame{
	private GameOfLifeEngine gof;
	private int proprortionAlive=5;
	
	public GameOfLife(){
		super("John Conway's Game of Life");
		JPanel controlPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JButton restartBUtton = new JButton("Restart");
		JLabel aliveLabel = new JLabel("% alive:");
		JSlider aliveSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 100, 5 );
		aliveSlider.setMajorTickSpacing( 5 );
		aliveSlider.setPaintTicks( true );
		gof = new GameOfLifeEngine(200, 200);

		controlPanel.setLayout( new FlowLayout() );
		controlPanel.add( restartBUtton );

		restartBUtton.addActionListener(
			new ActionListener(){
				public void actionPerformed( ActionEvent e ){
					gof.startEstimation( proprortionAlive );
				}
			}
		);

		aliveSlider.addChangeListener(
			new ChangeListener(){
				public void stateChanged( ChangeEvent e ){
					proprortionAlive = aliveSlider.getValue();
				}
			}
		);

		controlPanel.add( aliveLabel );
		controlPanel.add( aliveSlider );
						
		mainPanel.add( controlPanel );
		mainPanel.add( gof );
		add( mainPanel );
		setSize( 820, 880 );
		setVisible( true );
	}
}

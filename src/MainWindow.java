/*
*    This is part of JustStopwatch module.
*    Copyright (C) 2018  Tomasz Otoka
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton startStop;
	Label timeLabel;
	State state;

	TimerTask tick;
	Timer timer;


	public MainWindow() {

		/*
		 * Main frame
		 */
		frame = new JFrame( "JustStopwatch!" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		/*
		 * General JPanel
		 */
		panel = new JPanel(new BorderLayout());
		frame.add(panel);

		/*
		 * timeLabel
		 */
		timeLabel = new Label("00:00:00.0");
		panel.add( timeLabel, BorderLayout.NORTH );

		/*
		 * startStop button
		 */
		startStop = new JButton( "Start" );
		startStop.setVerticalTextPosition( AbstractButton.CENTER );
		startStop.setHorizontalTextPosition( AbstractButton.CENTER );
		startStop.setMnemonic( KeyEvent.VK_SPACE );
		startStop.setActionCommand( "toggleState" );
		startStop.addActionListener( this );
		panel.add( startStop, BorderLayout.SOUTH );

		frame.setVisible( true );

		timeLabel.setFont(timeLabel.getFont().deriveFont((float)100));
		startStop.setFont(startStop.getFont().deriveFont((float)25));

		frame.pack();

	}

	public void actionPerformed(ActionEvent e) {

		if( "toggleState".equals(e.getActionCommand())) {

			JustStopwatch.state.toggle();
			startStop.setText( JustStopwatch.state.action() );

			switch( JustStopwatch.state.get() ) {

				case State.RUNNING:
					tick = new Tick( this );
					timer = new Timer( true );
					timer.scheduleAtFixedRate( tick, 0, 100 );
					break;

				case State.STOPPED:
					timer.cancel();
					break;

				case State.INITIAL:
					print( "00:00:00.0" );
					break;
			}
		}
	}

	public void print( String text ) {
		timeLabel.setText( text );
		//System.out.print( "\nPrinting:" + text );
	}
}

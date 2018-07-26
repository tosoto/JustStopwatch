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

import java.util.TimerTask;

public class Tick extends TimerTask {

	MainWindow mainWin;
	long startTime;
	String displayString;

	public Tick( MainWindow mainWin ) {

		this.mainWin = mainWin;
		start();

	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void run() {

		if( JustStopwatch.state.get() == State.RUNNING ) {
			long passedTime = System.currentTimeMillis() - startTime;

			int tenthSeconds = (int)(( passedTime / 100 ) % 10 );
			int seconds = (int)(( passedTime / 1000 ) % 60 );
			int minutes = (int)( ( ( passedTime / 1000 ) / 60 ) % 60 );
			int hours = (int)( ( ( ( passedTime / 1000 ) / 60 ) / 60 ) % 24 );

			displayString = String.format( "%02d", hours );
			displayString += ":";
			displayString += String.format( "%02d", minutes );
			displayString += ":";
			displayString += String.format( "%02d", seconds );
			displayString += ".";
			displayString += Integer.toString( tenthSeconds );

			mainWin.print( displayString );
		}
	}
}

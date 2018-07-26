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

public class State {

	private char state;

	static final char INITIAL = 0;
	static final char RUNNING = 1;
	static final char STOPPED = 2;

	State() {
		state = INITIAL;
	}

	public void toggle() {
		state += 1;
		state %= 3;
	}

	public char get() {
		return state;
	}

	public void set(char state) {
		this.state = state;
	}

	public String toString() {
		switch(state) {
			case INITIAL:
				return "INITIAL";
			case RUNNING:
				return "RUNNING";
			case STOPPED:
				return "STOPPED";
		}
		return "unknown type";
	}

	public String action() {
		switch(state) {
		case INITIAL:
			return "Start";
		case RUNNING:
			return "Stop";
		case STOPPED:
			return "Clear";
		}
		return "unknown type";
	}
}

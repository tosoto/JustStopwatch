#    This is part of JustStopwatch module.
#    Copyright (C) 2018  Tomasz Otoka
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.

all: class jar cleanclass

class:
	@echo -n "Compile class... "
	@javac src/*.java
	@mkdir -p bin
	@mv src/*.class bin
	@echo "done"

jar:
	@echo -n "Create jar... "
	@mkdir -p bin
	@cd bin; jar cfe JustStopwatch.jar JustStopwatch *.class
	@cd bin; md5sum JustStopwatch.jar > JustStopwatch.jar.md5
	@echo "done"

run:
	@echo -n "Running... "
	@java -jar bin/JustStopwatch.jar
	@echo "done"

clean: cleanjar cleanclass

cleanclass:
	@echo -n "Removing class files... "
	@rm -f bin/*.class
	@rm -f src/*.class
	@echo "done"

cleanjar:
	@echo -n "Removing jar files... "
	@rm -f bin/*.jar
	@rm -f src/*.jar
	@rm -f bin/*.jar.md5
	@echo "done"

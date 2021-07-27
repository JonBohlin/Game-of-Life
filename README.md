# Game-of-Life

![image](https://user-images.githubusercontent.com/20295285/127205518-efee7ce2-2980-4554-aecb-a31b41cb37b0.png)

A simple version of John Conway's Game of Life implemented in Java. Game of Life is an example of cellular automata with the following simple rules: an alive cell stays alive if 2 or 3 surrounding cells are alive otherwise it dies. A dead cell becomes alive if exactly three neighbors are alive otherwise it remains dead.

The program can be compiled with:

javac GameOfLife.java GameOfLifeEngine.java GoF.java

and

java GoF

starts it.

Move the bar on top to change the (random) number of live and dead cells. Press the Restart button for a (re-)run. It should work on Windows, Linux and macos and most Java versions.

It has been proved that John Conway's Game of Life is Turing complete and can therefore, in theory, be programmed to anything a standard computer can. Since Darwin's theory of evolution is not concerned with the origin of life (but with the origin of species, a very different matter) the Game of Life may indicate that life as we know it could have originated from very simple rules. That these rules are Turing complete allows for infinite possibilities. Furthermore, John von Neumann has proved that, given a set of presumptions, an ancestor need not be more complicated than the offspring. As DNA and RNA molecules are very complex (containing sugars) life in the sense of self-replicating molecules can have been well under way before they were introduced. Indeed, the introduction of RNA and DNA molecules may have turned replicating molecules into universal Turing machines capable of producing their own software (i.e the ribosome).

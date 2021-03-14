# Mars Rover Case Study

Solve the problem below as a group using TDD.

The problem is taken from [codingdojo.org](http://codingdojo.org/kata/Bowling/).

## Problem Specification

ACME Space Team Ltd are planning a privately funded mission to Mars.
Build a simulation to help them design their first rover controller!

The project will evolve in _phases_ as Mission Command
unveils new requirements. Try not to look ahead to the next phase
until you've finished with the current one.

Use TDD throughout:

- Change roles after each TDD cycle.

- No "red phases" while refactoring.
  The code should always compile, and tests should always be green!

- Be careful about edge cases and exceptions.

### Phase 1 - Brave New World

Initial scans of Mars have revealed the nature of the terrain there.
Let's start by modelling the terrain and the location of the rover:

- Contrary to popular belief,
  the Martian surface is actually a grid of squares.

- Most of the terrain is sandy; about 10% is made up of rocks.

- The rover occupies exactly one square of terrain.
  It is always faces in one of the four cardinal directions:
  North, South, East, or West.

- We should have a way of visualising the simulation.
  Let's print it to the console!
  Use '.' for sand, '_O_' for a rock, and one of '^>V<' for the rover.

### Phase 2 - First Steps

The boffins in Engineering have come up with a remote telemetry system.
We'll send the rover individual commands, each time waiting for a response.

A command is a single character:

- `F` to move forward;
- `B` to move backward;
- `L` to turn left;
- `R` to turn right.

Implement a method to simulate
sending the command (by typing it on the console)
and receiving a response (by printing it out).
Note that some commands can fail:

- `L` and `R` always succeed;
- `F` and `B` will fail if the rover tries to move
  into a square containing a rock;
- `F` and `B` will fail if the rover tries to move
  off the edge of the world (which we know is flat).

The rover should respond with `Ok` if a command was successful,
or `Fail` and an error message if it failed for any reason.

### Phase 3 - Rolling Out

Apparently it takes an average of 12.5 minutes for a command to reach Mars.
This is clearly too slow for our rover pilots (who are notorious adrenaline junkies). To speed things up, we'll _batch_ commands into short programs and send them in one go.

A program is a string made up of `FBLR` commands.

We'll send a whole program in one go.
The rover should respond by telling us whether the program was successful.
If the program failed, the rover should tell us
which command failed and why.

### Phase 4 - Samples Rock!

Rocks are really interesting. We _must_ take samples...
and by taking samples we mean smashing them to bits!

Implement a new command, `S`, to take a sample:

- the command succeeds if there is a rock
  in the square in front of the rover;

- the rover destroys the rock in the process;

- we should record the number of successful samples we've taken.

### Phase 5 - Look Before You Leap

It turns out that bashing into rocks is expensive.
Sampling thin air is also not ideal.
Let's add a camera to the rover so we can see what we're doing.

Implement a command `P` to take a picture.
The command should respond with
the terrain in the square immediately in front of the rover.

### Phase 6 - SLAM!

Our rover pilots are demanding a pay rise so
we're going to have to make them redundant.

Let's implement a new "high level command system"
to replace our current programming system.

The new system should have a single "move" command,
that instructs the rover to move to an (x, y) location.
The rover should turn and move as necessary.
If it enounters any rocks, sample those suckers!

Implement the command in terms of the existing `FBLRS` commands:

- if the rover isn't facing in the irght direction
  turn towards the goal;

- if the rover _is_ facing in the right direction,
  take a picture and either move or sample as appropriate;

- the command should keep going until the rover
  reaches its destination.

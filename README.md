# laserSolver
## description
Give a solution to solve amazing problem as follow:

* Give a `n x n` matrix, coordinates of mirrors in the matrix. Two types of mirror are defined that 1 like `\`, 2 like `/`.
This value stands for the direction of the mirror.
* Laser beam shines in one direction, when the laser goes out of the matrix, we should count the number of mirrors which 
the laser beam shines on. 

For example case: `10 x 10`

* n = 10, laser: 0 0 RIGHT

`-> - - - - - - - - \`

`/ - - - - - - - \ -`

`- / - - - - - \ - -`

`- - / - - - \ - - -`

`- - - / - \ - - - -`

`- - - - \ / - - - -`

`- - - \ - - / - - -`

`- - \ - - - - / - -`

`- \ - - - - - - / -`

`\ - - - - - - - - /`

should return 19

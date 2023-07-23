# Advanced-Data-Structures-Project
A project made for the Advanced Data Structures class at MIT Pune (2018).

Team members: 
* Prithviraj Khelkar - pkhelkar26@gmail.com
* Sambhav Agarval - sambhav03@gmail.com
* Himani Mali - himani.mali1996@gmail.com
* Anjali Iyer - anjaliiyer7@gmail.com

## Description
A top down snake game made in Java using linked lists, based on the classic Snake game. 

## Classes
### Node
A Node in the snake body.
Stores the location (x, y), color, and the next node.

### SnakeBody
The Body of the snake.
Contains all the nodes connected as a linked list, and the root node as the head of the snake.
Basic functions like eat, move, paint, etc.

### Arena
The playable area, extends JPanel, which overrides the paintComponent method.

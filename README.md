# Predator-Prey Simulation

A console simulation written in Java as an OOP practice project.

## Features

* 2D world represented by `Map<Coordinates, Entity>`
* Predators, herbivores, grass and static obstacles
* Breadth-First Search pathfinding
* Separate `Action` system for world updates
* Renderer and `WorldMap` classes separated from simulation logic

## Notes

This project was built as a learning exercise focused on:

* OOP design
* Inheritance and polymorphism
* Collections
* Pathfinding algorithms
* Refactoring and project structure

Known limitations:

* Simulation ends when there is no grass left.
* `pauseSimulation()` and turn counter are not implemented.
* Pathfinding and creature behavior can still be improved.

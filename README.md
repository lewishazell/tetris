# Tetris
[![GitHub](https://img.shields.io/github/license/lewishazell/tetris)](https://github.com/lewishazell/tetris/blob/master/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/lewishazell/tetris)](https://github.com/lewishazell/tetris/issues)
[![GitHub Repo stars](https://img.shields.io/github/stars/lewishazell/tetris?style=social)](https://github.com/lewishazell/tetris/stargazers)

![Tetris](/assets/images/game.png)

In my second year at University I was given the assignment to develop the famed Tetris in Java. We didn't have to implement the full game to pass but, being me, I can't have a half finished game.

What you see here is the result of some honest long hours of work finished off by a final all nighter to get the pesky rotations working.

I was really happy with the result so I keep it around on a public repository.

## Usage
I might package this up more nicely at some point. For now, you can build and run the application if you have maven installed.

### Build
From the root of the repository, run
```
mvn compile
mvn package
```

Which should produce a `.jar` file in the `target/` directory.

### Run
To run the application, go to the `target/` directory and run
```
java -jar tetris-1.0-SNAPSHOT.jar
```
Tetris should now play it all of its glory.

## Controls
### Tetromino movement
You can move tetrominos left and right with the left and right arrow keys. Easy.

### Tetromino speed
The default rate is pretty slow. The down arrow will make your tetrominos fall faster.

### Tetromino rotation
![Tetromino](/assets/images/tetromino-rotate1.png)
![Tetromino](/assets/images/tetromino-rotate2.png)

The game is pretty hard to play without rotations. To rotate your tetrmonios, use the "Q" and "E" keys on your keyboard to rotate left and right respectively.

## Features
I implemented as many features as I could from the original game to make it as playable as possible.

### Next tetromino preview
![Tetromino preview](/assets/images/tetromino-preview.png)


As in the original game, you get to see what's coming up. Honestly, sometimes this helps me; other times it just shows me how utterly screwed I am.

### Classic tetris music
Everyone loves the soundtrack looping over, and over, and over... especially while testing it during an all nighter. I added it, enjoy.

## Design
I wrote this about 8 years ago now so some details are foggy, but I distinctly remember wanting separation of concerns between the game logic and the display. Looking at the source code now, I think it paid off. In theory, another display framework could easily be put in place of java swing. This decision also made reasoning with the game logic much more simple, which was needed.

One improvement I could make would be to implement rotations per tetromino type. I think I tried to create a general rotation method for all tetrominos which is very difficult, has some hacky "corrections" and isn't really necessary for good gameplay.
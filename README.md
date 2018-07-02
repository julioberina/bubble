# bubble

A game about popping bubbles

## Overview

The goal of the game is to pop as many bubbles as possible. Each level has a
certain amount of bubbles and an amount you need to pop in order to move on
to the next level. This is a clone of the flash game [Boomshine](http://www.k2xl.com/games/boomshine)
written in Clojurescript with [play-cljs](https://github.com/oakes/play-cljs).

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

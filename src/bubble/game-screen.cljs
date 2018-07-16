(ns bubble.game-screen
  (:require [play-cljs.core :as p]
            [bubble.core :as c]))

(def game-screen
  (reify p/Screen
    (on-show [this]
      (swap! c/state assoc :screen :goal))

    (on-hide [this])

    (on-render [this]
      (p/render c/game
        [(c/black-box-component) (c/blue-box-component)]))))

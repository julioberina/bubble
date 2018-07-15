(ns bubble.goal-screen
  (:require [play-cljs.core :as p]
            [bubble.core :as c]))

(defn text-component []
  [:fill {:color "white"}
   [:text {:value "This is the goal screen"
           :x (+ (@c/state :gx) 70)
           :y (+ (@c/state :gy) 250)
           :font "Arial"
           :size 36}]])

(def goal-screen
  (reify p/Screen
    (on-show [this]
      (swap! c/state assoc :screen :goal))

    (on-hide [this])

    (on-render [this]
      (p/render c/game
        [(c/black-box-component) (c/blue-box-component) (text-component)]))))

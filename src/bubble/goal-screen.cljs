(ns bubble.goal-screen
  (:require [play-cljs.core :as p]
            [bubble.core :as c]))

(defn level-component []
  [:fill {:color "white"}
   [:text {:value (str "Level " (inc (@c/state :level)))
           :x (+ (@c/state :gx) 240)
           :y (+ (@c/state :gy) 100)
           :font "Arial"
           :size 48}]])

(defn current-goals-component []
  [:fill {:colors [50 200 50]}
   [:text {:value (str "Goal: " (get (@c/state :needed) (@c/state :level))
                       " out of "
                       (get (@c/state :total) (@c/state :level)))
           :x (+ (@c/state :gx) 150)
           :y (+ (@c/state :gy) 250)
           :font "Arial"
           :size 48}]])

(defn command-component []
  [:fill {:color "white"}
   [:text {:value "Press Enter to Play"
           :x (+ (@c/state :gx) 170)
           :y (+ (@c/state :gy) 400)
           :font "Arial"
           :size 36}]])

(def goal-screen
  (reify p/Screen
    (on-show [this]
      (swap! c/state assoc :screen :goal))

    (on-hide [this])

    (on-render [this]
      (p/render c/game
        [(c/black-box-component) (c/blue-box-component) (level-component)
         (current-goals-component) (command-component)]))))

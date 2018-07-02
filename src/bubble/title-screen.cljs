(ns bubble.title-screen
  (:require [play-cljs.core :as p]
            [bubble.core :as c]))

(def title-screen
  (reify p/Screen
    (on-show [this]
      (swap! c/state assoc :gx (/ (- (.-innerWidth js/window) 640) 2))
      (swap! c/state assoc :gy (/ (- (.-innerHeight js/window) 480) 2)))

    (on-hide [this])

    (on-render [this]
      (p/render c/game
        [[:fill {:color "black"}
          [:rect {:x 0 :y 0 :width (.-innerWidth js/window) :height (.-innerHeight js/window)}]]
         [:fill {:colors [50 50 120]}
          [:rect {:x (@c/state :gx) :y (@c/state :gy) :width 640 :height 480}]]]))))

(doto c/game
  (p/start)
  (p/set-screen title-screen))

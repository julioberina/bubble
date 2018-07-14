(ns bubble.title-screen
  (:require [play-cljs.core :as p]
            [bubble.core :as c]))

(defn black-box-component []
  [:fill {:color "black"}
   [:rect {:x 0 :y 0 :width (.-innerWidth js/window) :height (.-innerHeight js/window)}]])

(defn blue-box-component []
  [:fill {:colors [50 50 120]}
   [:rect {:x (@c/state :gx) :y (@c/state :gy) :width 640 :height 480}]])

(defn title-component []
  [:animation {:x (+ (@c/state :gx) 210) :y (+ (@c/state :gy) 100) :duration 100}
   [:fill {:color "red"}
    [:text {:value "Bubble" :font "Arial" :size 72}]]
   [:fill {:color "green"}
    [:text {:value "Bubble" :font "Arial" :size 72}]]
   [:fill {:color "blue"}
    [:text {:value "Bubble" :font "Arial" :size 72}]]
   [:fill {:color "yellow"}
    [:text {:value "Bubble" :font "Arial" :size 72}]]])

(defn description-component []
  [:fill {:color "white"}
   [:text {:value "A game about popping bubbles"
           :x (+ (@c/state :gx) 70)
           :y (+ (@c/state :gy) 250)
           :font "Arial"
           :size 36}]])

(defn command-component []
  [:fill {:color "white"}
   [:text {:value "Press Enter to Play"
           :x (+ (@c/state :gx) 170)
           :y (+ (@c/state :gy) 400)
           :font "Arial"
           :size 36}]])

(def title-screen
  (reify p/Screen
    (on-show [this]
      (swap! c/state assoc :gx (/ (- (.-innerWidth js/window) 640) 2))
      (swap! c/state assoc :gy (/ (- (.-innerHeight js/window) 480) 2)))

    (on-hide [this])

    (on-render [this]
      (p/render c/game
        [(black-box-component) (blue-box-component) (title-component)
         (description-component) (command-component)]))))

(doto c/game
  (p/start)
  (p/set-screen title-screen))

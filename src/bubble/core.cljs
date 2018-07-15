(ns bubble.core
  (:require [play-cljs.core :as p]
            [goog.events.KeyCodes :as kc]))

(enable-console-print!)

(defonce game (p/create-game (.-innerWidth js/window) (.-innerHeight js/window) {:debug? false}))
(defonce state (atom {}))

(defn black-box-component []
  [:fill {:color "black"}
   [:rect {:x 0 :y 0 :width (.-innerWidth js/window) :height (.-innerHeight js/window)}]])

(defn blue-box-component []
  [:fill {:colors [50 50 120]}
   [:rect {:x (@state :gx) :y (@state :gy) :width 640 :height 480}]])

(defn activate-keyup-event [g]
  (p/listen g "keyup"
    (fn [e]
      (if (= (.-keyCode e) kc/ENTER)
        (case (@state :screen)
          :title (swap! state assoc :screen :goal))))))

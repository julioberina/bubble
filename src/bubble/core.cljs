(ns bubble.core
  (:require [play-cljs.core :as p]))

(enable-console-print!)

(defonce game (p/create-game (.-innerWidth js/window) (.-innerHeight js/window) {:debug? false}))
(defonce state (atom {}))

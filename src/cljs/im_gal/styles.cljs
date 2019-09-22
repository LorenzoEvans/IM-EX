(ns im-gal.styles
  (:require [herb.core :refer [defglobal]]))

(defglobal global
  [:body {:margin 0 :border "6px solid black"}])
(defn example-style []
  {:background "red"
   :height "50px"
   :width "10%"})

; (defn app []
;   {})
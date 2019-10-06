(ns im-gal.components.pieces.d3-1
  (:require [cljsjs.d3]))

(def data ["pink", "skyblue", "deepskyblue",
           "royalblue", "steelblue", "lavender",
           "violet", "pinks", "deeppink"])

(def width 500)
(def height 500)
(def lines 1000)
(def linethickness 0.1)
(def circumference (Math.PI))
(def space (/ circumference lines))

(defn linesdata []
  (-> js/d3
      (.range lines)))

(defn append-svg []
  (-> js/d3
      (.select "#d3-test")
      (.append "svg")
      (.attr "height" height)
      (.attr "width" width)
      (.attr "transform" "translate('+width/2+','+height/2+')")))
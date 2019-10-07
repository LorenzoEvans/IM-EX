(ns im-gal.components.pieces.d3-1
  (:require [cljsjs.d3]))

(def data ["gainsboro", "skyblue", "deepskyblue",
           "indigo", "steelblue", "lavender",
           "violet", "magenta", "deeppink" "slategray"])

(def width 500)
(def height 500)
(def lines 1000)
(def linethickness 0.1)
(def circumference (Math.PI))
(def space (/ circumference lines))


(defn linesdata 
  (-> js/d3
      (.range lines)
      (.map (fn [d i]
              (js-obj 
               {"startAngle" (* i space)
                "endAngle" (* (+ linethickness (* i space)) 0.5)
                "outerRadius" (* (/ width 20) (/ i 100))
                "strokeWidth" 0.05
                "fillopacity" (get data (% i 10))})))))

(defn segment [segment path fill class]
  (-> svg
      (.selectAll segment)
      (.data linesdata)
      (.enter)
      (.append path)
      (.attr class segment)
      (.style fill (fn [d] d.fillcolor))
      (.style)))

(def d3arc []
  (-> js/d3
      (.arc)
      (.innerRadius 50)))

(defn append-svg []
  (-> js/d3
      (.select "#d3-test")
      (.append "svg")
      (.attr "height" height)
      (.attr "width" width)
      (.attr "transform" "translate('+width/2+','+height/2+')")))


(defn ^:export main []
  )

(defn on-js-reload [])
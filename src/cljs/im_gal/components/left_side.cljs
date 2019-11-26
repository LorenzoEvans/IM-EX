(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area]]))
(def skills 
  ["Javascript"
   "React"
   "Node/Express"
   "CSS, variants"
   "Agile"
   "RDBMS"
   "Testing"
   "Python"
   "Deployment"
   "Algorithms"
   "Data Structures"
   "GraphQL"
   "FP"
   "OOP"
   "Git"
   "Clojure/Script"])

(defn left-side []
  [:div.h-100.avenir.overflow-scroll.z-3.bw2.b--near-black.w-60
   [:section.mb2.tracked.bw2.threed-text.dark-gray.h-100.bw2.w-100.justify-between {:class content-area}  "Skills"
    [:div.w-60.flex.flex-row.flex-wrap.justify-evenly.no-shadow.h-75
     (for [item skills]
       [:span.f1.no-shadow.dark-gray.hover-animate.grow.glow.bg-washed-blue.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3 item])]]
   [:section.mb2.tracked.threed-text.dark-gray.flex.flex-column.items-center.pl5.h-100.w-100.bt.bw2.b--near-white.mt4 {:class content-area} "Experience"]
   [:section.mb2.tracked.threed-text.dark-gray.flex.flex-column.items-center.pl5.h-100.bw2.w-60 {:class content-area} "Projects"]
   [:section.mb2.tracked.threed-text.dark-gray.flex.flex-column.items-center.pl5.h-25.w-60 {:class content-area} "Contact"]])
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
  [:div.h-100.avenir.w-100.overflow-scroll.z-3.bg-near-white.bl.bw2
   [:section.tracked.bb.bw2.threed-text.dark-gray.flex.flex-column.items-center.pl5.ml7.h-100.bw2.w-100.justify-between {:class content-area}  "Skills"
    [:div.flex.flex-row.flex-wrap.w-50.overflow-scroll.justify-evenly.no-shadow
     (for [item skills]
       [:span.f1.no-shadow.dark-gray.hover-animate.grow.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3 item])]]
   [:section.tracked.bb.bw2.threed-text.dark-gray.flex.flex-column.items-center.pl5.ml7.h-100.bw2.bg-washed-blue.w-100 {:class content-area} "Experience"]
   [:section.tracked.bb.bw2.threed-text.dark-gray.flex.flex-column.items-center.pl5.ml7.h-100.bw2.bg-washed-near-white.w-100 {:class content-area} "Projects"]
   [:section.tracked.bb.bw2.threed-text.dark-gray.flex.flex-column.items-center.pl5.ml7.h-25.bw2.bg-washed-blue.w-100 {:class content-area} "Contact"]])
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
  [:div.h-100.avenir.overflow-scroll.z-3.bw2.b--near-black.w-60.ml3-m
   [:section.mb2.tracked.bw2.threed-text.dark-gray.h-100.bw2.w-100.justify-between.bb {:class content-area}  "Skills"
    [:div.w-100.flex.flex-row.flex-wrap.justify-evenly.no-shadow.h-75.w-80-m
     (for [item skills]
       ^{:key item}
       [:span.f1.no-shadow.self-center.dark-gray.hover-animate.grow.glow.bg-washed-blue.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3.f4-m.ma1-m.justify-between-m item])]]
   [:section.mb2.tracked.threed-text.dark-gray.flex.flex-column.items-center.h-100.w-100.bb.bw2.b--near-white.mt5 {:class content-area} "Experience"]
   [:section.mb2.tracked.threed-text.dark-gray.h-100.bw2.w-100.b--near-white.mt5.overflow-scroll {:class content-area} "Projects"
    [:h1.tc.f5.ttu.fw6.tracked.mb4.avenir "Directory"]
     [:div.flex.flex-row.flex-wrap 
      [:div.w-50.border-box.f1.fw5.overflow-hidden.ba.bw2.white.h-25.ma4.near-black.no-shadow "Maybe Sheeps"]
      [:div.w-50.border-box.f1.fw5.overflow-hidden.ba.bw2.white.h-25.ma4.near-black.no-shadow "Aunalytix"]
      [:div.w-50.border-box.f1.fw5.overflow-hidden.ba.bw2.white.h-25.ma4.near-black.no-shadow "Note Taken"]
      [:div.w-50.border-box.f1.fw5.overflow-hidden.ba.bw2.white.h-25.ma4.near-black.no-shadow "stuff"]
      [:div.w-50.border-box.f1.fw5.overflow-hidden.ba.bw2.white.h-25.ma4.near-black.no-shadow "stuff"]]]])
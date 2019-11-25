(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area]]))
(def skills 
  ["Skill Stack"
   "Javascript"
   "React"
   "Node/Express"
   "CSS"
   "SCSS"
   "LESS"
   "SQL"
   "Testing"
   "Version Control"
   "Agile"
   "Deployment"
   "Heroku"
   "GraphQL"
   "Functional Programming"
   "Clojure/Script"])

(defn left-side []
  [:div.h-100.overflow-scroll.avenir.w-100
   [:section.tc.h-100.bw2.bg-washed-red.w-100.relative {:class content-area}
    [:div.flex.flex-row.flex-wrap.items-end
     [:span.navy.f-headline "Skills"]
    (for [item skills]
      [:span.h4.f1.fw5.hover-dark-blue.b.no-underline.black.pa2.ba.bw2.w-20.ma3 item])]]
   [:section.tc.h-100.bw2.bg-washed-near-white.navy.absolute.w-100.h-100 {:class content-area}]
   [:section.tc.h-100.bw2.bg-washed-blue.navy.w-100.fixed {:class content-area} "Experience"]
   [:section.tc.h-100.bw2.bg-washed-yellow.navy.flex.flex-row.justify-around {:class content-area} "Projects"]
   [:section.tc.h-100.bw2.bg-washed-yellow.navy {:class content-area} "Blog"]])
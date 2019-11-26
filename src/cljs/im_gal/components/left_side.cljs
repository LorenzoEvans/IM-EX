(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area
                                   ]]))
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
  [:div.h-100.overflow-scroll.avenir.w-50.flex.flex-column.justify-center 
   [:section.tc.h-100.bw2.bg-washed-red {:class content-area} "Skills"]
   [:section.tc.h-100.bw2.bg-washed-near-white.navy.h-100 {:class content-area}]
   [:section.tc.h-100.bw2.bg-washed-blue.navy {:class content-area} "Experience"]
   [:section.tc.h-100.bw2.bg-washed-yellow.navy.flex.flex-row.justify-around {:class content-area} "Projects"]])
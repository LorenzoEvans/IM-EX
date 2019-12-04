(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area project-container
                                   project-content]]))
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

(def projects 
  [{:name "Maybe Sheeps"
    :about "info"
    :tech-used "tech info"}
    
   {:name "Aunalytix"
    :about "info"
    :tech-used "tech info"}
    
   {:name "RateMyDIY"
    :about "info"
    :tech-used "tech info"}
    
   {:name "Note Taken"
    :about "info"
    :tech-used "tech info"}])
    
   
(defn left-side []
  [:div.h-100.avenir.overflow-scroll.z-3.bw2.b--near-black.w-60.ml3-m
   [:section.mb2.tracked.bw2.threed-text.dark-gray.h-100.bw2.w-100.justify-between.bb {:class content-area}  "Skills"
    [:div.w-100.flex.flex-row.flex-wrap.justify-evenly.no-shadow.h-75.w-80-m
     (for [item skills]
       ^{:key item}
       [:span.f1.no-shadow.self-center.dark-gray.hover-animate.grow.glow.bg-washed-blue.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3.f4-m.ma1-m.justify-between-m item])]]
   [:section.mb2.tracked.threed-text.dark-gray.flex.flex-column.h-100.w-100.bb.bw2.b--near-white.mt5 {:class content-area} "Experience"]
   [:section.mb2.tracked.threed-text.dark-gray.h-100.bw2.w-100.b--near-white.mt5.overflow-scroll {:class content-area} "Projects"
    [:div.flex.flex-row.flex-wrap
     [:div {:class project-container} "Maybe Sheeps"
      [:div.ba.bw3.b--washed-green.pa2.f2.tracked-tight.lh-copy "Personal micro-blog for tech-related/miscellaneous things I find interesting, and chronicling my experience and growth with the FP paradigm/as a Clojurist/Lisp hacker."]]
     [:div {:class project-container} "Note Taken"
      [:div {:class project-content} "Desktop application for taking notes/reminders, etc, originally done in React/Node/Express, re-vamped in Seesaw, a Clojure framework for developing Desktop applications."]]
     [:div {:class project-container} "Aunalytix"]]]])
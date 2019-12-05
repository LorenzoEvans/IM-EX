(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area project-container project-link
                                   project-content nav-span doc-span name-cta]]))
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
  [ {:name "Maybe Sheeps"
     :about "Personal micro-blog for tech-related/miscellaneous things I find interesting, and chronicling my experience and growth with the FP paradigm/as a Clojurist/Lisp hacker."
     :tech-used ["tech info"]
     :app-link "https://maybe-sheeps.herokuapp.com"}
    
   {:name "Aunalytix"
    :about "Aunalytix will target creative artists (currently audio-focused), who are tired of not having access to data regarding their music, due to the nature of the environment in which said data is generated, and likewise, consumers of said art, who are also tired of having the same experience with their data. The goal of this application is to strike up a synergy between the needs and roles of artists, and their supporters, via the user-centric data handling principles this application will enforce."
    :tech-used ["tech info"]
    :app-link "https://aunalytix.herokuapp.com"}
    
   {:name "RateMyDIY"
    :about "RateMyDiy targets people who want to get up and get productive and learn different skills. It utilizes a rating system to analyze the most effective and enjoyed projects, project makers, and reviewers. This will allow the projects and user generated content that is most beneficial to the community to be the most available to people who are looking for high quality information."
    :tech-used ["Firebase, GraphQL, React, SCSS"]
    :docs "https://ratemydiy.github.io/Documentation/Architecture.html"
    :app-link "http://ratemydiy.tk"}
   {:name "Note Taken"
    :about  "Desktop application for taking notes/reminders, etc, originally done in React/Node/Express/SQL, re-vamped in Seesaw, a Clojure framework for developing Desktop applications in Swing, JDBC/SQL, features including but not limited to markdown parsing, and export to file extensions."
    :tech-used ["tech info"]
    :app-link ""}])
    
   
(defn left-side []
  [:div.h-100.avenir.overflow-scroll.z-3.bw2.b--near-black.w-60.ml3-m
   [:section.mb2.tracked.bw2.threed-text.dark-gray.h-100.bw2.w-100.justify-between.bb {:class content-area}  "Skills"
    [:div.w-100.flex.flex-row.flex-wrap.justify-evenly.no-shadow.h-75.w-80-m
     (for [item skills]
       ^{:key item}
       [:span.f1.no-shadow.self-center.dark-gray.hover-animate.grow.glow.bg-washed-blue.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3.f4-m.ma1-m.justify-between-m item])]]
   [:section.mb2.tracked.threed-text.dark-gray.flex.flex-column.h-100.w-100.bb.bw2.b--near-white.mt5 {:class content-area} "Experience"]
   [:section.mb2.tracked.threed-text.dark-gray.h-100.bw2.w-100.b--near-white.mt5.overflow-scroll.bl.b--washed-red.bw3.pl2 {:class content-area} "Projects"
    (for [project projects]
     [:div.flex.flex-row.flex-wrap
        ^{:key (:name project)}
        [:div {:class project-container} (:name project)
          [:div {:class project-content} (:about project)]
          [:a {:class project-link :href (:app-link project)} "Link to project"]
          (cond (not= (:docs project) nil)[:a {:class project-link
                  :href "https://ratemydiy.github.io/Documentation/Architecture.html"} "Documentation"])
          [:div 
           (for [item (:tech-used project)] [:li {:class project-link} item])]]])]])
      

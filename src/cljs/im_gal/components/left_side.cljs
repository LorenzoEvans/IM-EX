(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area project-container project-link
                                   project-content nav-span doc-span name-cta
                                   skill-style project-content-area experience-content-area
                                   skills-content-area f-row-wrap content-container
                                   skills-container expr-bullet]]))
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

; Projects map

(def projects 
  [ {:name "Maybe Sheeps"
     :about "Personal micro-blog for tech-related/miscellaneous things I find interesting, and chronicling my experience and growth with the FP paradigm/as a Clojurist/Lisp hacker."
     :tech-used [(str "reagent," "ring," "hiccup,")]
     :app-link "https://maybe-sheeps.herokuapp.com"}
    
   {:name "Aunalytix"
    :about "Aunalytix will target creative artists (currently audio-focused), who are tired of not having access to data regarding their music, due to the nature of the environment in which said data is generated, and likewise, consumers of said art, who are also tired of having the same experience with their data. The goal of this application is to strike up a synergy between the needs and roles of artists, and their supporters, via the user-centric data handling principles this application will enforce."
    :tech-used [(str "re-frame," "herb," "Tachyons," "secretary," "pushy,")]
    :app-link "https://aunalytix.herokuapp.com"}
    
   {:name "RateMyDIY"
    :about "RateMyDiy targets people who want to get up and get productive and learn different skills. It utilizes a rating system to analyze the most effective and enjoyed projects, project makers, and reviewers. This will allow the projects and user generated content that is most beneficial to the community to be the most available to people who are looking for high quality information."
    :tech-used ["Firebase, GraphQL/Apollo, Prisma, Sendgrid, Stripe, Cloudinary, React, SASS"]
    :docs "https://ratemydiy.github.io/Documentation/Architecture.html"
    :app-link "http://ratemydiy.tk"}
   {:name "Note Taken"
    :about  "Web application for taking notes/reminders, re-written as a Desktop application in Clojure, features including but not limited to markdown parsing, and export to file extensions."
    :tech-used ["Originally: React, Node, Express, SQL. Re-work: Clojure/Seesaw/JDBC/SQL.",]
    :app-link "TBA"}])
; Experience map

(def experience
  [{:title "Team Lead (Back End)"
    :duration "May 2019 - July 2019"
    :job-desc ["Supported 5-9 students in learning, meeting MVP in various frameworks, across all levels of the stack, using agile methods."
               "Received 2.87 / 3 rating as a Team Lead."
               "Piloted new school-wide video feed-back program, via retrospectives covering student/TL experience with program."
               "Took part in daily stand ups, code reviews, on-on-ones, and help desks with Section Leads, fellow TL’s and students."]}])

(defn content-side []
  [:div {:class content-container}
   [:section {:class skills-content-area}  "Skills"
    [:div {:class skills-container}
     (for [item skills]
       ^{:key item}
       [:span {:class skill-style} item])]]
   [:section {:class experience-content-area} "Experience"
    (for [expr experience] 
      [:div.no-shadow.ma2.mt3.flex.flex-column {:class project-content}
       [:<> 
        [:span.f3 (:title expr)]
        [:div.w-75.h-100 {:class project-container}
         (for [bullet (expr :job-desc)]
          [:div {:class expr-bullet} bullet])]]])]
   [:section {:class project-content-area} "Projects"
    (for [project projects]
     [:div {:class f-row-wrap}
        ^{:key (:name project)}
        [:div {:class project-container} (:name project)
          [:div {:class project-content} (:about project)]
          [:a.tracked-ns.no-underline {:class project-link 
                                       :href (:app-link project)} "Link to project"]
          (cond (not= (:docs project) nil)[:a {:class project-link
                                               :href "https://ratemydiy.github.io/Documentation/Architecture.html"} "Documentation"])
          [:div 
           (for [item (:tech-used project)] 
            [:div.tracked-ns "Tech Used" [:li {:class project-link} item]])]]])]])
      

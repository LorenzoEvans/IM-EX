(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area project-container project-link
                                   project-content nav-span doc-span name-cta
                                   skill-style project-content-area experience-content-area
                                   skills-content-area f-row-wrap content-container
                                   skills-container expr-bullet experience-container
                                   project-title project-about]]))
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
   "Clojure/Script"
   "Java/JVM"])

; Projects map

(def projects 
  [{:name "Synths For Compilers"
     :about "Personal micro-blog for tech-related/miscellaneous things I find interesting, and chronicling my experience and growth with the FP paradigm/as a Clojurist/Lisp hacker."
     :tech-used ["reagent" "tachyons" "hiccup" "SQL"]
     :app-link "https://www.synthsforcompilers.dev"
     :repo "https://github.com/LorenzoEvans/m-s"}
   {:name "Clojurena"
    :about "A library that acts as a wrapper over the are.na API."
    :tech-used ["Clojure"]
    :docs "https://0xledev.gitbook.io/clojurena/"
    :app-link "https://clojars.org/clojurena"
    :repo "https://github.com/LorenzoEvans/clojurena"}
   {:name "RateMyDIY"
    :about "RateMyDiy targets people who want to get up and get productive and learn different skills. It utilizes a rating system to analyze the most effective and enjoyed projects, project makers, and reviewers. This will allow the projects and user generated content that is most beneficial to the community to be the most available to people who are looking for high quality information."
    :tech-used ["Firebase" "GraphQL/Apollo" "Prisma" "Sendgrid" "Stripe" "Cloudinary" "React" "SASS"]
    :docs "https://ratemydiy.github.io/Documentation/Architecture.html"
    :app-link "http://ratemydiy.tk"
    :repo "https://github.com/Lambda-School-Labs/labspt2-rate-my-diy"}
   {:name "Personote"
    :about  "Desktop note-taking application in Clojure, CLJFX/OpenJFX for GUI programming, JDBC/SQL for persistence."
    :tech-used ["Clojure" "CLJFX/OpenJFX" "JDBC/SQL"]
    :repo "https://github.com/LorenzoEvans/duly-noted"}])
    
; Experience map

(def experience
  [{:title "Team Lead (Back End)"
    :duration "May 2019 - July 2019"
    :job-desc ["Supported 5-9 students in learning, meeting MVP in various frameworks, across all levels of the stack, using agile methods."
               "Received 2.87 / 3 rating as a Team Lead."
               "Piloted new school-wide video feed-back program, via retrospectives covering student/TL experience with program."
               "Took part in daily stand ups, code reviews, on-on-ones, and help desks with Section Leads, fellow TL’s and students."]}])

(defn skills-component []
  (fn []
    [:section.tc {:class skills-content-area} "Skills"
     [:div {:class skills-container}
      (for [item skills]
       ^{:key item}
       [:span {:class skill-style} item])]])) 
      
(defn experience-component []
  (fn []
   [:section.tc {:class skills-content-area} "Experience"
    [:div
     (for [expr experience]
       [:div.flex.flex-column.justify-center
        [:span.f2.tc.mt1 (:title expr)]
        (for [bullet (expr :job-desc)]
         [:div {:class expr-bullet} bullet])])]]))

(defn project-component []
 (fn []
  [:div
   [:section.tc {:class project-content-area} "Projects"
    (for [project projects]
     [:div.self-center.items-center.content-center.ba.bw3 {:class project-container}
      ^{:key (:name project)}
      [:div {:class project-title} (:name project)
       [:div {:class project-about} (:about project)]]
      [:a {:class project-link
           :href (:app-link project)} "Link To Project"]
      (if (not= (:docs project) nil)
       [:a.no-underline.near-black.hover-light-gray.hover-animate {:class project-link :href (:docs project)} "Documentation"] nil)
      [:div.bt.bw2.w-100.pt2 "Technology Used"
       [:div.tc.flex.flex-row.flex-wrap
        (for [item (:tech-used project)]
         [:div.ma2.ba
          [:div.hover-near-black.grow.glow.hover-bg-moon-gray.hover-animate.f3.pa2.cursor item]])]]])]]))

(defn content-side []
  (fn []
   [:div {:class content-container}
    [skills-component]
    [experience-component]
    [project-component]]))

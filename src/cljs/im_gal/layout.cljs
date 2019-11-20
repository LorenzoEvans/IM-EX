(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles :refer [nav-div
                                     nav-div-2
                                     nav-nav
                                     nav-h1
                                     content-area
                                     nav-h3
                                     nav-anchor]]
   [clojure.string :as str]))

(defn link-border
  []
  {:border "2px solid #999999"})

(defn nav []
  [:div {:class nav-div}
   [:div.vh-100.flex.flex-column.justify-between {:class nav-div-2}
    [:nav.vh-100 {:class nav-nav}
     [:h1 {:class nav-h1} "Lorenzo Evans"
      [:span [:h3.mr4 {:class nav-h3}] "Programmer, creative, writer."]]
     [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/about"} "About"]
     [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/contact"} "Contact"]]]])

(defn left-sidebar []
  [:div.w-two-thirds.h-100.overflow-scroll.avenir.ba
   [:section.tc.h-75.bw2.bg-washed-red.navy.f-headline{:class content-area} "Skills"]
   [:section.self-center.h-75.bw2.bg-washed-blue.navy.f-headline.w-100.fixed {:class content-area} "Experience"]
   [:section.tc.h-75.bw2.bg-washed-near-white.navy.f-headline.fw6 {:class content-area} "Projects"]
   [:section.tc.h-75.bw2.bg-washed-near-white.navy.f-headline.fw6 {:class content-area} "Blog"]
   ])

(defn about []
  [:div.bg-near-white.w-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the About Page."]

   [:div
    [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/"}
     "go to Home Page"]]])

(defn contact []
  [:div.bg-near-white.w-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the Contact Page"]
   [:div
    [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/"}
     "go to Home Page"]]])

(defn home []
  [:div.flex.row.justify-center.bg-near-white.w-100.purple.bw3.vh-100
   [nav]
   [left-sidebar]])
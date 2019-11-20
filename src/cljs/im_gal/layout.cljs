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
    [:nav.vh-100.shadow-5.w-100 {:class nav-nav}
     [:h1.f2-m.bb.bw2.bg-near-white.white {:class nav-h1} "Lorenzo Evans"]
      [:div.flex.flex-column.justify-evenly
       [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw4.hover.dim [:h3.ma4 {:class nav-h3}] "Programmer."]
       [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw4.hover.dim [:h3.ma4 {:class nav-h3}] "Creative."]
       [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw4.hover.dim [:h3.ma4 {:class nav-h3}] "Writer."]]]]])

(defn left-sidebar []
  [:div.w-100.h-100.overflow-scroll.avenir
   [:section.tc.h-75.bw2.bg-washed-red.navy.f-headline{:class content-area} "Skills"]
   [:section.tc.h-75.bw2.bg-washed-blue.navy.f-headline.w-100.fixed {:class content-area} "Experience"]
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
  [:div.flex.row.justify-center.bg-near-white.w-100.purple.bw3.vh-100.flex-row-m
   [nav]
   [left-sidebar]])
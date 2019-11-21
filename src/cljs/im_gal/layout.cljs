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

(defn width []
  {:width " 40% "})
(defn width-2 []
  {:width " 60% "})
(defn nav []
  [:div.bg-white.fixed.z-2 {:class (str nav-div (<class width)) }
   [:div.vh-100.flex.flex-column.justify-between {:class nav-div-2}
    [:nav.vh-100.shadow-5.w-100 {:class nav-nav}
[:div.flex.flex-column.justify-evenly.self-center.items-center
 [:h1.f2-m.bb.bw2.w-100 {:class nav-h1} "Lorenzo Evans"]
 [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw5.hover.dim.dark-gray [:h3.ma4 {:class nav-h3}] "Programmer."]
 [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw5.hover.dim.dark-gray [:h3.ma4 {:class nav-h3}] "Creative."]
 [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw5.hover.dim.dark-gray [:h3.ma4 {:class nav-h3}] "Writer."]]]]])

(defn left-sidebar []
  [:div.h-100.overflow-scroll.avenir.w-100 {:class (<class width-2)}
   [:section.tc.h-75.bw2.bg-washed-red.navy.f-headline.w-100.relative {:class content-area} "Skills"]
   [:section.tc.h-75.bw2.bg-washed-blue.navy.w-100.fixed {:class content-area} "Experience"]
   [:section.tc.h-75.bw2.bg-washed-near-white.navy {:class content-area} "Projects"]
   [:section.tc.h-75.bw2.bg-washed-near-white.navy.absolute.w-100.h-100 {:class content-area} "Blog"]
   [:section.tc.h-75.bw2.bg-washed-near-white.navy {:class content-area} "Contact"]
   [:section.h-100 "holup"]])

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
  [:div.flex.row.bg-near-white.w-100.purple.bw3.vh-100.flex-row-m
   [nav]
   [left-sidebar]])
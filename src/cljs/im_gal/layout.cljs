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
   [reagent.core :as reagent]
   [reanimated.core :as anim]
   [clojure.string :as str]))

(defn link-border
  []
  {:border "2px solid #999999"})

(defn pop-contacts []
         (let [show? (reagent/atom false)]
           (fn a-pop-when-example []
             [:div.flex.flex-column.justify-between.w-100.h-100
              [:button.bg-near-black.washed-green.avenir.mr5.mt4.pa2 {:on-click (anim/toggle-handler show?)} "Github"]
              [anim/pop-when @show?
               [:div.flex.flex-column.justify-between.w-100.h-100.ma4 
                [:span.mt4.tc [:a.fw6.f3tracked.near-black.dim {:href "www.github/com"} "Github"]]
                [:span.mt4.tc [:a.fw6.f3tracked.near-black.dim {:href "www.github/com"} "LinkedIn"]]
                [:span.mt4.tc [:a.fw6.f3tracked.near-black.dim {:href "www.github/com"} "Tweeter"]]]
               ]])))

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
  [:div.h-100.overflow-scroll.avenir.w-100
   [:section.tc.h-100.bw2.bg-washed-red.navy.f-headline.w-100.relative {:class content-area} "Skills"]
   [:section.tc.h-100.bw2.bg-washed-near-white.navy.absolute.w-100.h-100 {:class content-area}
    [pop-contacts]]
   [:section.tc.h-100.bw2.bg-washed-blue.navy.w-100.fixed {:class content-area} "Experience"]
   [:section.tc.h-100.bw2.bg-washed-yellow.navy.flex.flex-row.justify-around {:class content-area} "Projects"]
   [:section.tc.h-100.bw2.bg-washed-yellow.navy {:class content-area} "Blog"]])

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
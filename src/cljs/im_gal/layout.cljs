(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles :refer [nav-div
                                     nav-div-2
                                     nav-nav
                                     nav-h1
                                     nav-anchor]]
   [tincture.container]))




(defn link-border
  []
  {:border "1px solid #999999"})


(defn nav []
  [:div {:class nav-div}
   [:div {:class nav-div-2}
    [:nav {:class nav-nav}
     [:h1 {:class nav-h1} "The Immutable Gallery"]
     [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/about"} "About"]
     [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/contact"} "Contact"]]]])



(defn middle-bar []
  [:div.bg-near-black.w-third.ba.bw3.washed-blue])

(defn left-sidebar []
  [:div.bg-light-gray.w-third])

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
    [:a{:class (str (<class link-border) nav-anchor "hover-border") :href "/"}
     "go to Home Page"]]])

(defn home []
  [:div.flex.row.justify-center.bg-near-white.w-100.purple.bw3.vh-100
   [nav]
   [middle-bar]
   [left-sidebar]])
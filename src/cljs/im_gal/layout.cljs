(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles]))


; (defn bg-border []
;   ^{:pseudo 
;     {:hover 
;      {:border-radius "0.25rem"}}})


(defn link-border
  []
  {:border "1px solid gainsboro"})

(defn nav []
  [:div.flex.justify-center.ba.bg-near-white.w-third
   [:div.near-black.avenir.fw2.f2.f-headline-ns.db.bg-near-black
    [:nav {:class "br2 flex row justify-center pa2 washed-green"}
     "The Immutable Gallery"]
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc
     {:class (<class link-border) :href "/about"} "About"]
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc
     {:class (<class link-border) :href "/contact"} "Contact"]]])

(defn right-sidebar []
  [:div.bg-near-black.h-100.w-third])

(defn left-sidebar []
  [:div.bg-near-black.h-100.w-third])

(defn about []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:href "/"}
     "go to Home Page"]]])

(defn contact []
  [:div
   [:h1 "This is the Contact Page"]
   [:div
    [:a {:href "/"}
     "go to Home Page"]]])

(defn home []
  [:div.flex.row.justify-center.ba.bg-near-white.w-100
   [nav]
   [right-sidebar]
   [left-sidebar]]
  )
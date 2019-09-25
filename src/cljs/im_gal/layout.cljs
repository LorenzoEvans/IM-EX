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
  [:div.bg-near-white.w-third
   [:div.near-black.avenir.fw2.f2.f-sub-headline.lh-title.db.bg-washed-gray
    [:nav {:class "flex column justify-center pa2"}
     "The Immutable Gallery"]
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc
     {:class (<class link-border) :href "/about"} "About"]
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc
     {:class (<class link-border) :href "/contact"} "Contact"]]])

(defn middle-bar []
  [:div.bg-near-black.h-100.w-third.ba.bw3.washed-blue])

(defn left-sidebar []
  [:div.bg-light-gray.h-100.w-third])

(defn about []
  [:div.bg-near-white.w-100.h-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the About Page."]

   [:div
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc {:href "/"}
     "go to Home Page"]]])

(defn contact []
  [:div.bg-near-white.w-100.h-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the Contact Page"]
   [:div
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc {:href "/"}
     "go to Home Page"]]])

(defn home []
  [:div.flex.row.justify-center.ba.bg-near-white.w-100
   [nav]
   [middle-bar]
   [left-sidebar]])
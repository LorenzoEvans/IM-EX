(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles]
   [tincture.container]))


; (defn bg-border []
;   ^{:pseudo 
;     {:hover 
;      {:border-radius "0.25rem"}}})


(defn link-border
  []
  {:border "1px solid #999999"})



(defn nav []
  [:div.bg-near-white.w-third.bottom
   [:div.near-black.avenir.f2.f-sub-headline.lh-title.db.bg-washed-gray
    [:nav {:class "flex column justify-center ma3 flex-wrap"}
     [:h1.fw2.f-sub-headline.tc "The Immutable Gallery"]
    [:a.no-underline.fw2.link.dib.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.w-100.tc.h3.ma1
     {:class (<class link-border) :href "/about"} "About"]
    [:a.no-underline.fw2.link.dib.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.w-100.tc.h3.ma1
     {:class (<class link-border) :href "/contact"} "Contact"]]
    ]])

(defn middle-bar []
  [:div.bg-near-black.w-third.ba.bw3.washed-blue])

(defn left-sidebar []
  [:div.bg-light-gray.w-third])

(defn about []
  [:div.bg-near-white.w-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the About Page."]

   [:div
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc {:href "/"}
     "go to Home Page"]]])

(defn contact []
  [:div.bg-near-white.w-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the Contact Page"]
   [:div
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc {:href "/"}
     "go to Home Page"]]])



(defn home []
  [:div.flex.row.justify-center.bg-near-white.w-100.purple.bw3.vh-100
   [nav]
   [middle-bar]
   [left-sidebar]])
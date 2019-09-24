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
  {:border "1px solid black"})


(defn home []
  [:div.bg-washed-green.h-100.w-100
   [:nav {:class "w-100 br2 mt4"}
    [:a.near-black.avenir.link.dim.fw4.f1.f-headline-ns.tc.db.mb3.mb4-ns.tj.i
     "Le Musée Immuable"]
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.lh-title.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.w-20 
     {:class (<class link-border) :href "/about"} "About"] 
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.lh-title.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.w-20
     {:class (<class link-border) :href "/contact"} "Contact"]]
       [:article.f3.h4.avenir.bg-washed-blue.w-third.black.mt2.pa2 {:class (<class link-border)} 
        "AN ART DEFECTOR, AN ASTRAL VECTOR, ATLANTIC LECTURE, AN ORCHID TEXTURE, AN ART COLLECTOR...-Girouard"]])

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
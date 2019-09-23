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
  {:border "2px solid black"})


(defn home []
  [:nav {:class "bg-near-white fl w-100"}
   [:a.dark-gray.avenir.link.dim.b.f1.f-sub-headline-ns.tc.db.mb3.mb4-ns.tj
    "Welcome to The Immutable Gallery"]
    [:a.no-underline.link.dib.mr5.f2.lh-title.avenir.hover-washed-green.navy.grow.dim.bg-animate.bg-white.hover-bg-black.br2.ba2.bw2.pa2.w-20 
     {:class (<class link-border) :href "/about"} "About"] [:a.no-underline.link.dib.mr5.f2.lh-title.avenir.hover-washed-green.navy.grow.dim.bg-animate.bg-white.hover-bg-black.br2.ba2.bw2.pa2.w-20
     {:class (<class link-border) :href "/contact"} "Contact"]])

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
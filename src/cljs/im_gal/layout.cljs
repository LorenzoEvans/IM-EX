(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles]))

; (defn home []
;   [:nav.bg-washed-red.pa3.pa4-ns
;    [:a.navy.system-sans-serif.link.dim.b.f1.f-headline-ns.tc.db.mb3.mb4-ns
;     "Welcome to The Immutable Gallery"]

;    [:div.tc.pb3
;     [:a.no-underline.link.dim.gray.f6.f5-ns.dib.mr3.f1.lh-title {:href "/about"}
;      "About"]
;     [::a.no-underline.link.dim.gray.f6.f5-ns.dib.mr3.f1.lh-title {:href "/contact"}
;      "Contact"]]])

(defn home []
  [:nav {:class "bg-near-white pa3 pa4-ns"}
   [:a.dark-gray.avenir.link.dim.b.f1.f-sub-headline-ns.tc.db.mb3.mb4-ns.tj
    "Welcome to The Immutable Gallery"]
   [:div.tc.pb3
    [:a.no-underline.link.dib.mr3.f1.lh-title.avenir.hover-washed-green.navy.grow.dim.bg-animate.bg-white.hover-bg-black.br2.ba.bw2
     {:href "/about"} "About"]
    [:a.no-underline.link.dim.gray.dib.mr3.f1.lh-title.avenir.hover-washed-green.navy.grow.dim.hover-bg-black
     {:href "/contact"} "Contact"]]])

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
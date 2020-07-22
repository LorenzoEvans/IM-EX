(ns portfolio.components.contact
  (:require [portfolio.styles :refer [link-border nav-anchor]]
            [herb.core :refer [<class]]))
(defn contact []
  [:div.bg-near-white.w-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the Contact Page"]
   [:div
    [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/"}
     "go to Home Page"]]])
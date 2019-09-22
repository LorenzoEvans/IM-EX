(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles :refer [example-style]]))

(defn home []
  [:div {:class (<class example-style)}
   [:h1 "This is thafsdfsdfsfe Home Page."]

   [:div
    [:a {:href "/about"}
     "go to About Page"]
    [:a {:href "/contact"}
     "go to Contact Page"]]])
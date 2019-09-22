(ns im-gal.views
  (:require
   [re-frame.core :as re-frame]
   [im-gal.subs :as subs]
   [herb.core :as herb :refer [<class]]
   [im-gal.layout :as layout :refer [home]]))

;; about


(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:href "/"}
     "go to Home Page"]]])

(defn contact-panel []
  [:div
   [:h1 "This is the Contact Page"]
   [:div
    [:a {:href "/"}
     "go to Home Page"]]])
;; main


(defn- panels [panel-name]
  (case panel-name
    :home-panel [home]
    :about-panel [about-panel]
    :contact-panel [contact-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))

(ns im-gal.views
  (:require
   [re-frame.core :as re-frame]
   [im-gal.subs :as subs]
   [im-gal.layout :refer [home]]
   [im-gal.components.about :refer [about]]
   [im-gal.components.contact :refer [contact]]
   ))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home]
    :about-panel [about]
    :contact-panel [contact]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))

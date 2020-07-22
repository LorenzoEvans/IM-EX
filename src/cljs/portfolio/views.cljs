(ns portfolio.views
  (:require
   [re-frame.core :as re-frame]
   [portfolio.subs :as subs]
   [portfolio.layout :refer [home]]
   [portfolio.components.about :refer [about]]
   [portfolio.components.contact :refer [contact]]
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

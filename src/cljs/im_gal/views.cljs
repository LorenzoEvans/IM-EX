(ns im-gal.views
  (:require
   [re-frame.core :as re-frame]
   [im-gal.subs :as subs]
   [herb.core :as herb :refer [<class]]
   [im-gal.layout :as layout :refer [home
                                     about
                                     contact]]))

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

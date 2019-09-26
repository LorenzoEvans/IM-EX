(ns im-gal.styles
  (:require [herb.core :refer [defglobal]]))

(defglobal global
  [:body {:margin 0, :min-height "100%"}]
  [:html {:min-height "100vh"}]
  )

(defn height []
  {:height "100vh"})


; (defn app []
;   {})
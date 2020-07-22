(ns portfolio.layout
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [cljs.core.async :refer [<! put! chan timeout go-loop]]
   [portfolio.components.content :refer [content-side]]
   [portfolio.components.nav :refer [nav]]
   [reagent.core :as reagent]
   [goog.dom :as dom]
   [goog.events :as events]
   [goog.events.EventType :as EventType]
   [clojure.string :as str]))

(defn home []
  [:div.flex.flex-row.w-100.purple.bw3.vh-100.flex-row-m.bg-image
   [nav]
   [content-side]])
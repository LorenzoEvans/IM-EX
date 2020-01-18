(ns im-gal.layout
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [cljs.core.async :refer [<! put! chan timeout go-loop]]
   [im-gal.components.left-side :refer [content-side]]
   [im-gal.components.nav :refer [nav]]
   [reagent.core :as reagent]
   [goog.dom :as dom]
   [goog.events :as events]
   [goog.events.EventType :as EventType]
   [reanimated.core :as anim]
   [clojure.string :as str]))

(defn home []
  [:div.flex.flex-row.w-100.purple.bw3.vh-100.flex-row-m.fixed.bg-image
   [nav]
   [content-side]])
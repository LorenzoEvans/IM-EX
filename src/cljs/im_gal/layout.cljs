(ns im-gal.layout
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [cljs.core.async :refer [<! put! chan timeout go-loop]]
   [herb.core :as h :refer [<class]]
   [im-gal.components.left-side :refer [left-side]]
   [im-gal.components.nav :refer [nav]]
   [im-gal.components.about :refer [about]]
   [im-gal.styles :as styles :refer [nav-div
                                     nav-div-2
                                     link-border
                                     nav-nav
                                     nav-h1
                                     content-area
                                     nav-h3
                                     width
                                     nav-anchor]]
   [reagent.core :as reagent]
   [goog.dom :as dom]
   [goog.events :as events]
   [goog.events.EventType :as EventType]
   [reanimated.core :as anim]
   [clojure.string :as str]))


(def cur-scroll-y (atom 0))
(def prev-scroll-y (atom 0))


(defn- get-scroll []
  (-> (dom/getDocumentScroll) (.-y)))
; Uses JS .- interop form to get the y property of the getDocumentScroll obj?

(defn- events->chan [el event-type c]
  (events/listen el event-type #(put! c %)) 
  c)

(defn scroll-chan []
  (events->chan js/window EventType/SCROLL (chan 1 (map get-scroll))))

(defn listen! []
  (let [chan (scroll-chan)]
    (go-loop []
      (let [new-y (<! chan)] ; takes value out of channel
        (reset! prev-scroll-y @cur-scroll-y)))))

; Every time the window produces a scroll event, the event is put into a channel.
; The event has no real scroll position info, so it's discarded, and the document
; is queried for the curren position w/ (chan 1 (map get-scroll))



(defn home []
  [:div.flex.row.bg-near-white.w-100.purple.bw3.vh-100.flex-row-m
   [nav]
   [left-side]])
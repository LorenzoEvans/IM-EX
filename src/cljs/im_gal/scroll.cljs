(ns im-gal.scroll
  (:require    [goog.dom :as dom]
               [goog.events :as events]
               [goog.events.EventType :as EventType]
               [cljs.core.async :refer [<! put! chan timeout go-loop]]))
(def cur-scroll-y (atom 0))
(def prev-scroll-y (atom 0))


(defn- get-scroll []
  (-> (dom/getDocumentScroll) (.-y)))
; Uses JS .- interop form to get the y property of the getDocumentScroll obj?

(defn- events->chan [el event-type c]
  ; there's a dom element
  ; an event type (scroll)
  ; c = arg?
  (events/listen el event-type #(put! c %))
  c)

(defn scroll-chan []
  (events->chan js/window EventType/SCROLL (chan 1 (map get-scroll))))
; Every time the window produces a scroll event, the event is put into a channel.
; The event has no real scroll position info, so it's discarded, and the document
; is queried for the curren position w/ (chan 1 (map get-scroll))

(defn listen! []
  (let [chan (scroll-chan)]
    (go-loop []
      (let [new-y (<! chan)] ; takes value out of channel
        (reset! prev-scroll-y @cur-scroll-y)
        (reset! cur-scroll-y (max 0 new-y)))
      (recur))))

; with one call to listen!, the app will receive the new scroll position, and
; will store it in cur-scroll-y, pushing the previous val to prev-scroll-y,
; both of which get fed to the animation engine
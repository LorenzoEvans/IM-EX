(ns ^:figwheel-always im-gal.core
  (:require))

(enable-console-print!)

(println "This text is printed from src/im-gal/core.cljs. Go ahead and edit it and see reloading in action.")

(js/console.log "Hello, Gitsdadasdadsadfsfdhub Pages!")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello New world!"}))

(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)


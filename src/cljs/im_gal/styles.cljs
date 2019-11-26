(ns im-gal.styles
  (:require [herb.core :refer [defglobal]]))

(defglobal global
  [:body {:margin 0, :min-height "100%"}]
  [:html {:min-height "100vh"}])

(defn height []
  {:height "100vh"})


(defn link-border
  []
  {:border "2px solid #999999"})

;; im-gal.layout nav component classnames for Tachyons.

(defn width []
  {:width " 40% "})
(defn width-2 []
  {:width " 60% "})


(defn new-string [x]
  (clojure.string/replace x "." " "))

(def nav-div (new-string " flex.flex-column.justify-between.vh-100.dark-blue "))
(def nav-div-2 (new-string "avenir.f2.f-sub-headline.lh-title.db.bg-washed-gray"))
(def nav-nav (new-string "flex.column.justify-center.flex-wrap"))
(def nav-h1 (new-string "fw6.f-headline.tc.near-black"))
(def nav-h3 (new-string "fw6.f-subheadline.tc.link."))
(def nav-anchor (new-string "no-underline.fw3.link.dib.f2.bg-near-white.tracked.self-center.avenir.hover-washed-blue.ba.bw1.hover-purple.navy.grow.glow.bg-animate.hover-bg-near-black.br3.pa2.w-100.tc.h5.ma1."))
(def content-area (new-string "bw2.f-headline.fw6"))
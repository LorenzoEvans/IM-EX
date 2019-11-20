(ns im-gal.styles
  (:require [herb.core :refer [defglobal]]))

(defglobal global
  [:body {:margin 0, :min-height "100%"}]
  [:html {:min-height "100vh"}])

(defn height []
  {:height "100vh"})


; (defn app []
;   {})

;; im-gal.layout nav component classnames for Tachyons.


(defn new-string [x]
  (clojure.string/replace x "." " "))

(def nav-div (new-string "flex.flex-column.justify-between.bg-near-white.w-33.vh-100"))
(def nav-div-2 (new-string "near-black.avenir.f2.f-sub-headline.lh-title.db.bg-washed-gray"))
(def nav-nav (new-string "flex.column.justify-center.ma3.flex-wrap"))
(def nav-h1 (new-string "fw6.f-subheadline.tc.navy.bb.bt.bw2"))
(def nav-h3 (new-string "fw6.f-subheadline.tc"))
(def nav-anchor (new-string "no-underline.fw2.link.dib.f2.bg-near-white.avenir.hover-washed-blue.ba.bw1.hover-purple.navy.grow.glow.bg-animate.hover-bg-near-black.br3.pa2.w-100.tc.h3.ma1."))
(def content-area (new-string "bw2.bg-washed-green.navy.f1.f-subheadline"))
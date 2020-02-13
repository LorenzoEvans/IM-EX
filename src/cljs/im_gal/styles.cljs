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

(defn width []
  {:width " 40% "})

(defn width-2 []
  {:width " 60% "})

(defn new-string [x]
  (clojure.string/replace x "." " "))

(def project-link (new-string "f3.no-shadow.self-center.dark-gray.glow.bg-washed-blue.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3"))
(def expr-bullet (new-string "f3.no-shadow.self-center.dark-gray.glow.bg-washed-blue.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3.w-75"))
(def experience-container (new-string "w-50.flex.flex-row.flex-wrap.justify-evenly.no-shadow.h-75.w-80-m"))

(def nav-div (new-string " flex.flex-column.justify-between.vh-100.dark-blue "))
(def nav-div-2 (new-string "avenir.f2.f-sub-headline.lh-title.db.bg-washed-gray"))
(def nav-nav (new-string "flex.column.justify-center.flex-wrap"))
(def nav-h1 (new-string "fw6.f-headline.tc.near-black"))
(def nav-span-2 (new-string "mt3.w-60-m.bw2.w-75.hover-animate.3glow.f2.f2-m.pa1.avenir.fw6.near-black.bg-near-white.grow.hover-dark-gray.hover-bg-animated.hover-bg-gray.glow.bounceInElement"))

(def nav-span (new-string "mt3.w-60-m.bw2.w-75.glow.f-subheadline.f2-m.pa1.avenir.fw6.near-black.bg-near-white.bounceInElement.tracked-tight"))
(def project-container (new-string "flex.flex-column.w-90.border-box.fw5.ba.bw2.b--near-black.white.h-100.ma4.bg-black-40.bw2.no-shadow.pa2"))
(def project-content (new-string "ba.bw3.b--washed-green.pa2.f2.lh-copy"))
; (def project-content-area (new-string "tc.bt.b--black.bw2.mt2.f-subheadline.fw6.dark-gray"))
(def project-content-area (new-string "f-subheadline.fw6.bw2.dark-gray.h-75.bw2.w-100.flex.flex-column.bb.mt3"))
(def project-title (new-string "near-white.ma1"))
(def project-about (new-string "fw3.f2.ma1.lh-copy"))
(def skills-content-area (new-string "f-subheadline.fw6.bw2.dark-gray.bw2.w-100.flex.flex-column.bb"))
(def skill-style (new-string "f2.no-shadow.self-center.dark-gray.hover-animate.glow.bg-washed-blue.br1.pa2.hover-dark-pink.ba.bw2.b--near-black.ma2.f4-m.ma1-m.justify-between-m"))
(def skills-container (new-string "w-100.flex.flex-row.flex-wrap.justify-evenly.no-shadow.h-75.w-80-m"))

(def content-area (new-string "f-headline.fw6"))
(def contact-section (new-string "mb2.pa2.dark-gray.h-100.w-80.w-100-m.mt5.bw2.b--washed-red.glow.hover-animate.grow.glow.ma4.no-shadow.near-black.flex.flex-column.h-75.justify-between.f2.bg-near-white"))
(def content-container (new-string "h-100.avenir.overflow-scroll.z-3.w-60.b--near-black.ma1"))

(def f-row-wrap (new-string "flex.flex-row"))
(def my-name (new-string "bw3.f-headline.near-black.grow.glow.hover-animate.o-80.w-90.hover-washed-red.ba.w-90-m.f1-m.fw6.element.pa1"))
(def name-cta (new-string "mt3.bw3.f-headline.light-green.grow.glow.hover-animate.o-80.w-80.hover-washed-red.ba.w-90-m.f1-m.fw6.elements"))
(def contact-anchor (new-string "mt3.w-60-m.bw2.w-75.hover-animate.glow.f-subheadline.f2-m.pa1.avenir.fw6.near-black.bg-near-white.hover-bg-animated"))
(def doc-span (new-string "no-underline.mt3.w-60-m.bw2.w-75.bb.glow.f2.f2-m.pa1.avenir.fw6.washed-green.grow.glow"))
(def nav-anchor (new-string "no-underline.fw3.link.dib.f2.bg-near-white.self-center.avenir.hover-washed-blue.ba.bw1.hover-purple.navy.grow.glow.bg-animate.hover-bg-near-black.pa2.w-100.tc.h5.ma1."))
(def experience-content-area (new-string "f-subheadline.fw6.mb2.dark-gray.flex.flex-column.h-75.w-100.bb.bw2.b--near-white.mt5"))

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

(def project-link (new-string "f3.no-shadow.self-center.dark-gray.hover-animate.grow.glow.bg-washed-blue.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3"))
(def expr-bullet (new-string "f3.no-shadow.self-center.dark-gray.hover-animate.glow.bg-light-gray.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3"))
(def name-cta (new-string "mt3.bw3.f-headline.light-green.grow.glow.hover-animate.o-80.w-80.hover-washed-red.ba.w-90-m.f1-m.fw6.elements"))
(def nav-div (new-string " flex.flex-column.justify-between.vh-100.dark-blue "))
(def nav-div-2 (new-string "avenir.f2.f-sub-headline.lh-title.db.bg-washed-gray"))
(def nav-nav (new-string "flex.column.justify-center.flex-wrap"))
(def nav-h1 (new-string "fw6.f-headline.tc.near-black"))
(def project-container (new-string "flex.flex-column.w-75.border-box.f1.fw5.ba.bw2.white.h-50.ma4.bg-black-20.bw2.no-shadow.pa2"))
(def project-content (new-string "ba.bw3.b--washed-green.pa2.f2.tracked-tight.lh-copy"))
(def nav-span (new-string "mt3.w-60-m.bw2.w-75.hover-animate.bb.glow.f2.f2-m.pa1.avenir.fw6.near-black.bg-near-white.grow.hover-dark-gray.hover-bg-animated.hover-bg-gray.glow.bounceInElement"))
(def doc-span (new-string "no-underline.mt3.w-60-m.bw2.w-75.bb.glow.f2.f2-m.pa1.avenir.fw6.washed-green.grow.glow"))
(def nav-anchor (new-string "no-underline.fw3.link.dib.f2.bg-near-white.tracked.self-center.avenir.hover-washed-blue.ba.bw1.hover-purple.navy.grow.glow.bg-animate.hover-bg-near-black.pa2.w-100.tc.h5.ma1."))
(def project-content-area (new-string "f-headline.fw6.mb2.tracked.threed-text.dark-gray.h-100.bw2.w-100.b--near-white.mt5.overflow-scroll.bl.b--washed-red.bw3.pl2"))
(def experience-content-area (new-string "f-headline.fw6.mb2.tracked.threed-text.dark-gray.flex.flex-column.h-100.w-100.bb.bw2.b--near-white.mt5"))
(def skills-content-area (new-string "f-headline.fw6.mb2.tracked.bw2.threed-text.dark-gray.h-100.bw2.w-100.justify-between.bb"))
(def content-area (new-string "f-headline.fw6"))
(def contact-section (new-string "mb2.pa2.dark-gray.h-100.w-80.w-100-m.mt5.ba.bw2.b--washed-red.glow.hover-animate.grow.glow.ma4.no-shadow.near-black.flex.flex-column.h-75.justify-between.f2.bg-near-white"))
(def skill-style (new-string "f1.no-shadow.self-center.dark-gray.hover-animate.grow.glow.bg-washed-blue.br1.pa3.hover-dark-pink.ba.bw2.b--near-black.ma3.f4-m.ma1-m.justify-between-m"))
(def f-row-wrap (new-string "flex.flex-row.flex-wrap"))
(def content-container (new-string "h-100.avenir.overflow-scroll.z-3.bw2.b--near-black.w-60.ml3-m"))
(def skills-container (new-string "w-100.flex.flex-row.flex-wrap.justify-evenly.no-shadow.h-75.w-80-m"))
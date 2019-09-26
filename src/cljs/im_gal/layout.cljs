(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles]))


; (defn bg-border []
;   ^{:pseudo 
;     {:hover 
;      {:border-radius "0.25rem"}}})


(defn link-border
  []
  {:border "1px solid gainsboro"})

(defn footer []
  [:div.pa4.pa5-1.black-70.flex.column
   [:div.mb4-1.cf.justify-evenly.mt2
    [:h1.fl.w-third.pv0.f6.fw6.ttu.tracked.mb4 "Studios"]
    [:article.fl.w-third.dib-ns.w-auto-ns.mr4-m.mr5-1.mb4.pr2.pr0-ns.flex.column
     [:h2.f5.f4-l.fw6 "SF"]
     [:span.f6-1.db.black-70 "Larkin"]
     [:span.f6.f7-1.black-70] "Columbus, OH"
     [:a.f6.db.fw6.pv3.black-70.link.dim "Contact"]]
    [:article.fl.w-third.dib-ns.w-auto-ns.mr4-m.mr5-1.mb4.pl2.pl0-ns.flex.column
     [:h4.f2-1.fw2 "OH"]
     [:span.f7.f2-1.db.black-70]
     [:a.f2.db.fw6.pv3.link.dim.black-70 "Email Artist"]]
    [:article.fl.w-third.dib-ns.w-auto-ns.mr4-m.mr5-1.mb4.pr2.pr0-ns.flex.column
     [:h4.f6-1.fw6 "London"]
     [:span.f7.f6-1.db.black-70]
     [:span.f7.f6-1.black-70 "Ohio, USA"]
     [:a.link.dim.f6.db.fw6.pv3.black-70 "Ohio HQ"]
     ]
    [:article.fl.w-50.dib-ns.w-auto-ns.mr4-m.mr5-1.mb4.pr2.pr0-ns
     [:h4.f5.f4-1.fw6 "London"]
     [:span.f7.f6-1.db.black-70]
     [:span.f7.f6-1.black-70 "Ohio, USA"]
     [:a.link.dim.f6.db.fw6.pv3.black-70 "Ohio HQ"]]]])

(defn nav []
  [:div.bg-near-white.w-third
   [:div.near-black.avenir.fw2.f2.f-sub-headline.lh-title.db.bg-washed-gray
    [:nav {:class "flex column justify-center pa2"}
     "The Immutable Gallery"]
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc
     {:class (<class link-border) :href "/about"} "About"]
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc
     {:class (<class link-border) :href "/contact"} "Contact"]
    [footer]]])

(defn middle-bar []
  [:div.bg-near-black.h-100.w-third.ba.bw3.washed-blue])

(defn left-sidebar []
  [:div.bg-light-gray.h-100.w-third])

(defn about []
  [:div.bg-near-white.w-100.h-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the About Page."]

   [:div
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc {:href "/"}
     "go to Home Page"]]])

(defn contact []
  [:div.bg-near-white.w-100.h-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the Contact Page"]
   [:div
    [:a.no-underline.link.dib.mr5.ml5.f2.bg-near-white.avenir.hover-washed-blue.navy.grow.glow.bg-animate.hover-bg-near-black.br3.ba2.bw2.pa2.h3.w-30.tc {:href "/"}
     "go to Home Page"]]])



(defn home []
  [:div.flex.row.justify-center.ba.bg-near-white.w-100
   [nav]
   [middle-bar]
   [left-sidebar]])
(ns im-gal.components.nav
  (:require [im-gal.styles :refer [nav-div
                                   nav-div-2
                                   nav-nav
                                   nav-h1
                                   nav-h3
                                   width]]
            [herb.core :refer [<class]]))

(defn nav []
  [:div.w-40 {:class nav-div}
   [:img.absolute.bg-image]
   [:div.vh-100.flex.flex-column.justify-between {:class nav-div-2}
    [:nav.vh-100.w-100 {:class nav-nav}
     [:div.flex.flex-column.justify-between.h-75.self-center.items-center.relative
      [:span.mt3.bw3.f-headline.light-green.grow.glow.hover-animate.bg-mid-gray.o-80.w-100.hover-washed-red.ba.w-90-m.f1-m.fw6.pa1 "Lorenzo Evans"]
      [:span.mt3.w-60-m.ba.bw1.w-100.hover-animate.bb.bw3.bg-mid-gray.o-80.glow.f-headline.f2-m.pa1.avenir.fw6.light-green.grow.hover-washed-red "Programmer."]
      [:span.mt3.w-60-m.ba.bw1.w-100.hover-animate.bb.bw3.bg-mid-gray.o-80.glow.f-headline.f2-m.pa1.avenir.fw6.light-green.grow.hover-washed-red "Creative."]
      [:span.mt3.w-60-m.ba.bw1.w-100.hover-animate.bb.bw3.bg-mid-gray.o-80.glow.f-headline.f2-m.pa1.avenir.fw6.light-green.grow.hover-washed-red. "Writer."]]]]])
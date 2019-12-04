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
      [:div.mt3.bw3.f-headline.light-green.grow.glow.hover-animate.o-80.w-80.hover-washed-red.ba.w-90-m.f1-m.fw6.element "Lorenzo Evans"]
      [:span.mt3.w-60-m.bw2.w-75.hover-animate.bb.glow.f2.f2-m.pa1.avenir.fw6.washed-green.grow.hover-dark-gray.hover-bg-animated.hover-bg-gray.glow.bounceInElement "Programmer."]
      [:span.mt3.w-60-m.bw2.w-75.hover-animate.bb.glow.f2.f2-m.pa1.avenir.fw6.washed-green.grow.hover-dark-gray.hover-bg-animated.hover-bg-gray.glow.bounceInElement "Creative."]
      [:span.mt3.w-60-m.bw2.w-75.hover-animate.bb.glow.f2.f2-m.pa1.avenir.fw6.washed-green.grow.hover-dark-gray.hover-bg-animated.hover-bg-gray.glow.bounceInElement "Writer."]
      [:section.mb2.pa2.dark-gray.h-100.w-80.w-100-m.mt5.ba.bw2.b--washed-red.glow.hover-animate.grow.glow.ma4.no-shadow.near-black.flex.flex-column.h-75.justify-between.f2
        [:span.avenir.no-shadow.near-white.f-headline.w-100.bb.bw2.b--dark-gray.f2-m "Contact"]
        [:a.no-underline.ba.bw2.avenir.near-white.f1.glow.no-shadow {:href "mailto:lorenzo.evans94@gmail.com"} "Email"]
       [:a.avenir.ba.bw2.no-shadow.near-white.hover-animate.glow.f1.no-underline {:href "https://www.linkedin.com/in/lorev/"} "LinkedIn"]]]]]])
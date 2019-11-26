(ns im-gal.components.nav
  (:require [im-gal.styles :refer [nav-div
                                   nav-div-2
                                   nav-nav
                                   nav-h1
                                   nav-h3
                                   width]]
            [herb.core :refer [<class]]))

(defn nav []
  [:div.bg-white.z-2.w-40.fixed {:class nav-div }
   [:div.vh-100.flex.flex-column.justify-between {:class nav-div-2}
    [:nav.vh-100.shadow-5.w-100 {:class nav-nav}
     [:div.flex.flex-column.justify-evenly.self-center.items-center
      [:h1.f2-m.bb.bw2.w-100 {:class nav-h1} "Lorenzo Evans"]
      [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw5.hover.dim.dark-gray [:h3.ma4 {:class nav-h3}] "Programmer."]
      [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw5.hover.dim.dark-gray [:h3.ma4 {:class nav-h3}] "Creative."]
      [:span.bb.bw2.f-subheadline.f2-m.pa1.avenir.fw5.hover.dim.dark-gray [:h3.ma4 {:class nav-h3}] "Writer."]]]]])
(ns im-gal.components.nav
  (:require [im-gal.styles :refer [nav-div
                                   nav-div-2
                                   nav-nav
                                   nav-h1
                                   nav-h3
                                   width]]
            [herb.core :refer [<class]]))

(defn nav []
  [:div.bg-white.w-60 {:class nav-div}
   [:img.absolute.bg-image {:src "https://images.unsplash.com/photo-1556804599-f7d0c84b61b8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2600&q=80"}]
   [:div.vh-100.flex.flex-column.justify-between {:class nav-div-2}
    [:nav.vh-100.shadow-5.w-100 {:class nav-nav}
     [:div.flex.flex-column.justify-evenly.self-center.items-center.relative
      [:h1.f2-m.bb.bw3.w-100 {:class nav-h1} "Lorenzo Evans"]
      [:span.bb.bw3.f-subheadline.f2-m.pa1.avenir.fw5.hover.glow.grow.hover-washed-red.z-3 [:h3.ma4 {:class nav-h3}] "Programmer."]
      [:span.bb.bw3.f-subheadline.f2-m.pa1.avenir.fw5.hover.glow.grow.hover-washed-red.z-3 [:h3.ma4 {:class nav-h3}] "Creative."]
      [:span.bb.bw3.f-subheadline.f2-m.pa1.avenir.fw5.hover.glow.grow.hover-washed-red. [:h3.ma4 {:class nav-h3}] "Writer."]]]]])
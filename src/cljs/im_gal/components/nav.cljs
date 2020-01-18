(ns im-gal.components.nav
  (:require [im-gal.styles :refer [nav-div
                                   nav-div-2
                                   nav-nav
                                   nav-h1
                                   nav-span
                                   nav-span-2
                                   contact-section
                                   width my-name]]
            [herb.core :refer [<class]]))

(defn nav []
  [:div.w-40 {:class nav-div}
   [:img.absolute.bg-image]
   [:div.vh-100.flex.flex-column.justify-between {:class nav-div-2}
    [:nav.vh-100.w-100 {:class nav-nav}
     [:div.flex.flex-column.justify-between.h-75.mt3.items-center.relative
      [:div {:class my-name} "Lorenzo Evans"]
      [:span {:class nav-span} "Programmer."]
      [:span {:class nav-span} "Creative."]
      [:span {:class nav-span} "Writer."]
      [:span {:class nav-span-2} "Contact:"]
      [:a.no-underline.ba.bw2.avenir.near-black.f1.glow.no-shadow.bg-near-white {:class nav-span :href "mailto:lorenzo.evans94@gmail.com"} "Email"]
      [:a.avenir.ba.bw2.no-shadow.near-black.hover-animate.glow.f1.no-underline.bg-near-white {:class nav-span :href "https://www.linkedin.com/in/lorev/"} "LinkedIn"]]]]])

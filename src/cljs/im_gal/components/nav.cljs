(ns im-gal.components.nav
  (:require [im-gal.styles :refer [nav-div
                                   nav-div-2 nav-nav
                                   nav-h1 nav-span
                                   nav-span-2
                                   contact-section
                                   contact-anchor
                                   width my-name]]
            [herb.core :refer [<class]]))

(defn nav []
  [:div.w-40.br.bw2.b--near-black.bg-near-white {:class nav-div}
   [:div.vh-100.flex.flex-column.justify-between {:class nav-div-2}
    [:nav.vh-100.w-100 {:class nav-nav}
     [:div.flex.flex-column.justify-between.h-75.mt3.items-center.relative
      [:div {:class my-name} "Lorenzo Evans"]
      [:div.o-70 {:class nav-span} "Programmer."]
      [:div.o-70 {:class nav-span} "Creative."]
      [:div.o-70 {:class nav-span} "Writer."]
      [:a {:class contact-anchor :href "mailto:lorenzo.evans94@gmail.com"} "Email"]
      [:a {:class contact-anchor :href "https://github.com/LorenzoEvans/"} "Github"]
      [:a {:class contact-anchor :href "https://www.linkedin.com/in/lorev/"} "LinkedIn"]]]]])

(ns portfolio.components.nav
  (:require [portfolio.styles :refer [nav-div
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
      [:div.o-70 {:class nav-span} "(Functional) Programmer."]
      [:div.o-70 {:class nav-span :href "#"} "Creative."]
      [:a.o-70.no-underline {:class nav-span :href "https://www.synthsforcompilers.dev/systems/2020/may/systems-post/"} "Writer."]
      [:a.o-70.no-underline {:class nav-span :href "https://www.synthsforcompilers.dev/"} "Blog"]
      [:a.o-70.no-underline {:class nav-span :href "mailto:lorenzo.evans94@gmail.com"} "Email"]
      [:a.o-70.no-underline {:class nav-span :href "https://www.linkedin.com/in/lorev/"} "LinkedIn"]
      [:div.o-70.no-underline {:class contact-anchor :href "https://github.com/LorenzoEvans/"} "GitHub"]
      ]]]])

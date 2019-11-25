(ns im-gal.components.left-side
  (:require [im-gal.styles :refer [content-area]]))

(defn left-side []
  [:div.h-100.overflow-scroll.avenir.w-100
   [:section.tc.h-100.bw2.bg-washed-red.navy.f-headline.w-100.relative {:class content-area} "Skills"]
   [:section.tc.h-100.bw2.bg-washed-near-white.navy.absolute.w-100.h-100 {:class content-area}]
   [:section.tc.h-100.bw2.bg-washed-blue.navy.w-100.fixed {:class content-area} "Experience"]
   [:section.tc.h-100.bw2.bg-washed-yellow.navy.flex.flex-row.justify-around {:class content-area} "Projects"]
   [:section.tc.h-100.bw2.bg-washed-yellow.navy {:class content-area} "Blog"]])
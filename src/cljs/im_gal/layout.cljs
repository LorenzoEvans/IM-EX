(ns im-gal.layout
  (:require
   [herb.core :as h :refer [<class]]
   [im-gal.styles :as styles :refer [nav-div
                                     nav-div-2
                                     nav-nav
                                     nav-h1
                                     nav-anchor]]
   [thi.ng.geom.core :as g]
   [thi.ng.math.core :as m]
   [thi.ng.geom.circle :as c]
   [thi.ng.geom.svg.core :as svg :refer [serialize]]
   [thi.ng.geom.svg.adapter :as adapt]
   [thi.ng.color.core :as col]))

(defn labeled-dot
  [p label] (list (c/circle p 3) (svg/text (m/+ p 10 0) label)))

(def scene
  (let [c1    (c/circle 50 150 50)
        c2    (c/circle 250 150 50)
        c3    (c/circle 150 150 100)
        [a b] (g/intersect-shape c1 c3)
        [c d] (g/intersect-shape c2 c3)]
    (svg/svg
     {:width 300 :height 300}
     (svg/group
      {:fill "yellow"}
      ;; these circles inherit all attributes from parent group
      c1 c2
      ;; we can use metadata to override specific attribs per shape
      ;; here we also demonstrate automatic color attrib conversion
      (with-meta c3 {:fill (col/rgba 0 1 1 0.25) :stroke (col/hsva 0 1 1)}))
     (svg/group
      {:fill "#000"
       :font-family "Arial, sans-serif"
       :font-size 10}
      (mapcat labeled-dot [a b c d] ["A" "B" "C" "D"])))))

(def scene
  (fn []
    (->> scene
         (adapt/all-as-svg)                  ;; transform all scene elements
         (svg/serialize)                     ;; serialize as SVG XML string
         (spit "out/svg-circles.svg"))))

(defn link-border
  []
  {:border "1px solid #999999"})

(defn nav []
  [:div {:class nav-div}
   [:div {:class nav-div-2}
    [:nav {:class nav-nav}
     [:h1 {:class nav-h1} "The Immutable Gallery"]
     [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/about"} "About"]
     [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/contact"} "Contact"]]]])

(defn middle-bar []
  [:div.bg-near-black.w-third.ba.bw3.washed-blue
   [:div (scene)]])

(defn left-sidebar []
  [:div.bg-light-gray.w-third])

(defn about []
  [:div.bg-near-white.w-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the About Page."]

   [:div
    [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/"}
     "go to Home Page"]]])

(defn contact []
  [:div.bg-near-white.w-100
   [:h1.f-sub-headline.lh-title.avenir.f2 "This is the Contact Page"]
   [:div
    [:a {:class (str (<class link-border) nav-anchor "hover-border") :href "/"}
     "go to Home Page"]]])

(defn home []
  [:div.flex.row.justify-center.bg-near-white.w-100.purple.bw3.vh-100
   [nav]
   [middle-bar]
   [left-sidebar]])
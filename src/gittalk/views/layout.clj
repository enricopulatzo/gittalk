(ns gittalk.views.layout
  (:use noir.request)
  (:require [gittalk.util :as util]
            [hiccup.core :as hiccup]))

(def template-path "gittalk/views/templates/")

(defn add-context [url] (str (:context *request*) url)) 

(defn include-css [& filenames]
  (for [filename filenames]
    [:link {:rel "stylesheet"
            :type "text/css"
            :href (str (add-context (str "/css/" filename)))}]))

(defn include-js [& filenames]
  (for [filename filenames]
    [:script {:type "text/javascript"
              :src (str (add-context (str "/js/" filename)))}]))

(defn base [title]
  (hiccup/html
    "<!DOCTYPE html>"
    [:html
     [:head
       [:title title]
       (include-css "screen.css" "bootstrap.css")
       [:script {:type "text/javascript"}
         (str "var context='" (:context *request*) "';")]]
     [:body#ng-app {:ng-app "gittalkApp"}
       [:div#wrap 
         [:div.container {:ng-view "" :ng-animate "{enter: 'view-anim-enter', leave 'view-anim-leave'}"}]
         [:div.push]]
       [:div#footer
         [:div.container
           [:p.muted.footer-text
             [:div.btn-group
               [:a.btn.btn-default {:ng-href "#/1" :target "_self"} "1"]
               [:a.btn.btn-default {:ng-href "#/2" :target "_self"} "2"]
               [:a.btn.btn-default {:ng-href "#/3" :target "_self"} "3"]
               [:a.btn.btn-default {:ng-href "#/4" :target "_self"} "4"]
               [:a.btn.btn-default {:ng-href "#/5" :target "_self"} "5"]]]]]
         [:script
           {:src "//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"}]
         (include-js "bootstrap.min.js" "app.js")]]))


(defn render [content]
  (hiccup/html (util/md->html content)))


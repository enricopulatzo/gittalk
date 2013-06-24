(ns gittalk.routes.home
  (:use compojure.core)
  (:require [gittalk.views.layout :as layout]
            [gittalk.util :as util]))

(defn home-page []
  (layout/base))

(defn first-page []
  (layout/render "/md/1.md"))

(defn not-found-page []
  (layout/render "/md/404.md"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/404.html" [] (not-found-page))
  (GET "/1.html" [] (first-page)))

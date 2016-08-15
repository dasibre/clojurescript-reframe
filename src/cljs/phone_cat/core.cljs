(ns phone-cat.core
  (:require
   [reagent.core :as reagent]
   [phone-cat.events]
   [phone-cat.subs]
   [re-frame.core :refer [subscribe dispatch]]
   [devtools.core :as devtools]
   ))


(defonce debug?
  ^boolean js/goog.DEBUG)

(defn dev-setup []
  (when debug?
    (enable-console-print!)
    (println "dev mode")
    (devtools/install!)
    ))

(def iphone {:name "Iphone 7" :snippet "Not so sure about this one."})

(defn phone-component
  [phone]
  [:li
   [:span (:name phone)]
   [:p (:snippet phone)]])

(defn phone-components
  []
  (let [phones (subscribe [:phones])] ; subscribe to the phones value in our db
    (fn []
      [:div
       [:button {:type "button" :on-click #(dispatch [:add-phone {:name "Iphone 7" :snippet "Not so sure about this one."}])} "Add phone"]
       [:ul (for [phone @phones]
             ^{:key (:name phone)} [phone-component phone])]])))

(defn reload []
  (reagent/render [phone-components]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (dispatch [:initialize-db])
  (reload))


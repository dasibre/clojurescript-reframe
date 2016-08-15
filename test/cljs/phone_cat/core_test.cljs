(ns phone-cat.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [phone-cat.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))

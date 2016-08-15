(ns phone-cat.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [phone-cat.core-test]))

(doo-tests 'phone-cat.core-test)

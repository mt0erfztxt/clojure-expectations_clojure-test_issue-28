(ns core-case1-test
  "Tests having only a thrown? assertion works."
  (:require
   [expectations.clojure.test :as t]
   [core :as c]))

(t/defexpect foo-test
  (t/expecting "throws when :a"
    (t/expect IllegalArgumentException (c/foo :a))))

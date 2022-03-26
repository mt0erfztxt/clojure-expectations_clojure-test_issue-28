(ns core-case2-test
  "Tests having exactly two assertions one of which is a thrown? assertion
  doesn't work."
  (:require
   [expectations.clojure.test :as t]
   [core :as c]))

(t/defexpect foo-test
  (t/expecting "throws when :a"
    (t/expect IllegalArgumentException (c/foo :a)))

  (t/expecting "returns :b when :b"
    (t/expect :b (c/foo :b))))

(t/defexpect foo-test--another-order
  (t/expecting "returns :b when :b"
    (t/expect :b (c/foo :b)))

  (t/expecting "throws when :a"
    (t/expect IllegalArgumentException (c/foo :a))))

(t/defexpect foo-test--two-thrown
  (t/expecting "throws when :a"
    (t/expect IllegalArgumentException (c/foo :a)))

  (t/expecting "throws when :a"
    (t/expect IllegalArgumentException (c/foo :a))))

(t/defexpect foo-test--wo-expecting
  (t/expect IllegalArgumentException (c/foo :a))
  (t/expect :b (c/foo :b)))

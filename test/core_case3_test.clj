(ns core-case3-test
  "Tests having more than two assertions one of which is a thrown? works."
  (:require
   [expectations.clojure.test :as t]
   [core :as c]))

(t/defexpect foo-test
  (t/expecting "throws when :a"
    (t/expect IllegalArgumentException (c/foo :a)))

  (t/expecting "returns :b when :b"
    (t/expect :b (c/foo :b)))

  (t/expecting "returns :c when :c"
    (t/expect :b (c/foo :b))))

(t/defexpect foo-test--another-order
  (t/expecting "returns :b when :b"
    (t/expect :b (c/foo :b)))

  (t/expecting "throws when :a"
    (t/expect IllegalArgumentException (c/foo :a)))

  (t/expecting "returns :c when :c"
    (t/expect :b (c/foo :b))))

(t/defexpect foo-test--two-thrown
  (t/expect :b (c/foo :b))
  (t/expect IllegalArgumentException (c/foo :a))
  (t/expect IllegalArgumentException (c/foo :a))
  (t/expect :b (c/foo :b)))

(t/defexpect foo-test--wo-expecting
  (t/expect :b (c/foo :b))
  (t/expect IllegalArgumentException (c/foo :a))
  (t/expect :b (c/foo :b)))

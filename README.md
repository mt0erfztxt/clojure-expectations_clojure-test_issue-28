# clojure.test for Expectations issue

Test fails when it has exactly two assertions, and one of them is a "thrown?"
assertion.

```sh
$ ./bin/kaocha
[(.)(..F..F..F..F)(.............)]

FAIL in core-case2-test/foo-test--throw-plus-one-does-not-work (core_case2_test.clj:8)
(t/expecting "returns :b when :b" (t/expect :b (c/foo :b)))

Expected:
  #<java.lang.IllegalArgumentException@5f92e5eb java.lang.IllegalArgumentException: input is :a>
Actual:
  -#<java.lang.IllegalArgumentException@5f92e5eb java.lang.IllegalArgumentException: input is :a>
  +true

FAIL in core-case2-test/foo-test--throw-plus-one-does-not-work--another-order (core_case2_test.clj:15)
(t/expecting "throws when :a" (t/expect IllegalArgumentException (c/foo :a)))

Expected:
  true
Actual:
  -true
  +#<java.lang.IllegalArgumentException@335cbcbd java.lang.IllegalArgumentException: input is :a>

FAIL in core-case2-test/foo-test--throw-plus-one-does-not-work--two-thrown (core_case2_test.clj:22)
(t/expecting "throws when :a" (t/expect IllegalArgumentException (c/foo :a)))

Expected:
  #<java.lang.IllegalArgumentException@64c79b69 java.lang.IllegalArgumentException: input is :a>
Actual:
  -#<java.lang.IllegalArgumentException@64c79b69 java.lang.IllegalArgumentException: input is :a>
  +#<java.lang.IllegalArgumentException@a94c8e3 java.lang.IllegalArgumentException: input is :a>

FAIL in core-case2-test/foo-test--throw-plus-one-does-not-work--wo-expecting (core_case2_test.clj:29)
(t/expect :b (c/foo :b))

Expected:
  #<java.lang.IllegalArgumentException@54ee423f java.lang.IllegalArgumentException: input is :a>
Actual:
  -#<java.lang.IllegalArgumentException@54ee423f java.lang.IllegalArgumentException: input is :a>
  +true
9 tests, 26 assertions, 4 failures.
```

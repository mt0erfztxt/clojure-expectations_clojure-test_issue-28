(ns core)

(defn foo
  [input]
  (case input
    :a (throw (IllegalArgumentException. "input is :a"))
    :b :b
    :c :c))

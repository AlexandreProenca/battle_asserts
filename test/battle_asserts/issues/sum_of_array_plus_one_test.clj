(ns battle-asserts.issues.sum-of-array-plus-one-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.properties :as prop :include-macros true]
            [clojure.test.check.clojure-test :as ct :include-macros true]
            [test-helper :as h]
            [battle-asserts.issues.sum-of-array-plus-one :as issue]))

(ct/defspec spec-solution
  20
  (prop/for-all [v (issue/arguments-generator)]
                (= (apply issue/solution v)
                   (apply + (count (first v)) (first v)))))

(deftest test-solution
  (h/generate-tests issue/test-data issue/solution))

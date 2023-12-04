(ns lprakashv.adventofcode2023-test
  (:require [clojure.test :refer :all]
            [lprakashv.adventofcode2023.day1 :as day1]))

(deftest run
  (testing "Day 1-1"
           (is (= 53921 (day1/calibration-sum-1))))
  (testing "Day 1-2"
           (is (= 54676 (day1/calibration-sum-2)))))
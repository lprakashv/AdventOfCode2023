(ns lprakashv.adventofcode2023.main
  (:gen-class)
  (:require [lprakashv.adventofcode2023.day1 :as day1]))

(defn -main
  [_]
  (println (apply str
                  "Solutions:\n"
                  "\tday1-1 => "  (day1/calibration-sum-1) "\n"
                  "\tday1-2 => "  (day1/calibration-sum-2) "\n")))

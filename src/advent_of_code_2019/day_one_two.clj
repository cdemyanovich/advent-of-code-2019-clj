(ns advent-of-code-2019.day-one-two
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))

(def input
  (->> "data/1-2.txt"
       io/resource
       io/reader
       line-seq))

(def masses
  (map edn/read-string input))

(defn- fuel-needed'
  "Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2."
  [mass]
  (-> mass
      (/ 3)
      Math/floor
      (- 2)
      int))

(defn fuel-needed
  "Fuel itself requires fuel just like a module - take its mass, divide by three, round down, and subtract 2. However, that fuel also requires fuel, and that fuel requires fuel, and so on. Any mass that would require negative fuel should instead be treated as if it requires zero fuel; the remaining mass, if any, is instead handled by wishing really hard, which has no mass and is outside the scope of this calculation."
  [mass]
  (reduce + (rest (take-while pos? (iterate fuel-needed' mass)))))

(defn total-fuel-needed
  "Sums the fuel needed for all of the given masses"
  [masses]
  (if (empty? masses)
    0
    (->> masses
         (map fuel-needed)
         (reduce +))))

(ns advent-of-code-2019.day-one-one-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2019.day-one-one :refer :all]))

(deftest calculates-fuel-needed
  (testing "A mass of 12 needs fuel of 2"
    (is (= 2 (fuel-needed 12))))

  (testing "A mass of 14 needs fuel of 2"
    (is (= 2 (fuel-needed 12))))

  (testing "A mass of 1969 needs fuel of 654"
    (is (= 654 (fuel-needed 1969))))

  (testing "A mass of 100756 needs fuel of 33583"
    (is (= 33583 (fuel-needed 100756)))))

(deftest calculates-total-fuel-needed
  (testing "Calculates the total for 0 masses"
    (is (= 0 (total-fuel-needed []))))

  (testing "Calculates the total for 1 mass"
    (is (= 2 (total-fuel-needed [12]))))

  (testing "Calculates the total for many  masses"
    (is (= (reduce + [2 2 654 33583])
           (total-fuel-needed [12 12 1969 100756])))))

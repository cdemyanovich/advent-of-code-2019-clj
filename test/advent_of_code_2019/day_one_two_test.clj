(ns advent-of-code-2019.day-one-two-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2019.day-one-two :refer :all]))

(deftest calculates-fuel-needed
  (testing "A mass of 0 needs fuel of 0"
    (is (= 0 (fuel-needed 0))))

  (testing "A mass of 1 needs fuel of 0"
    (is (= 0 (fuel-needed 1))))

  (testing "A mass of 8 needs fuel of 0"
    (is (= 0 (fuel-needed 8))))

  (testing "A mass of 9 needs fuel of 1"
    (is (= 1 (fuel-needed 9))))

  (testing "A mass of 14 needs fuel of 2"
    (is (= 2 (fuel-needed 14))))

  (testing "A mass of 1969 needs fuel of 966"
    (is (= 966 (fuel-needed 1969))))

  (testing "A mass of 100756 needs fuel of 50346"
    (is (= 50346 (fuel-needed 100756)))))

(deftest calculates-total-fuel-needed
  (testing "Calculates the total for 0 masses"
    (is (= 0 (total-fuel-needed []))))

  (testing "Calculates the total for 1 mass"
    (is (= 2 (total-fuel-needed [12]))))

  (testing "Calculates the total for many  masses"
    (is (= (reduce + [2 2 966 50346])
           (total-fuel-needed [12 12 1969 100756])))))

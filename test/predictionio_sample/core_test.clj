(ns predictionio-sample.core-test
  (:require [clojure.test :refer :all]
            [predictionio-sample.core :refer :all]
            [cheshire.core :refer :all]))

(deftest test-user-create
  (testing "User create"
    (let [result (user-create {:pio_uid 1})]
      (is (= 201 (:status result))))))

(deftest test-user-get
  (testing "User retrieve"
    (user-create {:pio_uid 1})
    (let [result (user-get 1)]
      (is (= 200 (:status result)))
      (is (= "1" (get (parse-string (:body result)) "pio_uid"))))))

(deftest test-user-delete
  (testing "User delete"
    (let [result (user-delete 1)]
      (is (= 200 (:status result))))))

(deftest test-item-create
  (testing "Item create"
    (let [result (item-create {:pio_iid 1 :pio_itypes "post"})]
      (is (= 201 (:status result))))))

(deftest test-item-get
  (testing "Item retrieve"
    (item-create {:pio_iid 1 :pio_itypes "post"})
    (let [result (item-get 1)]
      (is (= 200 (:status result)))
      (is (= "1" (get (parse-string (:body result)) "pio_iid")))
      (is (= "post") (get (parse-string (:body result)) "pio_itype")))))

(deftest test-item-delete
  (testing "Item delete"
    (let [result (item-delete 1)]
      (is (= 200 (:status result))))))

(deftest test-behavior-create
  (testing "Behavior create"
    (let [result (behavior-create {:pio_uid 1 :pio_iid 1 :pio_action "view"})]
      (is (= 201 (:status result))))))

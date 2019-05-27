(ns sandbox.core
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :as scad]
            [scad-clj.text :refer :all]
            [scad-clj.model :refer :all]))

(def smooth 50)

(defn deg2rad [degrees]
  (* (/ degrees 180) pi))

(def dummy-wall
   (translate [-5 0 0] (cube 40 3 20 :center false)))

(defn screw-insert-shape [bottom-radius top-radius height] 
   (union (binding [*fn* smooth] (cylinder [bottom-radius top-radius] height))
          (translate [0 0 (/ height 2)] (binding [*fn* smooth] (sphere top-radius)))))

(defn screw-insert [column row bottom-radius top-radius height offset] 
    (->> (screw-insert-shape bottom-radius top-radius height)
         (translate (map + offset [0 0 (/ height 2)]))))

(defn screw-insert-all-shapes [bottom-radius top-radius height]
  (union (screw-insert       0 0 (- bottom-radius 0.1) (- top-radius 0.1) height [ 0 0 0]) ;; 3.15
         (screw-insert       0 0    bottom-radius         top-radius      height [10 0 0])
         (screw-insert       0 0 (+ bottom-radius 0.1) (+ top-radius 0.1) height [20 0 0])
         ))
(def screw-insert-height 4.8)               ;; SB-3006CD
(def screw-insert-bottom-radius (/ 5.0 2))  ;; SB-3006CD
(def screw-insert-top-radius (/ 4.5 2))     ;; SB-3006CD
(def screw-insert-holes  (screw-insert-all-shapes screw-insert-bottom-radius screw-insert-top-radius screw-insert-height))
(def screw-insert-outers (screw-insert-all-shapes (+ screw-insert-bottom-radius 1.6) (+ screw-insert-top-radius 1.6) (+ screw-insert-height 1.5)))

(def base (cube 10 10 10))

(def screw-insert

  (difference (union
               dummy-wall 
               screw-insert-outers)
              (union
               screw-insert-holes)))


;; main
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (spit "screw-insert.scad" (scad/write-scad screw-insert))
  )

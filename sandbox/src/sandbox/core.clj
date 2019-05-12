(ns sandbox.core
  (:refer-clojure :exclude [use import])
  (:require [scad-clj.scad :as scad]
            [scad-clj.text :refer :all]
            [scad-clj.model :refer :all]))

(def smooth 100)

(defn deg2rad [degrees]
  (* (/ degrees 180) pi))

(def arrow
  (let [points [[0  0 0]    ;; 0
                [4 0 0]    ;; 1
                [2 2 0]    ;; 2
                [0 0 -1]    ;; 3
                [4 5 -1]    ;; 4
                [2 5 -1]]   ;; 5
        faces [[0 1 2]
               [3 4 5]
               [0 1 4 3]
               [0 2 5 3]
               [2 1 4 5]]]
  (union
     (polyhedron points faces)
     (cube 2 10 -1))))

(def dummy-wall
  (difference
   (translate [0 0 1.5] (cube 20 20 3))
   (translate [0 0 0] arrow)))

(def latch-slit
    (cube 8.5 1 3 :center false))

(def latch-not
  (rotate (deg2rad 350) [0 1 0]
          (cube 4 4.2 1.5 :center false)))

(def latch-old
  (let [points [[0    0 0]    ;; 0
                [-4 0 0]    ;; 1
                [0    0 -2.5]    ;; 2
                [0    5 0]    ;; 3
                [-4 5 0]    ;; 4
                [0    5 -2.5]]   ;; 5
        faces [[0 1 2]
               [3 4 5]
               [0 1 4 3]
               [0 2 5 3]
               [2 1 4 5]]]
     (polyhedron points faces)
     ))

(def latch
  (difference
   (translate [-6 0.4 -1.5] 
              (cube 5 4.2 1.5 :center false))
   (translate [-6.5 0.4 -1.7]
              (rotate (deg2rad 20) [0 1 0]
                      (cube 4 4.2 1.5 :center false)))))


(def jack-enclosure
  (let [body-len (+ 12.1 0.2 3)]
    ;; (translate [(- (+ 5 0.2 2 -6)) 0 1.7]
    (translate [(- (+ 5 0.2 2 -6)) (- (/ (+ 6 (* 2 2)) 2)) 1.7]
    ;; (translate [0 (- (/ (+ 6 (* 2 2)) 2)) 0]
               (difference
               ;; (union
                (union
                 (cube (+ 4 2) (+ 6 (* 2 2)) (+ 12.1 1) :center false)
                 (translate [1 2.5 (+ 12.1 1)] latch))
                (translate [-4 1.9 (- 12.1 1.7)] latch-slit)
                (translate [-4 7.1 (- 12.1 1.7)] latch-slit)
                 
                ;; (translate [(- 3.5 5.2 0.2) (/ (+ 6 0.2) 2) 1.7]
                ;;            (cube 4.5 2 (- 12.1 0.2 1) :center false))
                ;; ;; (translate [(- 3.5 5.2 0.2) (- (/ (+ 6 0.2) 2 2)) 1.7]
                ;; (translate [(- 3.5 5.2 0.2) (- (+ (/ (+ 6 0.2) 2) 2)) 1.7]
                ;;            (cube 4.5 2 (- 12.1 0.2 1) :center false))
                ;; (translate [(/ (+ 5.2 0.2) 2) (- (+ (/ (+ 6 0.2) 2) 2)) 1.7]
                ;;            (cube 2 10 (+ 12.1 0.2 2) :center false))
                ))))

(def trrs-receptacle
  (let [tip-thick 1.7
        body-len (+ 12.1 0.2)]
    (union
     (binding [*fn* smooth] (cylinder (/ 5 2) 1.7 :center false))
     (translate [0 0 (+ (/ body-len 2) tip-thick)]
                (union
                 (cube (+ 5 0.2) (+ 6 0.2) body-len)
                 (translate [(/ 5 2) (+ (/ -6 2) 1.5) 0]
                            (cube 1 3 body-len))
                 (translate [(/ -10 2) (+ (/ -6 2) 0.25) 1.25]
                            (cube 5 0.5 8))
                 (translate [(/ -10 2) (- (/ 6 2) 0.25) 5.3]
                            (cube 5 0.5 1.5))
                 )))
    ;; (translate [0 0 (/ 12.1 2)])
    ;; (rotate (deg2rad  90) [0 90 0]))

    ;; (model/cylinder 50 200) ;; r lz
    ;; (model/sphere 100)      ;; r
    ;; (model/cylinder (/ 5 2) 1.7 :center false)
    )) 

(def test1
  (rotate (deg2rad 10) [0 1 0]
  (cube 4 4.2 1.5 :center false))
  ;; (difference
  ;;  (cube 3 3 3)
  ;;  (cube 5 2 2)) 

  )

(def trrs-port
   ;; test1)

   (difference
    (union
     dummy-wall
     jack-enclosure)
    trrs-receptacle
   ))


;; main
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (spit "trrs-port.scad" (scad/write-scad trrs-port))
  )


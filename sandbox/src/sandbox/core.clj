(ns sandbox.core
  (:require [scad-clj.scad :as scad]
            [scad-clj.model :as model]))
(def simple-cube
  (model/cube 10 10 10))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (spit "simple-cube.scad" (scad/write-scad simple-cube)))


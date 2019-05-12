difference () {
  union () {
    difference () {
      translate ([0, 0, 1.5]) {
        cube ([20, 20, 3], center=true);
      }
      translate ([0, 0, 0]) {
        union () {
          polyhedron (points=[[0, 0, 0], [4, 0, 0], [2, 2, 0], [0, 0, -1], [4, 5, -1], [2, 5, -1]], faces=[[0, 1, 2], [3, 4, 5], [0, 1, 4, 3], [0, 2, 5, 3], [2, 1, 4, 5]]);
          cube ([2, 10, -1], center=true);
        }
      }
    }
    translate ([-1.2000000000000002, -5, 1.7]) {
      difference () {
        union () {
          cube ([6, 10, 13.1]);
          translate ([1, 2.5, 13.1]) {
            difference () {
              translate ([-6, 0.4, -1.5]) {
                cube ([5, 4.2, 1.5]);
              }
              translate ([-6.5, 0.4, -1.7]) {
                rotate (a=20.0, v=[0, 1, 0]) {
                  cube ([4, 4.2, 1.5]);
                }
              }
            }
          }
        }
        translate ([-4, 1.9, 10.4]) {
          cube ([8.5, 1, 3]);
        }
        translate ([-4, 7.1, 10.4]) {
          cube ([8.5, 1, 3]);
        }
      }
    }
  }
  union () {
    cylinder ($fn=100, h=1.7, r=5/2);
    translate ([0, 0, 7.85]) {
      union () {
        cube ([5.2, 6.2, 12.299999999999999], center=true);
        translate ([5/2, -1.5, 0]) {
          cube ([1, 3, 12.299999999999999], center=true);
        }
        translate ([-5, -2.75, 1.25]) {
          cube ([5, 0.5, 8], center=true);
        }
        translate ([-5, 2.75, 5.3]) {
          cube ([5, 0.5, 1.5], center=true);
        }
      }
    }
  }
}

rotate (a=90.0, v=[1, 0, 0]) {
  difference () {
    union () {
      translate ([0, 0, 1.5]) {
        cube ([20, 20, 3], center=true);
      }
      rotate (a=-10.000000000000002, v=[0, 0, 1]) {
        translate ([-1.2000000000000002, -5, 1.7]) {
          difference () {
            union () {
              cube ([6, 10, 14.1]);
              translate ([1.2, 9, 10.5]) {
                rotate (a=-90.0, v=[1, 0, 0]) {
                  difference () {
                    translate ([-6, 0.4, -1.5]) {
                      cube ([5, 6.2, 1.5]);
                    }
                    translate ([-6.5, 0.4, -1.7]) {
                      rotate (a=20.0, v=[0, 1, 0]) {
                        cube ([4, 6.2, 1.5]);
                      }
                    }
                  }
                }
              }
            }
            translate ([0, 9, 3.5]) {
              cube ([5, 3, 7]);
            }
            translate ([2.5, 1.9, 10]) {
              rotate (a=-59.99999999999999, v=[0, 1, 0]) {
                cube ([2, 6.2, 5]);
              }
            }
            translate ([-3.5, 7, 10.1]) {
              cube ([8.5, 3, 1.5]);
            }
            translate ([-3.5, 7, 2.4]) {
              cube ([8.5, 3, 1.5]);
            }
          }
        }
      }
    }
    rotate (a=-10.000000000000002, v=[0, 0, 1]) {
      union () {
        cylinder ($fn=100, h=2.2, r=2.6);
        translate ([0, 0, 8.0]) {
          union () {
            cube ([5.2, 6.2, 12.6], center=true);
            translate ([5/2, -1.5, 0]) {
              cube ([1, 3, 12.6], center=true);
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
  }
}

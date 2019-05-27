difference () {
  union () {
    translate ([-5, 0, 0]) {
      cube ([40, 3, 20]);
    }
    union () {
      translate ([0, 0, 3.15]) {
        union () {
          cylinder ($fn=50, h=6.3, r1=3.9500000000000006, r2=3.7, center=true);
          translate ([0, 0, 3.15]) {
            sphere ($fn=50, r=3.7);
          }
        }
      }
      translate ([10, 0, 3.15]) {
        union () {
          cylinder ($fn=50, h=6.3, r1=4.050000000000001, r2=3.8000000000000003, center=true);
          translate ([0, 0, 3.15]) {
            sphere ($fn=50, r=3.8000000000000003);
          }
        }
      }
      translate ([20, 0, 3.15]) {
        union () {
          cylinder ($fn=50, h=6.3, r1=4.15, r2=3.9000000000000004, center=true);
          translate ([0, 0, 3.15]) {
            sphere ($fn=50, r=3.9000000000000004);
          }
        }
      }
    }
  }
  union () {
    union () {
      translate ([0, 0, 2.4]) {
        union () {
          cylinder ($fn=50, h=4.8, r1=2.35, r2=2.1, center=true);
          translate ([0, 0, 2.4]) {
            sphere ($fn=50, r=2.1);
          }
        }
      }
      translate ([10, 0, 2.4]) {
        union () {
          cylinder ($fn=50, h=4.8, r1=2.45, r2=2.2, center=true);
          translate ([0, 0, 2.4]) {
            sphere ($fn=50, r=2.2);
          }
        }
      }
      translate ([20, 0, 2.4]) {
        union () {
          cylinder ($fn=50, h=4.8, r1=2.5500000000000003, r2=2.3000000000000003, center=true);
          translate ([0, 0, 2.4]) {
            sphere ($fn=50, r=2.3000000000000003);
          }
        }
      }
    }
  }
}

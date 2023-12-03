package pkg

import "testing"

func TestCalibrationSum1(t *testing.T) {
	want := 53921

	if got := CalibrationSum1(); got != want {
		t.Errorf("CalibrationSum1() = %v, want %v", got, want)
	}
}

func TestCalibrationSum2(t *testing.T) {
	want := 54676

	if got := CalibrationSum2(); got != want {
		t.Errorf("CalibrationSum2() = %v, want %v", got, want)
	}
}

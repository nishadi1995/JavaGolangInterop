package main

import "C"

import (
	"encoding/base64"
	"io"
	"math"
	"os"
)

var num = 10

//export SetNum
func SetNum(n int) {
	num = n
}

//export GetNum
func GetNum() int {
	return num
}

//export Add
func Add(a, b int) int {
	return a + b
}

//export Cos
func Cos(x float64) float64 {
	return math.Cos(x)
}

//export Base64
func Base64(str string) *C.char {
	x := base64.StdEncoding.EncodeToString([]byte(str))
	return C.CString(x)
}

//export Sum
func Sum(numbers []int) int {
	total := 0
	for _, num := range numbers {
		total += num
	}
	return total
}

//export ByteTest
func ByteTest(data []byte) {
	f, _ := os.Create("/tmp/goRandFile")
	defer f.Close()

	f.Write(data)
}

//export FilePassTest
func FilePassTest(filePath []byte) {
	inputFile := string(filePath)
	outputFile := "/tmp/goRandFile"

	inFile, _ := os.Open(inputFile)
	defer inFile.Close()

	outFile, _ := os.Create(outputFile)
	defer outFile.Close()

	io.Copy(outFile, inFile)
}

func main() {}
